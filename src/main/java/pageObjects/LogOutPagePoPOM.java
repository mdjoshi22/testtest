package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Base;
import resources.Repository;

public class LogOutPagePoPOM extends Base{
	By signoff=By.xpath(Repository.logOut);
			
	public LogOutPagePoPOM(WebDriver driver) {	
		this.driver=driver;	
	}
	
	public void logOut() {		
		driver.findElement(signoff).click();
	}
}