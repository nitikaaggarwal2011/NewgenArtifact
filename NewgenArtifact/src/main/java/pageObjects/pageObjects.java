package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pageObjects {
	
public WebDriver driver;
	
	By myacc=By.xpath("//span[text()='My Account']");
	By signin=By.xpath("//span[text()='Sign in']");
	By email=By.cssSelector("input[class='form-control']");
	By paswd=By.cssSelector("input[class*='visible-password']");
	By btnclk=By.id("submit-login");
	By forgotpd=By.xpath("//a[@href='https://hunyhuny.com/password-recovery']");
	
	
	public pageObjects(WebDriver driver) {	
		this.driver=driver;
	}
	
	public WebElement myacc()
	{
		return driver.findElement(myacc);

	}
	
	public WebElement signin()
	{
		return driver.findElement(signin);

	}
	public WebElement getemail()
	{
		return driver.findElement(email);

	}
	
	public WebElement getpaswd()
	{
		return driver.findElement(paswd);

	}
	public WebElement btnclk()
	{
		return driver.findElement(btnclk);

	}
	public fogotPaswd forgotpd()
	{
		driver.findElement(forgotpd).click();
		fogotPaswd f=new fogotPaswd(driver);
		return f;

	}


}
