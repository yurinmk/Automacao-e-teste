package br.com.desafio.dsl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Classe DSL para facilitar o reuso dos codigos.
public class DSL {
	
	private WebDriver driver;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	
	public void escrever(String id, String valor) {
		driver.findElement(By.id(id)).sendKeys(valor);
	}
	public void clicar(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public String obterRespostaLogar() {
		return driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in...')]")).getText();
	}

}
