package Func;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

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
	
	//@SuppressWarnings("deprecation")
	public void wait(int timeNum) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		//driver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
		int millisecs = timeNum*1000;
		try {
			Thread.sleep(millisecs);
		}
		catch(InterruptedException ie) {
			
		}
		 
	}
	
	@SuppressWarnings("deprecation")
	public void input(String value, String xpath) {
		
		driver.findElement(By.xpath(xpath)).click();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();
		driver.findElement(By.xpath(xpath)).sendKeys(value);
		
	}
	
	public void clearInput(String xpath) {
		
		driver.findElement(By.xpath(xpath)).clear();
	}
	
	public void scroll(String xpath) {
		
		WebElement elm = driver.findElement(By.xpath(xpath));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elm);
	}
	
	public void doubleclick(String xpathString) {
		  
		Actions act = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(xpathString)); 
		act.doubleClick(ele).perform();
		 
	}

	public void screenshot() {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();  
		String fileName = dtf.format(now);
		String path = System.getProperty("user.dir") + "\\snapshot\\" +fileName+".png";
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  try {
	            FileUtils.copyFile(screenshot, new File(path));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	}
	
	public void dropdown(String value, String xpath) {
		
		Select dropdown = new Select(driver.findElement(By.xpath(xpath)));
		dropdown.selectByVisibleText(value);
		
	}
	
	public void stop() {
		driver.close();
		
	}
}
	


