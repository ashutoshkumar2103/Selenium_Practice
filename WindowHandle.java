package com.practice.actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandle {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println("START");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");

		driver.findElement(By.cssSelector(".blinkingText")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> d.getWindowHandles().size() > 1);

		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		String parentId = it.next();
		String childId = it.next();

		driver.switchTo().window(childId);

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		// PUT BREAKPOINT HERE
//		driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("@")[1].split(".com")[0]);
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText().split("@")[1].split(".com")[0];
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(emailId);

	}

}
