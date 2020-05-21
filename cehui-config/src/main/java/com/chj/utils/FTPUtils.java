package com.chj.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：chj
 * @date ：Created in 2020/5/15 17:39
 * @params :
 */
public class FTPUtils {

   private FTPUtils(){}

   /** 方法描述
   * @Description: ftp文件上传工具类
    *              如果要实现文件上传，就必须要先连接上ftp服务器
    *              然后就是要进行登录到ftp中
    *               然后就是需要开始准备上传了--->就必须要知道用户的上传路径
    *               (我前天规定:咱们就以当天的日期为文件夹实现图片的存放)
    *               eg:2020/05/15
    *               虽然文件的上传地址已经知道了，但是还不知道具体ftp的根目录地址(/home/ftp)
    *               还需要知道文件的名称
   * @Param: [host, port, username, password, filePath, basePath, fileName, input]
   * @return: java.lang.Boolean
   * @Author: chj
   * @Date: 2020/5/15
   */
   public static Boolean uploadFile(String host, Integer port, String username, String password,
                                     String filePath, String basePath, String fileName, InputStream input){

       //创建临时路径
       String tmpPath="";
       //创建FTPClient对象（Ftp给java提供的api 可以来登录，连接，创建文件夹，上传和下载）
       FTPClient ftp = new FTPClient();
       try {
           //连接服务器
           ftp.connect(host,port);
           //登录
           ftp.login(username, password);
           //验证是否连接和登录成功（成功返回230，失败返回530/503）
           int reply = ftp.getReplyCode();
           //根据返回状态码判断是否成功 isPositiveCompletion()方法是检测是否成功 成功返回true 失败返回false
           if (!FTPReply.isPositiveCompletion(reply)) {
               //登录失败 释放资源
               ftp.disconnect();
               return false;
           }
           //判断上传的路径是否存在  basePath + filePath---> /home/ftp  +  /2020/05/15   changeWorkingDirectory():判断路径是否存在，如果存在返回true，如果不存在则返回false
           if (!ftp.changeWorkingDirectory(basePath+filePath)) {
               //没有文件夹 需要创建 filePath中不能有名称为空的文件夹
               String[] dirs = filePath.split("/");
               //basePath(/home/ftp)赋值给临时路径(tmpPath)
               tmpPath=basePath;
               for(String dir : dirs){
                   //dir中不能为空
                   if (null == dir || "".equals(dir)) {
                       continue;
                   }
                   tmpPath += "/"+ dir;
                   //再次检测路径是否存在
                   if (!ftp.changeWorkingDirectory(tmpPath)) {
                       //创建文件夹  makeDirectory()--->就是创建文件夹的方法，返回为bolean
                       if (!ftp.makeDirectory(tmpPath)) {
                           //创建失败
                           return false;
                       }else {
                           //创建成功
                           System.out.println(ftp.changeWorkingDirectory(tmpPath));
                       }
                   }
               }
           }
           //文件存在 可以上传 把文件转化成二进制字符流的模式来上传
        ftp.setFileType(FTP.BINARY_FILE_TYPE);
           //文件上传
           if (!ftp.storeFile(fileName,input)) {
               return false;
           }
           //关闭输入流
           input.close();
           //退出ftp
           ftp.logout();
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           if (ftp.isConnected()) {
               try{
                   ftp.disconnect();
               }catch (IOException e){
                   e.printStackTrace();
               }
           }
       }
       return true;
   }

}

