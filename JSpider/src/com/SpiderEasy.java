package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class SpiderEasy {
	
	public static String sendGet(String url) {
		//����һ���ַ�����������ҳ����
				String result = "";
				//����һ�������ַ�������
				BufferedReader bfr = null;
				//�����ֽ���
				InputStreamReader insr = null;
				
				try {
					// ��stringת��Ϊurl����
					URL realUrl = new URL(url);
					//��ʼ��һ������
					URLConnection connection = realUrl.openConnection();
					//��ʼ����
					connection.connect();
					//��ʼ��br����������ȡurl��Ӧ
					insr = new InputStreamReader(connection.getInputStream(),"UTF-8");
					bfr = new BufferedReader(insr);
					//ץȡ����
					String line;
					while((line = bfr.readLine()) != null) {
						result += line;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("�쳣");
					e.printStackTrace();
				}
				
				return result;
	}
	
	public static void main(String[] args) {
		//���弴�����ʵ�����
		String url = "http://www.baidu.com";
		String result = sendGet(url);
		
		System.out.println(result);
	}
}
