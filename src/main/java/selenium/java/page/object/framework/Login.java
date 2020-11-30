package selenium.java.page.object.framework;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Login {
	
	WebDriver driver;
	public String baseurl = "https://vishnuar.pythonanywhere.com/login/";
	
	//*****Login page locators*******//
	By login_txt = By.id("username");
	By pwd_text = By.id("password");
	By login_btn = By.id("loginbtn");
	By h1_tag = By.xpath("/html/body/div[1]/h1");
			
	public Login(WebDriver driver) {
		this.driver = driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseurl);
	}
	
	public boolean getH1text(String input_txt) {
		String h1_text = driver.findElement(h1_tag).getAttribute("textContent");
		if(h1_text.equals(input_txt)) 
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public boolean valid_user_credentails(String username, String password) {
		driver.findElement(login_txt).sendKeys(username);
		driver.findElement(pwd_text).sendKeys(password);
		driver.findElement(login_btn).click();
		String url_now = driver.getCurrentUrl();
		if(url_now.contains("noteapp")) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean invalid_user_credentails(String username, String password) {
		driver.findElement(login_txt).sendKeys(username);
		driver.findElement(pwd_text).sendKeys(password);
		driver.findElement(login_btn).click();
		String url_now = driver.getCurrentUrl();
		if(!(url_now.contains("noteapp"))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void close_browser() {
		driver.close();
	}
}
