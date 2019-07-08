package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class Base {
	public static WebDriver driver;
	public static Properties prop;
	public static Logger log =LogManager.getLogger(Base.class.getName());
	
	@BeforeTest
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\workspaceNew\\cgi\\src\\main\\java\\resources\\conf.properties");
		prop.load(fis);                            
		String browserName = prop.getProperty("browser");


		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\Workspace\\Selenium\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
		}
		log.info("Driver is initialized");
		driver.manage().window().maximize();
		log.info("Maximized");
		driver.manage().deleteAllCookies();
		log.info("Delete All Cookies");
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);	
		driver.get(prop.getProperty("url"));
		log.info("Url entered");
		return driver;
	}
	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E://workspaceNew//cgi//FailedTestScreenshots//" + result + "screenshot.png"));
	}
	@AfterTest
	public void closeApplication()
	{
		driver.close();	
		driver=null;
	}
	
}


