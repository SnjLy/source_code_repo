package design.pattern.structuremode.facade.abstract_facede;

/**
 * @Package: design.pattern.structuremode.facade.abstract_facede
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/6.
 */
public class ModeFadace implements AbstractFacade {
    private static final String filePath = "/tmp/logs";

    private ReadFile readFile;
    private WriteFile writeFile;
    private ModeEncrypt modeEncrypt;

    public ModeFadace() {
        this.readFile = new ReadFile();
        this.writeFile = new WriteFile();
        this.modeEncrypt = new ModeEncrypt();
    }

    @Override
    public String operateFile(String fileName) {
        String content = readFile.readFile(fileName);
        String mode = modeEncrypt.encrypt(content);
        writeFile.Write(mode, filePath);
        return "success";
    }
}
