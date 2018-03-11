package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	
	@Test
	public void testFtpClient() throws Exception {
		// 创建一个 FtpClient 对象
		FTPClient ftpClient = new FTPClient();
		
		// 创建 ftp 连接。
		ftpClient.connect("192.168.93.129", 21);
		
		// 登陆  ftp 服务器， 使用用户名和密码
		ftpClient.login("ftpuser", "ftpuser");
		
		// 上传文件
		FileInputStream inputStream = new FileInputStream(new File("D:\\homework\\picture\\qiaozhong.jpg"));
		//设置上传的路径
		ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
		//修改上传文件的格式
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		// 第一个参数： 服务器端文档名
		// 第二个参数： 上传文档的 inputstream
		ftpClient.storeFile("hello1.jpg", inputStream);
		//关闭连接
		ftpClient.logout();
	}
	
	@Test
	public void testFtpUtil() throws Exception {
		FileInputStream inputStream = new FileInputStream(new File("D:\\homework\\picture\\qiaozhong.jpg"));
		FtpUtil.uploadFile("192.168.93.129", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images", "/2018/3/10", "hello.jpg", inputStream);
	}
}
