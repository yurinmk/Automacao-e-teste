package br.com.desafio.testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.desafio.page.DesafioSeleniumPage;


public class TesteArrastarElemento {
	
	private String key = "webdriver.chrome.driver";
	private String path = System.getProperty("user.dir") + "/src/test/resources/drivers/chromedriver.exe";
	
	private WebDriver driver;
	private DesafioSeleniumPage page;
	
	@Before
	public void acessarBowser() {
		System.setProperty(this.key, this.path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
		page = new DesafioSeleniumPage(driver);
	}
	@After
	public void fecharBrowser() {
			driver.quit();
	}
	@Test
	public void testeArrastarElementos() throws InterruptedException  {
		
		page.moverTextoBank();
		Assert.assertEquals("BANK", page.obterTextoBank());
		
		page.moverValorBank();
		Assert.assertEquals("5000", page.obterTextoValorBank());
		
		page.moverTextoSales();
		Assert.assertEquals("SALES", page.obterTextoSales());
		
		page.moverValorSales();
		Assert.assertEquals("5000", page.obterTextoValorSales());
		
		
		Assert.assertEquals("Perfect!", page.obterPerfect());
		
	}

}
