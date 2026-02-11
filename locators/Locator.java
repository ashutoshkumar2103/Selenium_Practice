//Locators: Locators are the way to identifyan HTML element on a web page. Selenium WebDriver uses any of the below locators to identify the element on the page and performs the actor:
//	ID
//	Name
//	Class Name
//	Tag Name
//	CSS Selector
//	XPath
//	Link Text
//	Partial Link Text
package com.practice.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator {
	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "C:\\Ashutosh_Selen\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
//		by ID
		driver.findElement(By.id("inputUsername")).sendKeys("ashutosh");
//		by Name
		driver.findElement(By.name("inputPassword")).sendKeys("ashu@123");
//		by Class Name
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		// by Link Text Selector
//		driver.findElement(By.linkText("Forgot your password?")).click();
//		Prtial Link Text using XPath
		driver.findElement(By.xpath("//div[contains(@class,'pwd-container')]")).click();
//		by XPath
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ashutosh");
//		by Css Selector
		driver.findElement(By.cssSelector("input[placeholder = 'Email']")).sendKeys("Ashutosh@rs.com");
		driver.findElement(By.cssSelector("input[type= 'text']:nth-child(3)")).clear();
		driver.findElement(By.xpath("//input[@type ='text'][2]")).sendKeys("ashutosh@gmail.com");
//		PArent to child tag traverse in XPath format
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9077899514");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		driver.findElement(By.cssSelector("button[class = 'go-to-login-btn']")).click();
		// login from here
		driver.findElement(By.id("inputUsername")).sendKeys("ashutosh");
//		Partial Link Text using CSS Selector
		driver.findElement(By.cssSelector("input[placeholder*='Pass']")).sendKeys("rahulshettyacademy");
//		Prtial Link Text using XPath
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.className("logout-btn")).click();
	}

}
