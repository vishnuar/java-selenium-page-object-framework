package selenium.java.page.object.framework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.java.page.object.framework.Login;

public class LoginTest {
	
	static WebDriver driver;
	Login objLogin;
	
	@BeforeMethod
	public void setup() {
		//Setting system properties of ChromeDriver
		System.setProperty("webdriver.chrome.driver", "C://Personal//chromedriver//chromedriver.exe");

		//Creating an object of ChromeDriver
		WebDriver driver = new ChromeDriver();
		objLogin = new Login(driver);
	}
	
	@Test(priority = 0)
	public void test_login_page_load() {
		Assert.assertTrue(objLogin.getH1text(" User Login "));
	}
	
	@Test(priority = 1)
	public void test_valid_login() {
		Assert.assertTrue(objLogin.valid_user_credentails("Sachin", "123456"));
	}
	
	@Test(priority = 2)
	public void test_invalid_login() {
		Assert.assertTrue(objLogin.invalid_user_credentails("Sachin", "12345678"));
	}
	
	@AfterMethod
	public void tearDown() {
		objLogin.close_browser();
	}
	
	
}
