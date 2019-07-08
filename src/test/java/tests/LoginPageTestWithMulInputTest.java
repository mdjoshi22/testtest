package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LogOutPagePoPOM;
import pageObjects.LoginPagePoPOM;
import resources.Base;

public class LoginPageTestWithMulInputTest extends Base{
	@Test(dataProvider="getData")
	public void  loginTest(String Username,String Password,String title) throws IOException, InterruptedException {
		LoginPagePoPOM lpp = new LoginPagePoPOM(driver);
		lpp.login(Username, Password);
		Thread.sleep(2000);
		Assert.assertEquals(lpp.validateTitleAfterLogin(), title);
		LogOutPagePoPOM lop = new LogOutPagePoPOM(driver);
		lop.logOut();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		// Row stands for how many different data types test should run. index starts from zero
		//coloumn stands for how many values per each test	
		// Array size is 2
		// 0,1
		Object[][] data=new Object[2][3];
		//0th row
		data[0][0]="mdjoshi22@gmail.com";
		data[0][1]="1234";
		data[0][2]="Find a Flight: Mercury Tours:";
		//1st row
		data[1][0]="anjalibhat82@gmail.com";
		data[1][1]="1234";
		data[1][2]= "Find a Flight: Mercury Tours:";
		
		return data;
		
	}
}

