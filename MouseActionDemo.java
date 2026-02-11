package com.practice.actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		//action class

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Actions act = new Actions(driver);
		
		WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-link-accountList']")));
//		
		

		act.moveToElement(driver.findElement(By.cssSelector("input[id=\"twotabsearchtextbox\"]"))).click().keyDown(Keys.SHIFT).sendKeys("Mobile").doubleClick().build().perform();
		
		act.moveToElement(el).contextClick().build().perform();

	}

}
