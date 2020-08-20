package br.com.desafio.page;

import org.openqa.selenium.WebDriver;

import br.com.desafio.dsl.DSL;

//Clase PAGE deve conter todos os métodos que fazem acesso a pagina especifica
public class DesafioSeleniumPage {

	private DSL dsl;
	
	public DesafioSeleniumPage(WebDriver driver) {
		dsl = new DSL(driver);
	}
	
	//Id como chave
	public void setEmail(String email) {
		dsl.escreverUsandoID("email", email);
	}
	//Id como chave
	public void setSenha(String senha) {
		dsl.escreverUsandoID("passwd", senha);
	}
	
	public void setEfetuarLogin() {
		dsl.clicar("//p[@class='submit']//span[1]");
	}
	
	public String loginSucesso() {
		return dsl.obterResposta("//h3[contains(text(),'Successfully Logged in...')]");
	}
	//XPath como chave
	public void setCustomerId(String valor) {
		dsl.escreverUsandoXPath("//input[@name='cusid']", valor);
	}
	public void clicarEmSubmit() {
		dsl.clicar("//input[@name='submit']");
	}
	public String mensagemAlerta() {
		return dsl.obterMensagemAlerta();
	}
	public void aceitarAlerta() {
		dsl.aceitarAlerta();
	}
	public void moverTextoBank() {
		dsl.segurarMouse(700, 500);
		dsl.arrastarMouse(350, 700);
	}
	public String obterTextoBank() {
		return dsl.obterResposta("//li[contains(text(),'BANK')]");
	}
	public void moverValorBank() {
		dsl.segurarMouse(400, 500);
		dsl.arrastarMouse(650, 700);
	}
	public String obterTextoValorBank() {
		return dsl.obterResposta("//ol[@id='amt7']//li[contains(text(),'5000')]");
	}
	public void moverTextoSales() {
		dsl.segurarMouse(800, 500);
		dsl.arrastarMouse(950, 700);
	}
	public String obterTextoSales() {
		return dsl.obterResposta("//li[contains(text(),'SALES')]");
	}
	public void moverValorSales() {
		dsl.segurarMouse(600, 500);
		dsl.arrastarMouse(1100, 700);
	}
	public String obterTextoValorSales() {
		return dsl.obterResposta("//ol[@id='amt8']//li[contains(text(),'5000')]");
	}
	public String obterPerfect() {
		return dsl.obterResposta("//a[contains(text(),'Perfect!')]");
	}
	

}
