package com;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Spider {
	public static void main(String[] args) throws IOException {
		//��ַ
		String url = "https://kg2.qq.com/node/play?s=571cI75H1xb495Eq&shareuid=609c9b812624338a&topsource=a0_pn201001006_z11_u21643941_l0_t1534223843__";
		Connection tempConn = Jsoup.connect(url);
		
		//ģ�������������ͷ
		tempConn.header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:29.0) Gecko/20100101 Firefox/29.0");
		//��ʼ����HTTP����
		Connection.Response demo = tempConn.ignoreContentType(true).method(Connection.Method.GET).execute();
		//��ȡҳ���htmlԪ��
		Document documentDemo = demo.parse();
		
		Elements scriptElements = documentDemo.getElementsByTag("script");
		String initScriptStr = scriptElements.get(2).toString();
		String jsonStr = initScriptStr.substring(initScriptStr.indexOf("{"),initScriptStr.indexOf("; </script>"));
		
		//������в��������յ�json��
		System.out.println(jsonStr);
		
		
		
	}
}
