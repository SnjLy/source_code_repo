package netty.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * netty.channel
 *
 * @author: SNJly
 * @date: 2019-07-04
 */
public class ChannelAccept {

    public static final String GREETING = "Hello I must be going.";

    public static void main(String[] args) throws IOException, InterruptedException {
        // default port
        int port = 1234;
        if (args.length > 0){
            port = Integer.parseInt(args[0]);
        }
        ByteBuffer byteBuffer = ByteBuffer.wrap(GREETING.getBytes());
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //监听port
        ssc.socket().bind(new InetSocketAddress(port));
        //通过调用configureBlocking(boolean)方法即可，传递参数值为 true 则设为阻塞模式，
        //参数值为 false 值设为非阻塞模式。而 isBlocking()方法来判断某个 socket 通道当前处于哪种模式
        ssc.configureBlocking(false);
        while (true){
            System.out.println("waiting for connection");
            SocketChannel sc = ssc.accept();
            if (null == sc){
                Thread.sleep(2000);
            }else {
                sc.configureBlocking(false);
                ByteBuffer allocate = ByteBuffer.allocate(16 * 1024);
                while (sc.read(allocate)>0){
                    allocate.flip();
                    while (byteBuffer.hasRemaining()){
                        byte b = byteBuffer.get();
                        System.out.println(b);
                    }
                    allocate.clear();
                }
                System.out.println("Incoming connection from:" + sc.socket().getRemoteSocketAddress());
                byteBuffer.rewind();
                sc.write(byteBuffer);
                sc.close();
            }
        }
    }
}
