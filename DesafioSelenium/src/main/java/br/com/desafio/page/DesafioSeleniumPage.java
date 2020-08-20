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
		return dsl.obterRespostaLogar();
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

}
