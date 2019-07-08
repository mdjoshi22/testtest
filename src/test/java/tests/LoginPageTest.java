package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPagePoPOM;
import resources.Base;

public class LoginPageTest extends Base{
	@Test
	public void  loginTest() throws IOException, InterruptedException {
		LoginPagePoPOM lpp = new LoginPagePoPOM(driver); // dont forget driver
		lpp.login(prop.getProperty("userName"), prop.getProperty("password"));
		log.info("Entered username and password");
		Assert.assertEquals(lpp.validateTitleAfterLogin(), "Find a Flight: Mercury Tours:");
		Assert.assertTrue(driver.getTitle().contains("Find a Flight: Mercury Tours:"));
		log.info("Successfully validated");
		
//		lpp.enterEmail().sendKeys(prop.getProperty("userName"));
//		lpp.enterPassword().sendKeys(prop.getProperty("password"));
//		lpp.getLogin();
			
	}
	}
