package com.mytest.test.ct;

import com.mytest.test.ct.Check_Korea_Store;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class Crawl_Yogiyo_Korea{
	public static void main(String[] args) {
		// ���� package�� workspace ���, Windows�� [ chromedriver.exe ]
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver");  // ���� package��
        
        // WebDriver ��� ����
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\kimgu\\desktop\\����\\���¼ҽ� ����������Ʈ/chromedriver.exe");
        
        // WebDriver �ɼ� ����
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // ��üȭ������ ����
        options.addArguments("--disable-popup-blocking");    // �˾� ����
        options.addArguments("--disable-default-apps");     // �⺻�� ������
        
        // WebDriver ��ü ����
        ChromeDriver driver = new ChromeDriver( options );
       
        driver.get("https://www.yogiyo.co.kr/mobile/#/");
        
        try {

        	Thread.sleep(1000); //1�� ���

           } catch (InterruptedException e) {

        	e.printStackTrace();

           }
        
        WebElement element=driver.findElementByName("address_input");
        element.clear();
        element.sendKeys("��û�ϵ� û�ֽ� ������ ���ŵ� 12 ��ϴ��б�");
        
        WebElement button=driver.findElementByCssSelector("button.btn.btn-default.ico-pick");
        button.click();
        
        try {

        	Thread.sleep(1000); //1�� ���

           } catch (InterruptedException e) {

        	e.printStackTrace();

           }
        
        WebElement menu=driver.findElementByXPath("//*[@id=\"category\"]/ul/li[8]");
        menu.click();
        
        try {

        	Thread.sleep(1000); //1�� ���

           } catch (InterruptedException e) {

        	e.printStackTrace();

           }
        
        for(int i=1; i<20; i++)
        {
        	String names_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div/table/tbody/tr/td[2]/div/div[1]",i);
        	String ratings_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div/table/tbody/tr/td[2]/div/div[2]/span[1]/span",i);
        	String reviews_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div/table/tbody/tr/td[2]/div/div[2]/span[2]",i);
        	
        	WebElement names = driver.findElementByXPath(names_xpath);
        	WebElement ratings = driver.findElementByXPath(ratings_xpath);
        	WebElement reviews = driver.findElementByXPath(reviews_xpath);
        	
        	String name = names.getText();
        	String rate = ratings.getText();
        	String review = reviews.getText();
        	
        	String rate_numStr = rate.replaceAll("[^0-9.]", "");
        	String review_numStr = review.replaceAll("[^0-9]", "");
        	
        	float rate_num = Float.parseFloat(rate_numStr);
        	int review_num = Integer.parseInt(review_numStr);
	        
        	System.out.println(name);
        	System.out.println(rate_num);
        	System.out.println(review_num);
        	
        	if (rate_num>=4.5&&review_num>100)
        		Check_Korea_Store.main(name, rate_num, review_num);
        }
        driver.close();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // WebDriver ����
            driver.quit();
        }
	}
	
}