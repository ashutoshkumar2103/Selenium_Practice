package com.practice.alert;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name: ");
		
		String name = sc.nextLine();
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/automationpractice");
		driver.findElement(By.id("name")).sendKeys(name);
		driver.findElement(By.id("alertbtn")).click();	
		
//		switching from driver to alert using alert() method
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
		
//		if(driver.switchTo().alert().getText().equalsIgnoreCase("cancel")) {
//			System.out.println("Cancelled");
//		}
//		else {
//			System.out.println("It was Okay");
//		}
		
		sc.close();
	}
}
