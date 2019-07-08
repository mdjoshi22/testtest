package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import resources.Base;
import resources.Repository;



public class LoginPagePoPOM extends Base{
	By username=By.name(Repository.un);
	By password=By.name(Repository.pwd);
	By login=By.name(Repository.login);
	
	
	public LoginPagePoPOM(WebDriver driver) {	
		this.driver=driver;	
	}
	
	public void login(String un,String pwd) {		
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(login).click();
	}
	public String validateTitleAfterLogin() {
		return driver.getTitle();
	}
	 
	/*public WebElement enterEmail()
	{
		return driver.findElement(username);

	}
	public WebElement enterPassword()
	{
		return driver.findElement(password);
	}	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}*/
	
	
	
}