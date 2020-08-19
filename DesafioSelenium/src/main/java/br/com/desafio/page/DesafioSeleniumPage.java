package br.com.desafio.page;

import org.openqa.selenium.WebDriver;

import br.com.desafio.dsl.DSL;

//Clase PAGE deve conter todos os métodos que fazem acesso a pagina especifica
public class DesafioSeleniumPage {

	private DSL dsl;

	public DesafioSeleniumPage(WebDriver driver) {
		dsl = new DSL(driver);
	}

	public void setEmail(String email) {
		dsl.escrever("email", email);
	}

	public void setSenha(String senha) {
		dsl.escrever("passwd", senha);
	}
	
	public void setEfetuarLogin() {
		dsl.clicar("//p[@class='submit']//span[1]");
	}
	
	public String loginSucesso() {
		return dsl.obterRespostaLogar();
	}

}
