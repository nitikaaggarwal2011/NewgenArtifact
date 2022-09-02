package Nitika;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.fogotPaswd;
import pageObjects.pageObjects;
import pageObjects.resetPaswd;
import pageObjects.yopmailVerify;
import resources.base;

@Test
public class newGenAssignment extends base {

	public newGenAssignment() throws IOException {
		super();
	}

	@BeforeTest
	public void getStarted() {
		System.out.println("execution started");
	}

	@Test
	public void loginVerifyOnChrome() throws InterruptedException {

		System.out.println("Chrome browser");
		openBrowser("Chrome");
		driver.get(prop.getProperty("url"));

		// 1. login credentials are valid or not
		// 2. check forgotten Password
		pageObjects obj = new pageObjects(driver);
		obj.myacc().click();
		obj.signin().click();
		String testEmail = prop.getProperty("testEmail");
		obj.getemail().sendKeys(testEmail);

		String Paswd = prop.getProperty("wrongPaswd");
		obj.getpaswd().sendKeys(Paswd);
		obj.btnclk().click();

		int size = driver.findElements(By.xpath("//div[@class='help-block']")).size();

		if (size == 1) {
			fogotPaswd fp = obj.forgotpd();
			fp.getemailAddress().sendKeys(testEmail);

			yopmailVerify yopObj = fp.sendBtn();
			driver.get(prop.getProperty("yopmailUrl"));
			yopObj.getemailAddress().sendKeys(testEmail);
			yopObj.search().click();
			yopObj.frameLeft();
			yopObj.paswdTextLeft().click();
			yopObj.frameEmail();

			String win1 = driver.getWindowHandle();
			resetPaswd rp = yopObj.forgotLink();
			Set<String> wins = driver.getWindowHandles();
			for (String w : wins) {
				if (w != win1)
					driver.switchTo().window(w);
			}

			rp.paswdEnter().sendKeys("meenu@1986");
			rp.confirmPaswd().sendKeys("meenu@1986");
			rp.changePasBtn().click();
		}

		else {
			driver.get(prop.getProperty("loginURL"));
		}

		// 4.click some special coordinate set by user(take some user input from config
		// file)
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Need help')]"));

		int xC = ele.getLocation().getX();
		int yC = ele.getLocation().getY();
		Actions act = new Actions(driver);
		act.moveByOffset(xC, yC).click().build().perform();

		// 3.set resolution (set dimension value based on that web page open as full
		// screen)
		Dimension d1 = driver.manage().window().getSize();
		int h = d1.getHeight();
		int w = d1.getWidth();

		Dimension d = new Dimension(w - 88, h - 67);
		driver.manage().window().setSize(d);
		driver.close();

	}

	@Test
	public void loginVerifyOnEdge() throws InterruptedException {
		System.out.println("Edge browser");
		openBrowser("Edge");
		driver.get(prop.getProperty("url"));

		// 1. login credentials are valid or not
		// 2. check forgotten Password
		pageObjects obj = new pageObjects(driver);
		obj.myacc().click();
		obj.signin().click();
		String testEmail = prop.getProperty("testEmail");
		obj.getemail().sendKeys(testEmail);

		String Paswd = prop.getProperty("correctPaswd");
		obj.getpaswd().sendKeys(Paswd);
		obj.btnclk().click();

		int size = driver.findElements(By.xpath("//div[@class='help-block']")).size();

		if (size == 1) {
			fogotPaswd fp = obj.forgotpd();
			fp.getemailAddress().sendKeys(testEmail);

			yopmailVerify y = fp.sendBtn();
			driver.get(prop.getProperty("yopmailUrl"));
			y.getemailAddress().sendKeys(testEmail);
			y.search().click();
			y.frameLeft();
			y.paswdTextLeft().click();
			y.frameEmail();

			String win1 = driver.getWindowHandle();
			resetPaswd rp = y.forgotLink();
			Set<String> wins = driver.getWindowHandles();
			for (String w : wins) {
				if (w != win1)
					driver.switchTo().window(w);
			}

			rp.paswdEnter().sendKeys("meenu@1986");
			rp.confirmPaswd().sendKeys("meenu@1986");
			rp.changePasBtn().click();
		}

		else {
			driver.get(prop.getProperty("loginURL"));
		}

		// 4.click some special coordinate set by user(take some user input from config
		// file)
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Need help')]"));

		int xC = ele.getLocation().getX();
		int yC = ele.getLocation().getY();
		Actions act = new Actions(driver);
		act.moveByOffset(xC, yC).click().build().perform();

		// 3.set resolution (set dimension value based on that web page open as full
		// screen)
		Dimension d1 = driver.manage().window().getSize();
		int h = d1.getHeight();
		int w = d1.getWidth();

		Dimension d = new Dimension(w - 88, h - 67);
		driver.manage().window().setSize(d);
		driver.close();
	}

	@Test
	public void loginVerifyOnFirefox() throws InterruptedException {
		System.out.println("Firefox browser");
		openBrowser("Firefox");
		driver.get(prop.getProperty("url"));

		// 1. login credentials are valid or not
		// 2. check forgotten Password
		pageObjects obj = new pageObjects(driver);
		obj.myacc().click();
		obj.signin().click();
		String testEmail = prop.getProperty("testEmail");
		obj.getemail().sendKeys(testEmail);

		String Paswd = prop.getProperty("correctPaswd");
		obj.getpaswd().sendKeys(Paswd);
		obj.btnclk().click();

		int size = driver.findElements(By.xpath("//div[@class='help-block']")).size();

		if (size == 1) {
			fogotPaswd fp = obj.forgotpd();
			fp.getemailAddress().sendKeys(testEmail);

			yopmailVerify y = fp.sendBtn();
			driver.get(prop.getProperty("yopmailUrl"));
			y.getemailAddress().sendKeys(testEmail);
			y.search().click();
			y.frameLeft();
			y.paswdTextLeft().click();
			y.frameEmail();

			String win1 = driver.getWindowHandle();
			resetPaswd rp = y.forgotLink();
			Set<String> wins = driver.getWindowHandles();
			for (String w : wins) {
				if (w != win1)
					driver.switchTo().window(w);
			}

			rp.paswdEnter().sendKeys("meenu@1986");
			rp.confirmPaswd().sendKeys("meenu@1986");
			rp.changePasBtn().click();
		}

		else {
			driver.get(prop.getProperty("loginURL"));
		}

		// 4.click some special coordinate set by user(take some user input from config
		// file)
		Thread.sleep(5000);
		WebElement ele = driver.findElement(By.xpath("//span[contains(text(),'Need help')]"));

		int xC = ele.getLocation().getX();
		int yC = ele.getLocation().getY();
		Actions act = new Actions(driver);
		act.moveByOffset(xC, yC).click().build().perform();

		// 3.set resolution (set dimension value based on that web page open as full
		// screen)
		Dimension d1 = driver.manage().window().getSize();
		int h = d1.getHeight();
		int w = d1.getWidth();

		Dimension d = new Dimension(w - 88, h - 67);
		driver.manage().window().setSize(d);

	}

	@AfterTest
	public void teardown() {
		driver.quit();
		System.out.println("execution finished");
	}

}
