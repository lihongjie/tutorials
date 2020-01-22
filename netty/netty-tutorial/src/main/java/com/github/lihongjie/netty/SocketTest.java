package com.github.lihongjie.netty;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketTest {

//    public static void main(String[] args) {
//        try {
//            Socket s = new Socket("58.247.0.18",8203);
//
//            //构建IO
//            InputStream is = s.getInputStream();
//            OutputStream os = s.getOutputStream();
//
//            Byt bw = new BufferedWriter(new OutputStreamWriter(os));
//            //向服务器端发送一条消息
//            String data = "000507<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
//                    "<UMSFX xmls=\"http://www.chinaums.com/UMSFX/1.0\">\n" +
//                    "<ReqHeader>\n" +
//                    "\t<TransCode>201005</TransCode>\n" +
//                    "\t<SrcReqDate>20120424</SrcReqDate>\n" +
//                    "\t<SrcReqTime>195435</SrcReqTime>\n" +
//                    "\t<SrcReqId>0000000001</SrcReqId>\n" +
//                    "\t<ChannelId>03100000</ChannelId>\n" +
//                    "\t<MAC>ACD1F98C33BEFFAB</MAC>\n" +
//                    "</ReqHeader>\n" +
//                    "<ReqBody>\n" +
//                    "\t<InqType>3</InqType>\n" +
//                    "\t<SrcReqDate>0000103021</SrcReqDate>\n" +
//                    "\t<SrcReqId>000000201102111</SrcReqId>\n" +
//                    "\t<InstitudeCode>20</InstitudeCode>\n" +
//                    "</ReqBody>\n" +
//                    "</UMSFX>";
//            bw.write(data.getBytes());
//            bw.flush();
//
//            //读取服务器返回的消息
//            BufferedReader br = new BufferedReader(new InputStreamReader(is));
//            String mess = br.readLine();
//            System.out.println("服务器："+mess);
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private Socket socket;
    private SocketAddress address;

    public SocketTest() {
        try {
            socket = new Socket();
            address = new InetSocketAddress("58.247.0.18", 8203);
            socket.connect(address, 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void talk() {

        try {

            //使用DataInputStream封装输入流
            InputStream os = new DataInputStream(System.in);
            String data = "000507<?xml version=\"1.0\" encoding=\"GBK\"?>\n" +
                    "<UMSFX xmls=\"http://www.chinaums.com/UMSFX/1.0\">\n" +
                    "<ReqHeader>\n" +
                    "\t<TransCode>201111</TransCode>\n" +
                    "\t<SrcReqDate>20120424</SrcReqDate>\n" +
                    "\t<SrcReqTime>195435</SrcReqTime>\n" +
                    "\t<SrcReqId>0000000001</SrcReqId>\n" +
                    "\t<ChannelId>03100000</ChannelId>\n" +
                    "\t<MAC>ACD1F98C33BEFFAB</MAC>\n" +
                    "</ReqHeader>\n" +
                    "<ReqBody>\n" +
                    "\t<InqType>3</InqType>\n" +
                    "\t<SrcReqDate>0000103021</SrcReqDate>\n" +
                    "\t<SrcReqId>000000201102111</SrcReqId>\n" +
                    "\t<InstitudeCode>20</InstitudeCode>\n" +
                    "</ReqBody>\n" +
                    "</UMSFX>";
            byte [] b = data.getBytes();
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//            while (-1 != os.read(b)) {
//                dos.write(b); // 发送给客户端
//            }
            dos.write(b); // 发送给客户端
            dos.flush();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {

            }
        }
    }

    public static void main(String[] args) {
        SocketTest client = new SocketTest();
        client.talk();
    }
}
