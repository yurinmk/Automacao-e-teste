package br.com.desafio.dsl;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Classe DSL para facilitar o reuso dos codigos.
public class DSL {
	
	private WebDriver driver;
	private Alert alerta;

	public DSL(WebDriver driver) {
		this.driver = driver;
	}
	//método para escrever usando id
	public void escreverUsandoID(String id, String valor) {
		driver.findElement(By.id(id)).sendKeys(valor);
	}
	public void clicar(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}
	public String obterRespostaLogar() {
		return driver.findElement(By.xpath("//h3[contains(text(),'Successfully Logged in...')]")).getText();
	}
	//Método para escrever usando o xpath
	public void escreverUsandoXPath(String xpath, String valor) {
		driver.findElement(By.xpath(xpath)).sendKeys(valor);
	}
	//Metodo para retornar a mensagem que aparece no alerta
	public String obterMensagemAlerta() {
		alerta = driver.switchTo().alert();
		return alerta.getText();
	}
	//Método para aceitar o alerta
	public void aceitarAlerta() {
		alerta.accept();
	}
	

}
