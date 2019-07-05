package netty.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * netty.selector
 *
 * @author: SNJly
 * @date: 2019-07-04
 */
public class InitSelector {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssc=ServerSocketChannel.open();
        //绑定地址和port
        ssc.socket().bind(new InetSocketAddress("localhost",80));
        //通道在被注册到一个选择器上之前，必须先设置为非阻塞模式（通过调用 configureBlocking(false)）
        ssc.configureBlocking(false);
        //创建Selector
        //方式二：
        //SelectorProvider provider = SelectorProvider.provider();
        //Selector abstractSelector = provider.openSelector();
        Selector selector = Selector.open();
        //注册ServerSocketChannel
        //如果您试图注册一个处于阻塞状态的通道， register()将抛出未检查的 IllegalBlockingModeException 异常
        SelectionKey sscSelectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        while(true){
            SocketChannel sc = ssc.accept();
            if(sc==null){
                continue;
            }
            sc.configureBlocking(false);
            //注册SocketChannel
            SelectionKey scselectionKey = sc.register(selector, SelectionKey.OP_ACCEPT | SelectionKey.OP_WRITE);
            //...其他操作

            //同时选择键包含指示了该注册关系所关心的通道操作，以及通道已经准备好的操作。
            //感兴趣的操作
            int interestOps = scselectionKey.interestOps();
            //通过调用键的 readyOps( )方法来获取相关的通道的已经就绪的操作
            int i = scselectionKey.readyOps();
        }
    }
}
