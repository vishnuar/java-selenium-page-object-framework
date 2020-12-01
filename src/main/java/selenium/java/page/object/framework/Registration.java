package selenium.java.page.object.framework;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
	
	WebDriver driver;
	public String baseurl = "https://vishnuar.pythonanywhere.com/register/";
	public String reponse_msg = "Registration successful! Please login. ";
	
	//*****Login page locators*******//
	By firstname_txt = By.id("first_name");
	By lastname_txt = By.id("last_name");
	By username_txt = By.id("username");
	By email_txt = By.id("email");
	By pwd_txt = By.id("pwd");
	By con_pwd_txt = By.id("confirm_pwd");
	By register_btn = By.id("register");
	By h1_tag = By.xpath("/html/body/div[1]/h1"); 
	By register_alert = By.xpath("/html/body/div[1]");
			
	public Registration(WebDriver driver) {
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
	
	public boolean user_registration() {
		Random rand = new Random();
		
		driver.findElement(firstname_txt).sendKeys("Firstname"+rand.nextInt(1000));
		driver.findElement(lastname_txt).sendKeys("Lastname"+rand.nextInt(1000));
		driver.findElement(username_txt).sendKeys("Username"+rand.nextInt(1000));
		driver.findElement(email_txt).sendKeys("email"+rand.nextInt(1000)+"@test.com");
		driver.findElement(pwd_txt).sendKeys("123456");
		driver.findElement(con_pwd_txt).sendKeys("123456");
		driver.findElement(register_btn).click();
		String register_msg = driver.findElement(register_alert).getAttribute("textContent");
		if(register_msg.equals(reponse_msg)) {
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
