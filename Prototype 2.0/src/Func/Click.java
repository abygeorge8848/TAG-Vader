package Func;

import org.openqa.selenium.By;

public class Click extends AbstractActvity {
	

	public void click(String xpathString) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		driver.findElement(By.xpath(xpathString)).click();
		 
	}

}
