package Func;


import java.util.concurrent.TimeUnit;

public class Wait extends AbstractActvity {
	

	@SuppressWarnings("deprecation")
	public void wait(int timeNum) {
		//System.setProperty("webdriver.chrome.driver", "D:\\Project\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();  
		
		driver.manage().timeouts().implicitlyWait(timeNum, TimeUnit.SECONDS);
		 
	}

}
