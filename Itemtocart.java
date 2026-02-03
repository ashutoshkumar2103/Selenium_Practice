package com.practice.ecommerce;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Itemtocart {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the vegetable name: ");
		String vegName = sc.nextLine();
		System.out.println("Enter the quantity: ");
		Long quantity = sc.nextLong();
		System.out.println("Enter Country Name: ");
		String countryName = sc.next();
		
		WebDriver driver = new ChromeDriver();
//		below is Implicit wait
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
//		Explicit wait
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		driver.findElements(By.cssSelector("h4.product-name"));
		List<WebElement> productName = driver.findElements(By.cssSelector("h4.product-name"));

		for(int i = 0; i < productName.size(); i++) {
			String name = productName.get(i).getText();
			
			if(name.contains(vegName)) {
				for(int j = 1; j < quantity; j++) {
					driver.findElements(By.cssSelector(".increment")).get(i).click();
				}
				driver.findElements(By.cssSelector("div[class=\"product-action\"] button")).get(i).click();
				break;
			}
		}
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement dropdown = driver.findElement(By.xpath("//div/select"));		
		Select countryDropdown = new Select(dropdown);
		List<WebElement> country = driver.findElements(By.xpath("//option"));
		boolean found = false;
		for(int i = 0; i < country.size(); i++) {
			String cnty = country.get(i).getText();
			if(cnty.equalsIgnoreCase(countryName)) {
				countryDropdown.selectByIndex(i);
				found = true;
				break;
			}
		}

		if(!found) {
			throw new Exception("Country not found");
		}
		
		driver.findElement(By.cssSelector(".chkAgree")).click();
		driver.findElement(By.xpath("//button")).click();
		System.out.println(driver.findElement(By.cssSelector(".wrapperTwo")).getText());
		sc.close();
	}
}










//package com.practice.ecommerce;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Scanner;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class Itemtocart {
//
//    public static void main(String[] args) throws Exception {
//
//        // Scanner is used to take dynamic input from user at runtime
//        Scanner sc = new Scanner(System.in);
//
//        System.out.print("Enter the vegetable name: ");
//        String vegName = sc.nextLine();
//
//        System.out.print("Enter the quantity: ");
//        int quantity = sc.nextInt();
//
//        System.out.print("Enter Country Name: ");
//        String countryName = sc.next();
//
//        // Launching Chrome browser
//        WebDriver driver = new ChromeDriver();
//
//        // Explicit wait is preferred over Thread.sleep
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//        driver.manage().window().maximize();
//
//        // Fetch all products once to avoid repeated DOM calls
//        List<WebElement> products = driver.findElements(By.cssSelector(".product"));
//
//        for (WebElement product : products) {
//
//            // Get product name text
//            String productName = product.findElement(By.cssSelector("h4.product-name")).getText();
//
//            if (productName.contains(vegName)) {
//
//                // Locate increment button inside the matched product
//                WebElement incrementBtn = product.findElement(By.cssSelector(".increment"));
//
//                // Increase quantity (default is 1, so quantity-1 clicks)
//                for (int i = 1; i < quantity; i++) {
//                    incrementBtn.click();
//                }
//
//                // Click ADD TO CART button inside the matched product
//                product.findElement(By.tagName("button")).click();
//                break;
//            }
//        }
//
//        // Open cart
//        driver.findElement(By.cssSelector(".cart-icon")).click();
//
//        // Wait until PROCEED TO CHECKOUT button is clickable
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[text()='PROCEED TO CHECKOUT']"))).click();
//
//        // Apply promo code
//        wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector(".promoCode"))).sendKeys("rahulshettyacademy");
//
//        driver.findElement(By.cssSelector(".promoBtn")).click();
//
//        // Place order
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[text()='Place Order']"))).click();
//
//        // Locate country dropdown
//        WebElement countryDropdownElement = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/select")));
//
//        // Select class is used only for <select> dropdowns
//        Select countryDropdown = new Select(countryDropdownElement);
//
//        boolean countryFound = false;
//
//        // getOptions fetches only options of this dropdown
//        for (WebElement option : countryDropdown.getOptions()) {
//            if (option.getText().equalsIgnoreCase(countryName)) {
//                option.click();
//                countryFound = true;
//                break;
//            }
//        }
//
//        // Validation after loop, not inside loop
//        if (!countryFound) {
//            throw new Exception("Country not found in dropdown");
//        }
//
//        // Agree to terms and conditions
//        driver.findElement(By.cssSelector(".chkAgree")).click();
//
//        // Final order submission
//        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
//
//        // Print confirmation message
//        System.out.println(
//                wait.until(ExpectedConditions.visibilityOfElementLocated(
//                        By.cssSelector(".wrapperTwo"))).getText()
//        );
//
//        sc.close();
//        driver.quit();
//    }
//}
