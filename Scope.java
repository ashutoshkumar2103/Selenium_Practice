package com.practice.practiceselenium;

//import java.util.Iterator;
//import java.util.Set;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class Scope {
//
//	public static void main(String[] args) throws InterruptedException {
////		1. Give me the count of links on the page	
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://qaclickacademy.com/practice.php");
//		
//		System.out.println(driver.findElements(By.tagName("a")).size());
//
////		2. Give me the count of links in the footer section
////		Limiting the scope of WebDriver to footer section only, so that it will not search for all the links in the page, it will search only in the footer section.
//		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
//		System.out.println(footerdriver.findElements(By.tagName("a")).size());
//
////		The below line is in one line, which is same as above two lines, but it is not recommended to write in one line because it is not readable and maintainable.
////		System.out.println(driver.findElement(By.id("gf-BIG")).findElements(By.tagName("a")).size());
//
////		3. Give me the count of links from the first column of footer section	
////		Finding the count of links in the first column of footer section.
//		WebElement columndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
//		System.out.println(columndriver.findElements(By.tagName("a")).size());
//
////		The below line is in one line, which is same as above two lines, but it is not recommended to write in one line because it is not readable and is having xpath clubbed together, which is not maintainable.
////		System.out.println(driver.findElements(By.xpath("//table[@class=\"gf-t\"] /tbody /tr /td [1] /ul /li /a")).size());
//
////		4. Click on the each link in the column and check if the pages are opening.
//		int column1Link = columndriver.findElements(By.tagName("a")).size();
//		
//		for (int i = 0; i < column1Link; i++) {
//			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
//			Thread.sleep(2000);
//			columndriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
//		}
//
//		
//		Set<String> abc = driver.getWindowHandles();
//		Iterator<String> it = abc.iterator();
//		
////		Switching to each tab and printing the title of each tab.
//		while (it.hasNext()) {
//			driver.switchTo().window(it.next());
//			System.out.println(driver.getTitle());
//		}
//
////		Another way to switch to each tab using for each loop, which is more readable and maintainable than the above for loop.
////		for (String winHandle : driver.getWindowHandles()) {
////			driver.switchTo().window(winHandle);
////			System.out.println(driver.getTitle());
////		}
//	}
//}



import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//1. Give me the count of links on the page.
		//2. Count of footer section-

		WebDriver driver=new ChromeDriver();

		driver.get("http://qaclickacademy.com/practice.php");

		System.out.println(driver.findElements(By.tagName("a")).size());

		WebElement footerdriver=driver.findElement(By.id("gf-BIG"));// Limiting webdriver scope

		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		//3-
		WebElement coloumndriver=footerdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(coloumndriver.findElements(By.tagName("a")).size());

		//4- click on each link in the coloumn and check if the pages are opening-
		for(int i=1;i<coloumndriver.findElements(By.tagName("a")).size();i++)
		{
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			coloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}// opens all the tabs
		
		Set<String> abc=driver.getWindowHandles();//4
		Iterator<String> it=abc.iterator();

		while(it.hasNext())
		{
		   driver.switchTo().window(it.next());
		   System.out.println(driver.getTitle());
		}	
	}
}
