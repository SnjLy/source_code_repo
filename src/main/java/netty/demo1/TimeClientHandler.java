package netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty.demo1
 * <p>TimeClientHandler主要用于给Server端发送"QUERY TIME ORDER”请求，并接受服务端响应。 </p>
 * @author: SNJly
 * @date: 2019-07-04
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

    private byte[] req=("time" + System.getProperty("line.separator")).getBytes();

    /**
     * 当客户端与服务端连接建立成功后，channelActive方法会被回调，我们在这个方法中给服务端发送请求。
     * @param ctx
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) {//1
        ByteBuf message = Unpooled.buffer(req.length);
        message.writeBytes(req);
        ctx.writeAndFlush(message);
    }

    /**
     * 当接受到服务端响应后，channelRead方法会被会回调，我们在这个方法中打印出响应的时间信息。
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("Now is:" + body);
    }

}
