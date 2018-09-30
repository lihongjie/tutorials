package com.github.lihongjie.netty;

import javax.net.SocketFactory;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SocketFactoryUtilTest {

    public static final String HOST = "58.247.0.18";

    public static final int PORT = 8203;

    public static void main(String[] args) throws IOException {

        // 正确 获取token
//        String data = "000360<?xml version=\"1.0\" encoding=\"GBK\"?><UMSFX xmls=\"http://www.chinaums.com/UMSFX/1.0\"><ReqHeader><TransCode>IFPP213</TransCode><SrcReqDate>20180820</SrcReqDate><SrcReqTime>195435</SrcReqTime><SrcReqId>0000000001</SrcReqId><ChannelId>04960000</ChannelId><MAC>25bbdcd06c32d477f7fa1c3e4a91b032</MAC></ReqHeader><ReqBody><stdprono>3</stdprono>0001</ReqBody></UMSFX>\n";

        String data = "<?xml version=\"1.0\" encoding=\"GBK\"?><UMSFX xmls=\"http://www.chinaums.com/UMSFX/1.0\"><ReqHeader><TransCode>IFPP212</TransCode><SrcReqDate>20180819</SrcReqDate><SrcReqTime>195435</SrcReqTime><SrcReqId>0000000002</SrcReqId><ChannelId>04960000</ChannelId><MAC>ACD1F98C33BEFFAB</MAC></ReqHeader><ReqBody><stdysuserno>000108944566</stdysuserno><stdprono>04960000001</stdprono><stdmerserno>9fba66de75904c488d8f784eae846394</stdmerserno><yf>201808</yf><token>210FD874820F49F9AF0834A1F28F9BE2</token></ReqBody></UMSFX>";
//        String data = "<?xml version=\"1.0\" encoding=\"GBK\"?><UMSFX xmls=\"http://www.chinaums.com/UMSFX/1.0\"><ReqHeader><TransCode>10001</TransCode><SrcReqDate>20180820</SrcReqDate><SrcReqTime>195435</SrcReqTime><SrcReqId>0000000001</SrcReqId><ChannelId>04960000</ChannelId><MAC>ACD1F98C33BEFFAB</MAC></ReqHeader><ReqBody><StdMerNo>32898121150613537</StdMerNo><StdYyzzDm>35234523451</StdYyzzDm><Std400IdTp>0</Std400IdTp><Std400IdNo>A42321197309107210</Std400IdNo><Std400CuNm>张三</Std400CuNm><startnum>1</startnum><recnum>5</recnum></ReqBody></UMSFX>";
                   System.out.println(data.length());
        String result = send2TcpServer(data.getBytes());

    }

    public static String send2TcpServer(byte[] data) throws IOException {
        SocketFactory socketFactory = null;
        Socket socket = null;
        InputStream inputStream = null;
        socketFactory = SocketFactory.getDefault();
        socket = socketFactory.createSocket(HOST, PORT);
        socket.setReceiveBufferSize(2048);
        socket.setSendBufferSize(2048);
        socket.setSoTimeout(5000);
        socket.setKeepAlive(false);
        socket.setTcpNoDelay(false);

        socket.getOutputStream().write(data);
        socket.getOutputStream().flush();

        inputStream = socket.getInputStream();

        System.out.println(1);
        socket.close();
        return "";
    }
}
