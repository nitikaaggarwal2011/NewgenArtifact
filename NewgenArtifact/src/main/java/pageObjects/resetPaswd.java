package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resetPaswd {
	
public WebDriver driver;
	
	By paswdEnter=By.xpath("//input[@name='passwd']");
	By confirmPaswd=By.xpath("//input[@name='confirmation']");
	By changePasBtn=By.xpath("//button[text()=' Change Password ']");
	
	public resetPaswd(WebDriver driver) {	
		this.driver=driver;
	}


	public WebElement paswdEnter()
	{
		return driver.findElement(paswdEnter);

	}
	
	public WebElement confirmPaswd()
	{
		return driver.findElement(confirmPaswd);

	}
	
	public WebElement changePasBtn()
	{
		return driver.findElement(changePasBtn);

	}
	



}
