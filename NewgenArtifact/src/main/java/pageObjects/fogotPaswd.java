package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class fogotPaswd {
	
public WebDriver driver;
	
	By emailAddress=By.id("email");
	By sendBtn=By.xpath("//button[text()=' Send reset link ']");
	
	public fogotPaswd(WebDriver driver) {	
		this.driver=driver;
	}

	
	public WebElement getemailAddress()
	{
		return driver.findElement(emailAddress);

	}
	
	public yopmailVerify sendBtn()
	{
		driver.findElement(sendBtn).click();
		yopmailVerify y=new yopmailVerify(driver);
		return y;

	}
	


}
