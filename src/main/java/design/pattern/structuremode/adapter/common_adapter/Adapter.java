package design.pattern.structuremode.adapter.common_adapter;

/**
 *
 * Adapter(适配器类):适配器可以调用另一个接口，作为一个转换器，对Adaptee和Target进 行适配，
 * 适配器类是适配器模式的核心，在对象适配器中，它通过继承Target并关联一个 Adaptee对象使二者产生联系
 *
 * Created by yehao on 2018/6/7.
 */
public class Adapter extends Target {

    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }


    @Override
    public void request(){
        System.out.println(this.getClass().getName() + " override request doing");
        adaptee.specialMethod();
    }

    @Override
    public String request(int type) {
        String s = adaptee.specialMethod();
        System.out.println(this.getClass().getName() + " override " + s);
        return s;
    }
}
