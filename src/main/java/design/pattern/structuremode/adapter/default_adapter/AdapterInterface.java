package design.pattern.structuremode.adapter.default_adapter;

/**
 * 适配者接口, 通常声明了大量的方法
 *
 * Created by yehao on 2018/6/7.
 */
public interface AdapterInterface {
    public void resquest();
    public void get();
    public void post();
    public void response();
}
