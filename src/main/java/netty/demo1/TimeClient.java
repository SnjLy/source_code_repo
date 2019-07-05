package netty.demo1;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty.demo1
 * <p>TimeClient负责与服务端的${port}端口建立连接</p>
 *
 * @author: SNJly
 * @date: 2019-07-04
 */
public class TimeClient {

    public static void main(String[] args) {
        String local = "localhost";
        int port = 8080;
        EventLoopGroup workGroup = new NioEventLoopGroup(2);

        try {
            Bootstrap bs = new Bootstrap();
            bs.group(workGroup)
                    //通过channel方法指定了NioSocketChannel，这是netty在nio编程中用于表示客户端的对象实例。
                    .channel(NioSctpChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {

                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            socketChannel.pipeline().addLast(new StringDecoder());
                            socketChannel.pipeline().addLast(new TimeClientHandler());
                        }
                    });

            ChannelFuture future = bs.connect(local, port).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            workGroup.shutdownGracefully();
        }
    }
}
