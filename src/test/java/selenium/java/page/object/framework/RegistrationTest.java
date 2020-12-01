package selenium.java.page.object.framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.java.page.object.framework.Registration;

public class RegistrationTest {
	
	static WebDriver driver;
	Registration objRegister;
	
	@BeforeMethod
	public void setup() {
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C://Personal//chromedriver//chromedriver.exe");

		//Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();
		objRegister = new Registration(driver);
	}
	
	@Test(priority = 0)
	public void test_login_page_load() {
		Assert.assertTrue(objRegister.getH1text(" User Registration "));
	}
	
	@Test(priority = 1)
	public void test_valid_login() {
		Assert.assertTrue(objRegister.user_registration());
	}
	
	@AfterMethod
	public void tearDown() {
		objRegister.close_browser();
	}
	
	
}
