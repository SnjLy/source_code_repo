package design.pattern.structuremode.proxy.proxy_example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Package: design.pattern.structuremode.proxy.proxy_example
 * @Description:
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/11.
 */
public class ProxyImpl extends BusinessInterface {
    private RealBusinessImpl realBusiness;
    private String name;
    private Logger logger = LoggerFactory.getLogger(ProxyImpl.class);


    public ProxyImpl(String name) {
        this.name = name;
    }

    /**
     * 业务接口，由实现类实现具体业务逻辑
     *
     * @return
     */
    @Override
    public String operate() {
        super.display();
        realBusiness = new RealBusinessImpl();
        display();
        return realBusiness.operate();
    }

    @Override
    public void display(){
        System.out.println("我是代理类的显示方法，name=" + this.name);
        //do other
        logger.info("记录信息");
    }
}
