package com.mytest.test.ct;

import com.mytest.test.ct.Add_America;
import com.mytest.test.ct.Add_Korea;
import com.mytest.test.ct.Add_China;
import com.mytest.test.ct.Add_Snack;
import com.mytest.test.ct.Add_Japan;
import com.mytest.test.ct.Add_Chicken;
import com.mytest.test.ct.Add_Dessert;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.*;
 
public class Crawl_Daum {
         public static void main(String[] args) {
              // WebDriver 경로 설정
              System.setProperty("webdriver.chrome.driver", "C:\\Users\\dsgo2\\Downloads/chromedriver.exe");
              
              // WebDriver 옵션 설정
              ChromeOptions options = new ChromeOptions();
              options.addArguments("--start-maximized");            // 전체화면으로 실행
              options.addArguments("--disable-popup-blocking");    // 팝업 무시
              options.addArguments("--disable-default-apps");     // 기본앱 사용안함
              
              // WebDriver 객체 생성
              ChromeDriver driver = new ChromeDriver( options );
             
              driver.get("https://map.kakao.com/");
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              WebElement element=driver.findElementByName("q");
              element.clear();
              element.sendKeys("충북대학교 맛집");
              element.sendKeys(Keys.ENTER);
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              for(int i=1; i<4; i++) {
              
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              
              for(int i=5; i<16; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              WebElement morepage =driver.findElementByXPath("//*[@id=\"info.search.place.more\"]");
              morepage.sendKeys(Keys.ENTER);
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              for(int i=1; i<4; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              
              for(int i=5; i<17; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
                 
              }
              
              WebElement nextpage =driver.findElementByXPath("//*[@id=\"info.search.page.no3\"]");
              nextpage.sendKeys(Keys.ENTER);
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              for(int i=1; i<4; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              
              for(int i=5; i<16; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
                 
              }
              
              WebElement pagefour =driver.findElementByXPath("//*[@id=\"info.search.page.no4\"]");
              pagefour.sendKeys(Keys.ENTER);
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              for(int i=1; i<4; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              
              for(int i=5; i<16; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
                 
              }
            
              WebElement pagefive =driver.findElementByXPath("//*[@id=\"info.search.page.no5\"]");
              pagefive.sendKeys(Keys.ENTER);
              
              try {

                 Thread.sleep(1000); //1초 대기

                 } catch (InterruptedException e) {

                 e.printStackTrace();

                 }
              
              for(int i=1; i<4; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
              }
              
              for(int i=5; i<16; i++) {
                 
                 String names_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/strong/a[2]",i);
                 String kinds_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[3]/span", i);
                 String ratings_xpath=String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/span[1]/em",i);
                 String reviews_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[4]/a/em",i);
                 String location_xpath = String.format("//*[@id=\"info.search.place.list\"]/li[%d]/div[5]/div[2]/p[1]", i);
                 
                 WebElement names = driver.findElementByXPath(names_xpath);
                 WebElement kinds = driver.findElementByXPath(kinds_xpath);
                 WebElement ratings = driver.findElementByXPath(ratings_xpath);
                 WebElement reviews = driver.findElementByXPath(reviews_xpath);
                 WebElement locations = driver.findElementByXPath(location_xpath);
                 
                 String name = names.getText();
                 String kind = kinds.getText();
                 String rate = ratings.getText();
                 String review = reviews.getText();
                 String location = locations.getText();
                 
                 String rate_numStr = rate.replaceAll("[^0-9.]", "");
                 String review_numStr = review.replaceAll("[^0-9]", "");
                 
                 float rate_num = Float.parseFloat(rate_numStr);
                 int review_num = Integer.parseInt(review_numStr);
                 
                 System.out.println(name);
                 System.out.println(kind);
                 System.out.println(rate);
                 System.out.println(review);
                 System.out.println(location);
                 
                 if (kind.equals("중화요리")||kind.equals("중식")) { 
                    Add_China.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("닭요리")||kind.equals("한정식")||kind.equals("육류,고기")||kind.equals("삼겹살")) {
                    Add_Korea.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("분식")||kind.equals("떡볶이")) {
                    Add_Snack.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("양식")||kind.equals("햄버거")||kind.equals("패스트푸드")) {
                    Add_America.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("카페")||kind.equals("테마카페")||kind.equals("제과,베이커리")||kind.equals("커피전문점")) {
                    Add_Dessert.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("치킨")) {
                    Add_Chicken.main(name, rate_num, review_num, location);
                 }
                 else if (kind.equals("일식집")||kind.equals("회")||kind.equals("초밥,롤")||kind.equals("일본식라멘")) {
                    Add_Japan.main(name, rate_num, review_num, location);
                 }
                 
              }
            
                               
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