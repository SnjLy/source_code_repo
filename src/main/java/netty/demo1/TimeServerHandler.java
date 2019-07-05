package netty.demo1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.time.LocalDateTime;

/**
 * netty.demo1
 *
 * @author: SNJly
 * @date: 2019-07-04
 */
public class TimeServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext cxt, Object msg){
        String request = (String) msg;
        String response = null;
        if ("time".equals(request)){
            response = LocalDateTime.now().toString();
        }else {
            response = "bad request\n please input:time";
        }
        response = response + System.getProperty("line.separator");
        ByteBuf resp = Unpooled.copiedBuffer(response.getBytes());
        cxt.writeAndFlush(resp);
    }

}
