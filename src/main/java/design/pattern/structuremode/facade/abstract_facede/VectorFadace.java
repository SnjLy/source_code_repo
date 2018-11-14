package design.pattern.structuremode.facade.abstract_facede;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class VectorFadace implements AbstractFacade {
    private static final String FILE_PATH = "/tmp/logs";

    private ReadFile readFile;
    private WriteFile writeFile;
    private VectorEncrypt vectorEncrypt;

    public VectorFadace() {
        this.readFile = new ReadFile();
        this.writeFile = new WriteFile();
        this.vectorEncrypt = new VectorEncrypt();
    }

    @Override
    public String operateFile(String fileName) {
        String content = readFile.readFile(fileName);
        String mode = vectorEncrypt.encrypt(content);
        writeFile.Write(mode, FILE_PATH);
        return "success";
    }
}
