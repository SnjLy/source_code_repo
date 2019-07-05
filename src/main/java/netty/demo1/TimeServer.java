package netty.demo1;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty.demo1
 * <p>时间服务器TimeServer在端口${port}监听客户端请求</p>
 *
 * @author: SNJly
 * @date: 2019-07-04
 */
public class TimeServer {
    private int port = 8080;

    public void run() {
        //bossGroup用于接受客户端连接，bossGroup在接受到客户端连接之后，将连接交给workerGroup来进行处理， 可以理解为线程池
        EventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap sbt = new ServerBootstrap();
            sbt.group(boosGroup, workGroup)
                    //通过channel方法指定了NioServerSocketChannel，这是netty中表示服务端的类，用于接受客户端连接，对应于java.nio包中的ServerSocketChannel
                    .channel(NioSctpServerChannel.class)
                    //通过childHandler方法，设置了一个匿名内部类ChannelInitializer实例，用于初始化客户端连接SocketChannel实例。在第3步中，
                    // 我们提到NioServerSocketChannel是用于接受客户端连接，在接收到客户端连接之后，netty会回调ChannelInitializer的initChannel方法需要对这个连接进行一些初始化工作，
                    // 主要是告诉netty之后如何处理和响应这个客户端的请求。在这里，主要是添加了3个ChannelHandler实例：LineBasedFrameDecoder、StringDecoder、TimeServerHandler。
                    // 其中LineBasedFrameDecoder、StringDecoder是netty本身提供的，用于解决TCP粘包、解包的工具类。
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024))
                                    .addLast(new StringDecoder())
                                    .addLast(new TimeServerHandler());
                        }
                    });
            ChannelFuture future = sbt.bind(port).sync();
            System.out.println("TimeServer started on " + port + "....");
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
            boosGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        new TimeServer().run();
    }
}
