package com.github.lihongjie.core.base.util;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;

public class NetUtils {

    public static void formatAddress(
            final StringBuilder buffer,
            final SocketAddress socketAddress
            ) {
        Args.notNull(buffer, "Buffer");
        Args.notNull(socketAddress, "Socket address");
        if (socketAddress instanceof InetSocketAddress) {
            final InetSocketAddress socketaddr = (InetSocketAddress) socketAddress;
            final InetAddress inetAddress = ((InetSocketAddress) socketAddress).getAddress();
            buffer.append(inetAddress != null ? inetAddress.getHostAddress() : inetAddress)
                    .append(":").append(socketaddr.getPort());
        } else {
            buffer.append(socketAddress);
        }
    }
}
