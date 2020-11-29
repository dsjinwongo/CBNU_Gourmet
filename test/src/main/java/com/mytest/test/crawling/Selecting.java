package com.mytest.test.crawling;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

public class Selecting{
	public void main(String[] args)
	{
		String url ="https://map.naver.com/v5/search/%EC%B6%A9%EB%B6%81%EB%8C%80%ED%95%99%EA%B5%90%20%EB%A7%9B%EC%A7%91/place/1253855513?c=14187869.7541101,4388147.0815952,16,0,0,0,dh&placePath=%3Fentry%253Dpll%2526";
		Document doc = null;
		
		try {
			doc =Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(doc);
		Elements _name = doc.select("span._2EZQu");
		System.out.println(_name.text());
		//String name=_name.text();
	}	
}