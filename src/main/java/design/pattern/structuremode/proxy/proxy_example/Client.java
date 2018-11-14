package design.pattern.structuremode.proxy.proxy_example;

/**
 * @Package: design.pattern.structuremode.proxy.proxy_example
 * @Description:   本实例是保护代理和智能引用代理的应用实例，在代理类ProxySearcher中实现对真实主题类的 权限控制和引用计数，
 *                  如果需要在访问真实主题时增加新的访问控制机制和新功能，只需增 加一个新的代理类，再修改配置文件，
 *                  在客户端代码中使用新增代理类即可，源代码无须修改，符合开闭原则。
 * @function:
 * @Author : LiuYong
 * Created by yehao on 2018/9/11.
 */
public class Client {
    public static void main(String[] args) {

        /*
         *  此处之后改为通过配置获取，通过反射生成真实的类
         */
        BusinessInterface businessInterface = new ProxyImpl("proxy");
        businessInterface.operate();
    }
}
