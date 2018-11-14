package design.pattern.structuremode.adapter.default_adapter;

/**
 * Created by yehao on 2018/6/7.
 */
public class ConcreteAdaptor extends AbstractAdaptor {

    @Override
    public void resquest() {
        System.out.println(this.getClass().getName());
    }
}
