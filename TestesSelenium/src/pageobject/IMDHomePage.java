package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class IMDHomePage {

	private WebDriver driver;

	@FindBy(how = How.ID, using = "titulo")
	private WebElement campoPesquisa;

	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='+'])[1]/following::i[2]")
	private WebElement botaoPesquisar;

	@FindBy(how = How.XPATH, using = "(.//*[normalize-space(text()) and normalize-space(.)='Resultados da pesquisa por'])[1]/following::h4[1]")
	private WebElement resultado;

	private String urlBase = "https://www.imd.ufrn.br/portal/";

	public IMDHomePage(WebDriver driver) {
		this.driver = driver;
		driver.get(urlBase);
		PageFactory.initElements(driver, this);
	}

	public String pesquisar(String chave) {
		campoPesquisa.clear();
		campoPesquisa.sendKeys(chave);
		botaoPesquisar.click();

		return resultado.getText();
	}

	public boolean temNoTitulo(String titulo) {
		return driver.getTitle().contains(titulo) ? true : false;
	}
}
