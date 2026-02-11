package com.practice.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
		//Printing the number of frames in the main page.
		System.out.println(driver.findElements(By.tagName("frame")).size());
		driver.switchTo().frame("frame-top");
		
		//Printing the number of frames inside the top frame.
		System.out.println(driver.findElements(By.tagName("frame")).size());
		
		//Since there are no of frames inside the top frame, and we want text from the middle frame, we need to switch to the middle frame. And since we don't have exact data hence we are checking with Frame via WebElement.
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.id("content")).getText());
	
	}

}
