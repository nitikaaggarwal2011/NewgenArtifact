package Nitika;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObjects.fogotPaswd;
import pageObjects.pageObjects;
import pageObjects.resetPaswd;
import pageObjects.yopmailVerify;
import resources.base;

@Test
public class newGenAssignment extends base{
	
	    public WebDriver driver;
	
	    
	  //  @Parameters("browser")
	   // @BeforeTest
		public void initialize() throws IOException
		{
	    	// String broswerName=browser;
	    	String broswerName=getEdgeBrowser();
	    	System.out.println(broswerName);
	    		
			if(broswerName.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\ChromeDriver\\chromedriver.exe");
				
				ChromeOptions options=new ChromeOptions();
				if(broswerName.contains("headless"))
				{ options.addArguments("headless"); }
				driver= new ChromeDriver(options);
				
			}
			else if(broswerName.equalsIgnoreCase("Firefox"))
			{
				
			}
			else if(broswerName.equalsIgnoreCase("Edge"))
			{
				System.setProperty("webdriver.edge.driver", "D:\\Selenium\\EdgeDriver\\msedgedriver.exe");

				driver= new EdgeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			}
			
		}
	    
	    @Test(priority=0)
	    public void loginVerify() {
	    	driver.get(prop.getProperty("url"));
	  
	    	pageObjects obj=new pageObjects(driver);
	    	obj.myacc().click();
	    	obj.signin().click();
	    	String testEmail=prop.getProperty("testEmail");
	    	obj.getemail().sendKeys(testEmail);
	    	
	    	String Paswd=prop.getProperty("correctPaswd");
	    	obj.getpaswd().sendKeys(Paswd);
	    	obj.btnclk().click();
	   
	    	int size= driver.findElements(By.xpath("//div[@class='help-block']")).size();
	    	
	    	if(size==1) 
	    	{
	    	fogotPaswd fp=obj.forgotpd();
	    	fp.getemailAddress().sendKeys(testEmail);
	    	
	    	yopmailVerify y=fp.sendBtn();
	    	driver.get(prop.getProperty("yopmailUrl"));
	    	y.getemailAddress().sendKeys(testEmail); 
	    	y.search().click();
	    	y.frameLeft();
	    	y.paswdTextLeft().click();
	    	y.frameEmail();
	    	
	    	String win1=driver.getWindowHandle();
	    	resetPaswd rp=    y.forgotLink();
	    	Set<String> wins=driver.getWindowHandles();
	    	for(String w: wins) {
	    		if(w!=win1)
	    			driver.switchTo().window(w);
	    	}
	    
	    	rp.paswdEnter().sendKeys("meenu@1986");
	    	rp.confirmPaswd().sendKeys("meenu@1986");
	    rp.changePasBtn().click();
	    	}	
	    	
	    	else {
	    		driver.get(prop.getProperty("loginURL"));
	    	}
			
		}
	    
	    @Test(priority=2)
	    public void setBroswerSize() {
	    	
	    	Dimension d1=driver.manage().window().getSize();
	        int h=d1.getHeight();
	        int w=d1.getWidth();
	        System.out.println(h);
	        System.out.println(w);
	        
	    	Dimension d=new Dimension(w-88,h-67);
	    	driver.manage().window().setSize(d);	
	    }
	    
	    @Test(priority=1)
	    public void clkOffset() throws InterruptedException {
	    	
	    	Thread.sleep(5000);
	    	WebElement ele=driver.findElement(By.xpath("//span[contains(text(),'Need help')]"));
	    	
	    
            int xC=ele.getLocation().getX();
	        int yC=ele.getLocation().getY();
	        Actions act=new Actions(driver);
	        act.moveByOffset(xC, yC).click().build().perform();
	    }
	    
	    @AfterTest 
		public void teardown()
		{
			driver.close();
		}


}
