package resources;

import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	
    public String getEdgeBrowser() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Selenium\\SeleniumWorkspace\\NewgenArtifact\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println("broswer invoked successfully"+ browserName);
		
		return browserName;
	}
    
    public String getChromeBrowser() throws IOException {
		prop=new Properties();
		FileInputStream fis=new FileInputStream("D:\\Selenium\\SeleniumWorkspace\\NewgenArtifact\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("Chrome");
		System.out.println("broswer invoked successfully"+ browserName);
		
		return browserName;
	}
    
}
