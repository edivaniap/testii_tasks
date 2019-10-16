import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGithub {
	private static WebDriver driver;
	  
	private static String urlBase;
	
	private static String driverPath = "/home/edivaniap/JARs/chromedriver";
	
    @BeforeClass 
	public static void setUp() {
		
    	System.setProperty("webdriver.chrome.driver", driverPath);
		
    	driver = new ChromeDriver();
		
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
    	urlBase = "https://github.com/login";
    }
    
	@Test
	public void test() {
		driver.get(urlBase);
	    
		driver.findElement(By.name("login")).clear();
	    
		driver.findElement(By.name("login")).sendKeys("edivaniap");
		
		driver.findElement(By.name("password")).clear();
		
		driver.findElement(By.name("password")).sendKeys("crazyhacker");
	    
		driver.findElement(By.name("commit")).click();
	    
		//verificar se retornou para pag de login pois a senha eh incorreta
		assertTrue(driver.getTitle().contains("Sign in"));	
	}
	
    @AfterClass 
	public static void tearDown() {
		driver.close(); 
	}
}


