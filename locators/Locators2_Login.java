package com.practice.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2_Login {
	
	public static void main(String[] args) throws InterruptedException {

		String name = "Ashutosh";
//		System.setProperty("webdriver.chrome.driver", "C:\\\\Ashutosh Selen\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
//		implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password = getPassword(driver);
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();

//		System.out.println(driver.findElement(By.xpath("//p[contains(@style,'color')]")).getText());
//		driver.findElement(By.className("logout-btn")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),
				"Hello " + name + ",");

		driver.findElement(By.xpath("//button[text() = 'Log Out']")).click();
		Thread.sleep(2000);
		driver.close();

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String pwdText = driver.findElement(By.cssSelector("form p")).getText();
//		Please use temporary password 'rahulshettyacademy' to Login.
		String pwdArray[] = pwdText.split("'");
//		0th index --> Please use temporary password
//		1st index --> rahulshettyacademy' to Login.
//		String pass[] = pwdArray[1].split("'");
//		String pass1 = pass[0];
//		0th index --> rahulshettyacademy
//		1st index --> to Login.
//		The above 48th and 49th line can be written as
		String password = pwdArray[1].split("'")[0];
		return password;
		
	}
	
	
}
