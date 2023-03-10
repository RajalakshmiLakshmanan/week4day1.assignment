package week4day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) {
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("demoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(wHandle.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//div[contains(@class,'x-grid3-cell-inner')]/a)[1]")).click();
		driver.switchTo().window(wHandle.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2.size());
		List<String>wHandle1 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(wHandle1.get(1));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//td[contains(@class,'x-grid3-cell-first ')]//a)[2]")).click();
		driver.switchTo().window(wHandle1.get(0));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		driver.switchTo().alert().accept();
		System.out.println(driver.getTitle());
		
		
	}

}
