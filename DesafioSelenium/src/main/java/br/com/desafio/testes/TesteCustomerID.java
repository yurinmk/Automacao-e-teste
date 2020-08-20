package br.com.desafio.testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.desafio.page.DesafioSeleniumPage;


public class TesteCustomerID {
	
	private String key = "webdriver.chrome.driver";
	private String path = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	
	private WebDriver driver;
	DesafioSeleniumPage page;
	
	@Before
	public void acessarBrowser() {
		System.setProperty(this.key, this.path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/test/delete_customer.php");
		page = new DesafioSeleniumPage(driver);
		
	}
	@After
	public void fecharBrowser() {
			driver.quit();
	}
	@Test
	public void testeCustomerID() throws InterruptedException {
		page.setCustomerId("123456789");
		page.clicarEmSubmit();
		//Thread serve para fazer a pagina esperar. É preciso porque as vezes pode ocorrer um atraso na aparição do alerta 
		//E se a validação ocorrer antes do alerta aparecer, isso automaticamente irá gerar um erro
		Thread.sleep(3000);
		Assert.assertEquals("Do you really want to delete this Customer?", page.mensagemAlerta());
		page.aceitarAlerta();
		
		Thread.sleep(3000);
		Assert.assertEquals("Customer Successfully Delete!", page.mensagemAlerta());
		page.aceitarAlerta();
	}

}
