package org.example.netty.chat;

import com.sun.nio.sctp.SctpChannel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundMessageHandlerAdapter;

import java.io.IOException;

public class ChatClientHandler extends ChannelInboundMessageHandlerAdapter<String> {

    public static void main(String[] args) throws IOException {
        try {
            SctpChannel sc = SctpChannel.open();
            sc.close();
        } finally {

        }

    }
    @Override
    public void messageReceived(ChannelHandlerContext channelHandlerContext, String str) throws Exception {
        System.out.println(str);

    }
}
