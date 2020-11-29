package com.mytest.test.ct;

import com.mytest.test.ct.insert;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class seleniumtest{
	public static void main(String[] args) {
		// 현재 package의 workspace 경로, Windows는 [ chromedriver.exe ]
        Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver");  // 현재 package의
        
        // WebDriver 경로 설정
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsgo2\\Downloads/chromedriver.exe");
        
        // WebDriver 옵션 설정
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");            // 전체화면으로 실행
        options.addArguments("--disable-popup-blocking");    // 팝업 무시
        options.addArguments("--disable-default-apps");     // 기본앱 사용안함
        
        // WebDriver 객체 생성
        ChromeDriver driver = new ChromeDriver( options );
       
        driver.get("https://www.yogiyo.co.kr/mobile/#/");
        
        try {

        	Thread.sleep(1000); //1초 대기

           } catch (InterruptedException e) {

        	e.printStackTrace();

           }
        
        WebElement element=driver.findElementByName("address_input");
        element.clear();
        element.sendKeys("충청북도 청주시 서원구 개신동 12 충북대학교");
        
        WebElement button=driver.findElementByCssSelector("button.btn.btn-default.ico-pick");
        button.click();
        
        try {

        	Thread.sleep(1000); //1초 대기

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
	        
        	System.out.println(name);
        	System.out.println(rate);
        	System.out.println(review);
        	
	        insert.main(name, rate, review);
	        
        }
        driver.close();
        
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // WebDriver 종료
            driver.quit();
        }
	}
	
}