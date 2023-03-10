package week4day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowHandle {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		System.out.println("parent window title name:"+driver.getTitle());
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> wHandle = new ArrayList<String>(windowHandles);
		driver.switchTo().window(wHandle.get(1));
		System.out.println("new window opened title name:"+driver.getTitle());
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(wHandle.get(0));
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> wHandle1 = new ArrayList<String>(windowHandles2);
		int size = wHandle1.size();
		System.out.println("no of windows opened:"+size);
		driver.switchTo().window(wHandle1.get(2));
		driver.close();
		driver.switchTo().window(wHandle1.get(1));
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(wHandle1.get(0));
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> wHandle2 = new ArrayList<String>(windowHandles3);
		int size2 = wHandle2.size();
		System.out.println("no of windows opened:"+size2);
		Thread.sleep(2000);
		driver.switchTo().window(wHandle2.get(3));
		driver.close();
		driver.switchTo().window(wHandle2.get(2));
		driver.close();
		driver.switchTo().window(wHandle2.get(1));
		driver.close();
		driver.switchTo().window(wHandle2.get(0));
		Set<String> windowHandles4 = driver.getWindowHandles();
		int size3 = windowHandles4.size();
		System.out.println("no of windows opened:"+size3);
	    System.out.println("Its confirmed that all child windows are closed");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
	    Set<String> windowHandles5 = driver.getWindowHandles();
	    int size4 = windowHandles5.size();
	    System.out.println("No of windows opened :"+size4);
	    driver.quit();
		
	}

}
