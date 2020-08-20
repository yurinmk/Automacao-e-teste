package br.com.desafio.testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.desafio.page.DesafioSeleniumPage;


//Classe de teste
public class TesteLogin{
	
	//OBS: Usa o navegador Chrome
	//System.getProperty("user.dir") - retorna a raiz do projeto
	private String key = "webdriver.chrome.driver";
	private String path = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe"; //"G:\\WS\\SeleniumDrivers\\chromedriver.exe";
	
	private WebDriver driver;
	private DesafioSeleniumPage page;
	
	//Anotação para instanciar o chrome e fazer a navegação da URL
	@Before
	public void acessarBrowser() {
		System.setProperty(this.key, this.path);
		driver = new ChromeDriver();
		driver.navigate().to("http://demo.guru99.com/test/login.html");
		page = new DesafioSeleniumPage(driver);
		
	}
	//Anotação para fechar o driver e o navegador
	@After
	public void fecharBrowser() {
			driver.quit();
	}
	//Anotação para fazer o teste de login
	@Test
	public void testeDeLogin() {
		page.setEmail("qualquercoisa@outlook.com");
		page.setSenha("123");
		page.setEfetuarLogin();
		
		Assert.assertEquals("Successfully Logged in...", page.loginSucesso());
		
	}

}
