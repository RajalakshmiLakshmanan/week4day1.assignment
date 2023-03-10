package week4day1.assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		WebElement cost = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String phoneCost = cost.getText();
		System.out.println("Phone cost:"+phoneCost);
		
		driver.findElement(By.xpath("(//a[@class='a-popover-trigger a-declarative'])[1]")).click();
		WebElement rating = driver.findElement(By.xpath("(//span[@data-hook='total-review-count'])[1]"));
		System.out.println(rating.getText());
		driver.findElement(By.xpath("(//a[contains(@class,'s-underline-link-text')]/span)[1]")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String>wHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(wHandle.get(1));
		System.out.println(driver.getTitle());
		Thread.sleep(3000);

		File screenshotAs1 = driver.getScreenshotAs(OutputType.FILE);
		File destn=new File("./snap/shot.png");
		FileUtils.copyFile(screenshotAs1, destn);

		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		WebElement findElement = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String subTotal = findElement.getText();
		System.out.println(subTotal);
		
		if(phoneCost.equals(subTotal)) {
			 
			System.out.println("cart subtotal is same as cost of phone");
		}
		
		driver.close();
		
	}

}
