package com.practice.locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locator3 {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
//		Sibling to Sibling and Child to Parent Transverse
//		//header/div/button[1]/following-sibling::button[1]
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		parent to child and Sibling to Sibling
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
//		child to parent
//		//header/div/button[1]/parent::div/button[2]
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
	}
}
