package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class yopmailVerify {
	
public WebDriver driver;
	
	By emailAddress=By.xpath("//input[@title='Login']");
	By search=By.id("refreshbut");
	By frameLeft=By.id("ifinbox");
	By paswdTextLeft=By.xpath("//div[text()='[HunyHuny - Mother & Baby Care] Password query confirmation']");
	By frameEmail=By.id("ifmail");
	By forgotLink=By.xpath("//table/tbody/tr[4] //a");
	
	public yopmailVerify(WebDriver driver) {	
		this.driver=driver;
	}

	
	public WebElement getemailAddress()
	{
		return driver.findElement(emailAddress);

	}
	
	public WebElement search()
	{
		return driver.findElement(search);

	}
	public void frameLeft()
	{
		driver.switchTo().frame(driver.findElement(frameLeft));

	}
	public WebElement paswdTextLeft()
	{
		return driver.findElement(paswdTextLeft);

	}
	public void frameEmail()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(frameEmail));

	}
	public resetPaswd forgotLink()
	{
		driver.findElement(forgotLink).click();
		resetPaswd rp=new resetPaswd(driver);
		return rp;

	}

}
