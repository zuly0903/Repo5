package mavenfive;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Read_Property {
	
	public static Properties prop;
	public static FileInputStream input;
	public static WebDriver driver;

	public static void main(String[] args) throws Exception {
		
		System.out.println(System.getProperty("user.dir"));
		//C:\Users\zuly0\eclipse-workspace\Maven_Five
		String path = System.getProperty("user.dir") +"\\src\\test\\java\\mavenfive\\config.properties";
		
		prop = new Properties();
		input = new FileInputStream(path);
		prop.load(input);
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("signinlink"));
		System.out.println(prop.getProperty("unamexpath"));
		System.out.println(prop.getProperty("uname"));
		System.out.println(prop.getProperty("passwordxpath"));
		System.out.println(prop.getProperty("password"));
		System.out.println(prop.getProperty("signinbtn"));
		System.out.println(prop.getProperty("logout"));
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath(prop.getProperty("signinlink"))).click();
		driver.findElement(By.xpath(prop.getProperty("unamexpath"))).sendKeys(prop.getProperty("uname"));
		driver.findElement(By.xpath(prop.getProperty("passwordxpath"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath(prop.getProperty("signinbtn"))).click();
		driver.findElement(By.xpath(prop.getProperty("logout"))).click();
		
		driver.quit();
	}
}
