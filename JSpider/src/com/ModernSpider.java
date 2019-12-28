package com;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ModernSpider {
	//����url��ȡ����
    public Document getHtmlTextByUrl(String url){
        Document document=null;
        try{
            int i=(int)(Math.random()*1000);////��һ�������ʱ����ֹ��վ����
            while (i!=0) {
                i--;
            }
            document=Jsoup.connect(url)
                        .data("query","Java")
                        .userAgent("Mozilla")
                        .cookie("auth", "token")
                        .timeout(300000).post();
        }catch(Exception e){
            e.printStackTrace();
            try{
                document=Jsoup.connect(url).timeout(5000000).get();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
        return document;
    }
    
    //����Ԫ�����Ի�ȡĳ��Ԫ���ڵ�elements�б�
    public Elements getElementByClass(Document document,String className){
        Elements elements=null;
        elements=document.select(className);
        return elements;
    }
    
    public ArrayList getProvice(String url,String type){
        ArrayList result=new ArrayList();
        String classtype="."+type;
        //�������ϻ�ȡ��ҳ
        Document document=getHtmlTextByUrl(url);
        if (document!=null) {
            Elements elements=getElementByClass(document,classtype);// tr�ļ���
            for(Element e:elements){// ����ѭ��ÿ��Ԫ�أ�Ҳ����һ��tr
                if(e!=null){
                    for(Element ec:e.children()){// һ��tr����Ԫ��td��td�ڰ���a��ǩ
                        String[] prv = new String[4];
                        if(ec.children().first()!=null){
                            prv[0]=url;// ԭ����url
                            prv[1]=ec.children().first().ownText();
                            System.out.println(prv[1]);//�������
                            
                            String ownurl=ec.children().first().attr("abs:href");
                            prv[2]=ownurl;
                            System.out.println(prv[2]);
                            
                            prv[3]=type;
                            result.add(prv);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String url="http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2015/index.html";
        String type="provincetr";
        System.out.println(new Html().getProvice(url, type));
    }
}
