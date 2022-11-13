package Func;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class OpenURL extends AbstractActvity {
	
	
	public void openURL(String URLstring) {
		System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		driver.manage().window().maximize();
		driver.get(URLstring);
		 
	}

	
	public void click(String xpathString) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		driver.findElement(By.xpath(xpathString)).click();
		 
	}
	
	@SuppressWarnings("deprecation")
	public void wait(int timeNum) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		driver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
		 
	}
	
	@SuppressWarnings("deprecation")
	public void input(String value, String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		
	}
	
	public void clearInput(String xpath) {
		
		driver.findElement(By.xpath(xpath)).clear();
	}
	
	public void scroll(String xpath) {
		
		WebElement elm = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);
	}
}
	


