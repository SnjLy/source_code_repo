package design.pattern.structuremode.composite.common_composite;

import java.util.ArrayList;

/**
 * @Package: design.pattern.structuremode.composite.common_composite
 * @Description:  子构建  递归处理业务方法
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/6/15.
 */
public class Composite extends Component {

    private ArrayList<Component> list = new ArrayList<>();

    @Override
    public void add(Component c) {
        list.add(c);
    }

    @Override
    public void remove(Component c) {
        list.remove(c);
    }

    @Override
    public Component getChile(int i) {
        return list.get(i);
    }

    @Override
    public String operation() {
        for (Object obj : list){
            ((Component)obj).operation();
        }
        return "success";
    }
}
