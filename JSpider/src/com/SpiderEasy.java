package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SpiderEasy {
	
	public static String sendGet(String url) {
		//定义一个字符串来储存网页内容
				String result = "";
				//定义一个缓冲字符输入流
				BufferedReader bfr = null;
				//定义字节流
				InputStreamReader insr = null;
				
				try {
					// 将string转化为url对象
					URL realUrl = new URL(url);
					//初始化一个连接
					URLConnection connection = realUrl.openConnection();
					//开始连接
					connection.connect();
					//初始化br输入流来读取url响应
					insr = new InputStreamReader(connection.getInputStream(),"UTF-8");
					bfr = new BufferedReader(insr);
					//抓取数据
					String line;
					while((line = bfr.readLine()) != null) {
						result += line;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("异常");
					e.printStackTrace();
				}
				
				return result;
	}
	
	public static void main(String[] args) {
		//定义即将访问的连接
		String url = "http://www.baidu.com";
		String result = sendGet(url);
		
		System.out.println(result);
	}
}
