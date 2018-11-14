package design.pattern.createmode.prototype;

/*import com.sun.deploy.net.protocol.ProtocolType;
import org.springframework.util.Assert;

*//**
 * Created by yehao on 2018/5/17.
 *//*
public class PrototypeMode1 implements ProtocolType {
    private String attr;

    public String getAttr() {
        return attr;
    }

    public void setAttr(String attr) {
        this.attr = attr;
    }

    @Override
    public ProtocolType clone(){
        PrototypeMode1 mode1 = new PrototypeMode1();
        mode1.setAttr(this.attr);
        return mode1;
    }


    public static void main(String[] args) {
        PrototypeMode1 mode1 = new PrototypeMode1();
        mode1.setAttr("mode1");

        PrototypeMode1 mode2 = (PrototypeMode1) mode1.clone();
        Assert.isTrue(mode1.getAttr().equals(mode2.getAttr()));
        Assert.isTrue(mode1 != mode2);

    }
}*/
