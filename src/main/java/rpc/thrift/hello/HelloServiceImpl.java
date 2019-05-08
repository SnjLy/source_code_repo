package rpc.thrift.hello;

import org.apache.thrift.TException;

/**
 * rpc.thrift.hello
 *
 * @author: liuyong
 * @date: 2019-05-08
 */
public class HelloServiceImpl implements rpc.thrift.hello.Hello.Iface {


    @Override
    public String hello(String param) throws TException {
        return "result:" + param;
    }
}
