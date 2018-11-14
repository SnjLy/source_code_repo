package design.pattern.structuremode.composite.common_composite;

/**
 * @Package: design.pattern.structuremode.composite.common_composite
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public class Leaf extends Component{

    @Override
    public void add(Component c) {
        System.out.println("error, leaf don't have child");
    }

    @Override
    public void remove(Component c) {
        System.out.println("error, leaf don't have child");
    }

    @Override
    public Component getChile(int i) {
        System.out.println("error, leaf don't have child");
        return null;
    }

    @Override
    public String operation() {
        System.out.printf("execute leaf operation method");
        return this.getClass().getSimpleName();
    }
}
