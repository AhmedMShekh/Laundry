package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaundryBalance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver","C:\\Users\\M1083081\\Downloads\\chromedriver_win32\\chromedriver.exe");

		    ChromeOptions opt=new ChromeOptions();
		    opt.addArguments("--disable-notifications");
		    WebDriver driver=new ChromeDriver(opt);
		    
			
			//Launch
			driver.navigate().to("https://tide.com/en-us");
			driver.manage().window().maximize();
		
			//implicit wait
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@id=\"lilo3746-wrapper\"]/div/a")).click();
		
		    //register
			driver.findElement(By.xpath("//span[@class=\"login-register\"]")).click();
			driver.findElement(By.xpath("//a[@class=\"event_internal_link\"]")).click();
			
			//naviagte to child to register
			for(String child:driver.getWindowHandles()) {
				driver.switchTo().window(child);
			}
			driver.findElement(By.xpath("//form[@name='registrationForm']/div[7]/div/button")).click();
			
			//loggin
			driver.findElement(By.xpath("//input[@id='login-email']")).sendKeys("shekhahmed604@gmail.com");
			driver.findElement(By.xpath("//input[@id='login-password']")).sendKeys("Tide@1122");
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			driver.findElement(By.xpath("//div[@id=\"__next\"]/div/div[3]/div/div/div/div[1]/button")).click();
			
			driver.findElement(By.xpath("//div[@id=\"__next\"]/div/div[2]/div/div[1]/button")).click();
			
			
			//close popup
			//driver.findElement(By.xpath("//div[@id=\"content\"]/main/div/div[2]/div/div[1]/button")).click();
			
			//rewards
			driver.findElement(By.xpath("//nav[@id=\"header-nav\"]/div[2]/div/div[1]/a[3]")).click();
			String balance=driver.findElement(By.xpath("//div[@id=\"content\"]/main/div/div[4]/div[1]/div")).getText();
			System.out.println("Available balance :"+balance);
	}

}
