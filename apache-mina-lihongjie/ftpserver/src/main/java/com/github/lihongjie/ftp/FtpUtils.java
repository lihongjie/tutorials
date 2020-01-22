package com.github.lihongjie.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.text.SimpleDateFormat;

public class FtpUtils {

    private final static SimpleDateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");

    private final static String USER_NAME = "admin"; // ftp登录用户名
    private final static String USER_PASSWORD = "admin"; // ftp登录密码
    private final static String SERVER_IP = "localhost";// 直接ip地址
    private final static int SERVER_PORT = 2121;// 端口号

    private final static String WEB_URL = "localhost:8080";

    /**
     * 获取ftp连接对象
     *
     * @param parentDirName
     * @return
     * @throws
     */
    public static FTPClient getFTPClient(String parentDirName) throws Exception {
        FTPClient ftpClient = new FTPClient();
        try {
            // 连接服务器
            ftpClient.connect(SERVER_IP, SERVER_PORT);
            // 登陆ftp
            ftpClient.login(USER_NAME, USER_PASSWORD);
            // 判断登陆是否成功
            int reply = ftpClient.getReplyCode();

            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();

                throw new Exception("登陆ftp失败");
            }
            boolean res = ftpClient.changeWorkingDirectory(parentDirName);
            if (!res) {
                ftpClient.disconnect();

                throw new Exception("文件夹不存在");
            }
            // 设置属性
            ftpClient.setBufferSize(1024);// 设置上传缓存大小
            ftpClient.setControlEncoding("UTF-8");// 设置编码
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // 二进制

        } catch (IOException e) {
            throw new Exception("获取ftp连接对象失败", e);
        }
        return ftpClient;
    }

    /**
     * 关闭ftp连接对象
     *
     * @param ftpClient
     * @throws
     */
    public static void closeFTPClient(FTPClient ftpClient) throws Exception {
        if (null != ftpClient && ftpClient.isConnected()) {
            try {
                ftpClient.disconnect();
            } catch (IOException e) {
                throw new Exception("关闭ftp连接对象失败", e);
            }
        }
    }

    /**
     * 上传文件
     *
     * @param is            输入文件流
     * @param parentDirName 指定目录
     * @param fileName      文件名
     * @return 访问路径
     * @throws
     */
    public static String uploadFile(InputStream is, String parentDirName, String fileName) throws Exception {

        String resultFileName = null;
        FTPClient ftpClient = getFTPClient(parentDirName);
        try {
            // 指定写入目录
            ftpClient.storeFile(new String(fileName.getBytes("utf-8"), "iso-8859-1"), is);
            is.close();
            resultFileName = parentDirName + File.separator + fileName;
        } catch (Exception e) {
            throw new Exception("上传文件失败", e);
        } finally {
            closeFTPClient(ftpClient);
        }

        return WEB_URL + resultFileName;
    }

    /**
     * 下载文件
     *
     * @param fileName
     * @param parentDirName
     * @param localPath
     * @throws
     */
    public static void downFile(String fileName, String parentDirName, String localPath) throws Exception {

        FTPClient ftpClient = getFTPClient(parentDirName);
        try {
            // 遍历下载的目录
            FTPFile[] fs = ftpClient.listFiles();
            for (FTPFile ff : fs) {
                // 解决中文乱码问题，两次解码
                byte[] bytes = ff.getName().getBytes("iso-8859-1");
                String fn = new String(bytes, "utf8");
                System.out.println(fn);
                if (fn.equals(fileName)) {
                    File localFile = new File(localPath + fileName);
                    OutputStream is = new FileOutputStream(localFile);
                    ftpClient.retrieveFile(fileName, is);
                    is.close();

                }
            }
            ftpClient.logout();
        } catch (IOException e) {
            throw new Exception("下载出错", e);
        } finally {
            closeFTPClient(ftpClient);
        }
    }

    /**
     * 从ftp服务器上下载文件到本地
     *
     * @param sourceFileName：服务器资源文件名称
     * @return InputStream 输入流
     * @throws IOException
     * @throws
     */
    public static InputStream downFile() throws Exception {
        String dirName = "/";
        String sourceFileName = "1";
        InputStream in = null;
        try {
            in = getFTPClient(dirName).retrieveFileStream(sourceFileName);
        } catch (IOException e) {

            throw new Exception("下载文件错误", e);
        } finally {
            closeFTPClient(getFTPClient(dirName));
        }
        return in;

    }

    public static void main(String[] args) throws Exception {

//        uploadFile();
        /**测试*/
        FtpUtils.downFile("1.txt", "/", "E:\\test\\");

        /**测试*/
//		InputStream is=downFile(dirName, fileName);
//		File file=new File(localPath,fileName);
//		OutputStream os=new FileOutputStream(file);
//		int b;
//		while((b=is.read())!=-1){
//			os.write(b);
//		}
//		is.close();
//		os.close();

    }

    private static void uploadFile() {
        InputStream is;
        File file = new File("E:\\1.txt");
        try {
            is = new FileInputStream(file);
            String resName = null;
            resName = FtpUtils.uploadFile(is, "/", file.getName());
            System.out.println(resName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}