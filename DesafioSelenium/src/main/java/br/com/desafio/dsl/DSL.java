package br.com.desafio.dsl;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Classe DSL para facilitar o reuso dos codigos.
public class DSL {
	
	private WebDriver driver;
	private Alert alerta;
	private Robot mexerMouse;

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
	public String obterResposta(String xpath) {
		return driver.findElement(By.xpath(xpath)).getText();
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
	public void segurarMouse(int x, int y) {
		try {
			mexerMouse = new Robot();
			mexerMouse.mouseMove(x, y);
			mexerMouse.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		} catch (AWTException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		
	}
	public void arrastarMouse(int x, int y) {
		mexerMouse.mouseMove(x, y);
		mexerMouse.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

	}
	

}
