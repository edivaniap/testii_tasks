

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteGoogle {
  
  private static WebDriver driver;
 
  private static String urlBase;
  
  //Apontar para o arquivo do ChromeDriver que vc baixou
    private static String driverPath = "/home/edivaniap/JARs/chromedriver";
  
    @BeforeClass 
	public static void setUp() {
		
    	System.setProperty("webdriver.chrome.driver", driverPath);
		
    	driver = new ChromeDriver();
		
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
    	urlBase = "https://www.google.com/";
    }
  
	@Test
	public void testEGoogle() {
	    
		driver.get(urlBase);
	    
		driver.findElement(By.name("q")).clear();
	    
		driver.findElement(By.name("q")).sendKeys("TRT21");
	    
		driver.findElement(By.name("btnK")).click();
	    
		assertTrue(driver.getTitle().contains("TRT21"));	    
	}
  
    @AfterClass 
	public static void tearDown() {
		driver.close(); 
	}

}
