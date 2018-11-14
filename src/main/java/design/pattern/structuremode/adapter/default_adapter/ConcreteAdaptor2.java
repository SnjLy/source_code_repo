package design.pattern.structuremode.adapter.default_adapter;

/**
 * Created by yehao on 2018/6/7.
 */
public class ConcreteAdaptor2 extends AbstractAdaptor {

    @Override
    public void post() {
        System.out.println(this.getClass().getName());
    }
}
