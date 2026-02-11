package com.practice.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");

		System.out.println(driver.findElement(By.cssSelector(".demo-frame")).getSize());
		Thread.sleep(2000); // Thread sleep is used here to see the frame being dragged and dropped. (we should use explicit wait instead)
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		
		Actions action = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		action.dragAndDrop(source, target).build().perform();
		driver.switchTo().defaultContent();
		
	}

}
