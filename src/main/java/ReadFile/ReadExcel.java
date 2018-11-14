package ReadFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.StringTokenizer;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
    // 创建文件输入流
    private BufferedReader reader = null;
    // 文件类型
    private String filetype;
    // 文件二进制输入流
    private InputStream is = null;
    // 当前的Sheet
    private int currSheet;
    // 当前位置
    private int currPosition;
    // Sheet数量
    private int numOfSheets;
    // HSSFWorkbook
    HSSFWorkbook workbook = null;
    // 设置Cell之间以空格分割
    private static String EXCEL_LINE_DELIMITER = ",";

    // 构造函数创建一个ExcelReader
    public ReadExcel(String inputfile) throws IOException, Exception {
        // 判断参数是否为空或没有意义
        if (inputfile == null || inputfile.trim().equals("")) {
            throw new IOException("NO input file!!!");
        }
        // 取得文件名的后缀名赋值给filetype
        filetype = inputfile.substring(inputfile.lastIndexOf(".") + 1);

        // 设置开始行为0
        currPosition = 0;
        // 设置当前位置为0
        currSheet = 0;
        // 创建文件输入流
        is = new FileInputStream(inputfile);

        // 判断文件格式
        if (filetype.equalsIgnoreCase("xls")) {
            // 如果是Excel文件则创建HSSFWorkbook读取
            workbook = new HSSFWorkbook(is);
            // 设置Sheet数
            numOfSheets = workbook.getNumberOfSheets();
        } else {
            throw new Exception("File Type incorrrect!");
        }
    }

    // 用于读取文件的一行
    public String readLine() throws IOException {
        // excel文件通过poi读取文件
        if (filetype.equalsIgnoreCase("xls")) {
            // 根据currSheet值获得当前的sheet
            HSSFSheet sheet = workbook.getSheetAt(currSheet);

            // 判断当前行是否到但前Sheet的结尾
            if (currPosition > sheet.getLastRowNum()) {
                // 当前行位置清零
                currPosition = 0;
                // 判断是否还有Sheet
                while (currSheet < numOfSheets - 1) {
                    // 得到下一张Sheet
                    currSheet += 1;
                    sheet = workbook.getSheetAt(currSheet);

                    // 当前行数是否已经到达文件末尾
                    if (currPosition > sheet.getLastRowNum()) {
                        // 当前Sheet指向下一张Sheet
                        currSheet++;
                        continue;
                    } else {
                        // 获取当前行数
                        int row = currPosition;
                        currPosition++;
                        // 读取当前行数据
                        return getLine(sheet, row);
                    }
                }
                return null;
            }
            // 获取当前行数
            int row = currPosition;
            currPosition++;
            // 读取当前行数据
            return getLine(sheet, row);
        }
        return null;
    }

    // 返回Sheet的一行数据
    private String getLine(HSSFSheet sheet, int row) {
        // 根据行数取得Sheet的一行
        HSSFRow rowline = sheet.getRow(row);
        // 创建字符创缓冲区
        StringBuffer buffer = new StringBuffer();
        // 获取当前行的列数
        int filledColumns = rowline.getLastCellNum();
        HSSFCell cell = null;
        // 循环遍历所有列
        for (int i = 0; i < filledColumns; i++) {
            // 取得当前Cell
            cell = rowline.getCell((short) i);
            String cellvalue = null;
            if (cell != null) {
                // 判断当前Cell的Type
                switch (cell.getCellType()) {

                    // Cell的Type为NUMERIC
                    case HSSFCell.CELL_TYPE_NUMERIC: {
                        // 判断当前的cell是否为Date
                        if (HSSFDateUtil.isCellDateFormatted(cell)) {
                            // 如果是Date类型则，取得该Cell的Date值
                            Date date = cell.getDateCellValue();
                            // 把Date转换成本地格式的字符串
                            cellvalue = cell.getDateCellValue().toLocaleString();
                        } else { // 如果是纯数字
                            // 取得当前Cell的数值,强制转换为int
                            Integer num = new Integer(
                                    (int) cell.getNumericCellValue());
                            cellvalue = String.valueOf(num);
                        }
                        break;
                    }
                    // Cell的Type为STRING
                    case HSSFCell.CELL_TYPE_STRING:
                        // 取得当前的Cell字符串
                        cellvalue = cell.getStringCellValue().replaceAll("'", "''");
                        break;
                    // 默认的Cell值
                    default:
                        cellvalue = " ";
                }
            } else {
                cellvalue = "";
            }
            // 在每个字段之间插入分割符
            buffer.append(cellvalue).append(EXCEL_LINE_DELIMITER);
            // 去除最后一个分隔符
            buffer.substring(0, buffer.length() - 1);
        }
        return buffer.toString();
    }

    // 关闭资源
    public void closeResource() {
        try {
            if (is != null)
                is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // 测试case
    public static void main(String[] args) {
        try {
            ReadExcel er = new ReadExcel("C:\\Users\\admin\\Desktop\\date.xls");
            String line = er.readLine();
            //得到excel数据后，写处理数据的代码就可以了，如：插入数据库等等
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
