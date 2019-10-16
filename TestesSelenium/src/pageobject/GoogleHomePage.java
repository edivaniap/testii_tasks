package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {

	private WebDriver driver;

	private String urlBase = "https://www.google.com/";

	public GoogleHomePage(WebDriver driver) {
	
		this.driver = driver;
		
		driver.get(urlBase);
	
	}

	
	public void consulta(String con){
		
		driver.findElement(By.name("q")).clear();
		
		driver.findElement(By.name("q")).sendKeys(con);
		
		driver.findElement(By.name("btnK")).click();
	}
	
	
	public boolean temNoTitulo(String titulo) { 
		
		return driver.getTitle().contains(titulo)?true:false;
	
	}
	
}
