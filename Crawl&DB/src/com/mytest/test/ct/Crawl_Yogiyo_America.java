package com.mytest.test.ct;

import com.mytest.test.ct.Insert_America;
import com.mytest.test.ct.Check_America_Store;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;


public class Crawl_Yogiyo_America{
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
        
        WebElement menu=driver.findElementByXPath("//*[@id=\"category\"]/ul/li[6]");
        menu.click();
        
        try {

           Thread.sleep(1000); //1초 대기

           } catch (InterruptedException e) {

           e.printStackTrace();

           }
        
        for(int i=19; i<50; i++)
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
           
           String more_info_xpath = String.format("//*[@id=\"content\"]/div/div[4]/div/div[2]/div[%d]/div", i);
           WebElement more_info = driver.findElementByXPath(more_info_xpath);
           more_info.click();
           
           try {
               Thread.sleep(1000); //1초 대기
               } catch (InterruptedException e) {
               e.printStackTrace();
               }
           
           more_info=driver.findElementByXPath("//*[@id=\"content\"]/div[2]/div[1]/ul/li[3]/a");
           more_info.click();
           
           WebElement open_times = driver.findElementByXPath("//*[@id=\"info\"]/div[2]/p[1]/span");
           WebElement phone_nums = driver.findElementByXPath("//*[@id=\"info\"]/div[2]/p[2]/span");
           WebElement addresses = driver.findElementByXPath("//*[@id=\"info\"]/div[2]/p[3]/span");
           
           String open_time = open_times.getText();
           String phone_num = phone_nums.getText();
           String address = addresses.getText();
           
           System.out.println(name);
           System.out.println(rate_num);
           System.out.println(review_num);
           System.out.println(open_time);
           System.out.println(phone_num);
           System.out.println(address);
           
           if (rate_num>=4.5&&review_num>100) {
              Check_America_Store.main(name, rate_num, review_num, address);
           }
           
           driver.navigate().back();
           
           try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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