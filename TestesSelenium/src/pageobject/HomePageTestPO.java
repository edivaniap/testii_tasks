package pageobject;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTestPO {

		private static WebDriver driver;
		private static String driverPath = "/home/edivaniap/JARs/chromedriver";
			  
		
		@BeforeClass 
		public static void setUp() {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterClass public static void tearDown() {
			driver.close(); 
		}
		
		@Test 
		public void testHome(){
			GoogleHomePage homePage = new GoogleHomePage(driver);
			homePage.consulta("TRT21");  
			assertTrue(homePage.temNoTitulo("TRT21"));
		}
	
		
		@Test 
		public void testHomeMelhorado(){
			GoogleHomePageMelhorado homePage = new GoogleHomePageMelhorado(driver);
			homePage.consulta("TRT22");  
			assertTrue(homePage.temNoTitulo("TRT22"));
		}
}

