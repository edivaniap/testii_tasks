package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class GoogleHomePageMelhorado {

	private WebDriver driver;

	@FindBy(name = "q")
	private WebElement campoBusca;
	
	//FORMA ALTERNATIVA PARA ENCONTRAR UM ELEMENTO
	@FindBy(how = How.NAME, using = "q")
	private WebElement campoBusca2;

	
	
	@FindBy(name = "btnK")
	private WebElement botaoBusca;
	
	//FORMA ALTERNATIVA PARA ENCONTRAR UM ELEMENTO
	@FindBy(how = How.NAME, using = "btnK")
	private WebElement botaoBusca2;
	

	private String urlBase = "https://www.google.com/";

	
	public GoogleHomePageMelhorado(WebDriver driver) {
		this.driver = driver;
		driver.get(urlBase);
		PageFactory.initElements(driver, this);
	}

	
	public void consulta(String con){
		
		campoBusca.clear();
		campoBusca.sendKeys(con);
		botaoBusca.click();
	}
	
	
	public boolean temNoTitulo(String titulo) { 
		
		return driver.getTitle().contains(titulo)?true:false;
	
	}
	
}
