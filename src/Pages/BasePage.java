package Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.SetConexion;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public void IniciarBrowser() 
	{
		this.driver = SetConexion.setup();
		wait = new WebDriverWait(driver, 10);
	}
	
	public void IngresarGoogle() {
		driver.get("https://www.google.com.ar");
	}

	/*
	 * Espera N milisegundos
	 */
	public static void espera(long milisec) {
		try {
			
			Thread.sleep(milisec);			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Selecciona un elemento de la listbox segun el valor
	 */
	public void setSimpleDropdown(WebElement element, String value) {
		Select field = new Select(element);
		element.click();
		field.selectByVisibleText(value);
	}

	/*
	 * Selecciona un elemento de la listbox segun el texto parcial
	 */
	public void setSimpleDropdownByPartialText(WebElement element, String parcialText) {
		String rutaXpath = "//option[contains(text(),'" + parcialText + "')]";
		element.click();
		element.findElement(By.xpath(rutaXpath)).click();
	}

	/*
	 * Lee el elmento de la listbox seleccionado
	 */
	public String getSimpleDropdown(WebElement element) {
		Select field = new Select(element);
		String a = field.getFirstSelectedOption().getText();
		return a;
	}

	/*
	 * Selecciona un elemento de una listbox con las flechas segun el valor
	 */
	public void setElementFromList(WebElement element, String value, WebElement arrow) {
		Select field = new Select(element);
		field.selectByVisibleText(value);
		arrow.click();
	}

	/*
	 * Selecciona un elemento de una lista de array segun el texto
	 */
	public WebElement getElementFromList(List<WebElement> elements, String field) {
		List<Integer> a = new ArrayList<>();
		Integer i = 0;
		for (WebElement e : elements) {
			if (e.getText().equals(field)) {
				a.add(i);
			}
			i++;
		}
		return elements.get(a.get(0));
	}

	/*
	 * Setea el estado de un checkbox
	 */
	public void seteaCheckbox(WebElement elemento, boolean estado) {
		if (estado) {
			if (!elemento.isSelected())
				elemento.click();
		} else {
			if (elemento.isSelected())
				elemento.click();
		}
	}

	/*
	 * Scrollea hasta el elemento y lo clickea
	 */
	public void scrollandclick(WebElement element) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0," + element.getLocation().y + ")");
		element.click();
	}

	/*
	 * WAIT FOR ELEMENT VISIBLE
	 */
	public void waitForElementVisible(WebElement we, int segundos) {
		WebDriverWait wait = new WebDriverWait(driver, segundos);		
		wait.until(ExpectedConditions.visibilityOf(we));		
	}
	
	/*
	 * Imprime los estados de un elemento, ciclicamente
	 */
	public void ChequeaPropiedadElemento(WebElement elemento) {
		for (int i = 0; i < 30; i++) {
			if (elemento.isDisplayed())
				System.out.println("es displayed");
			if (elemento.isEnabled())
				System.out.println("es enabled");
			if (elemento.isSelected())
				System.out.println("es selected");
			espera(2000);
		}
	}
	
	protected Random aleatorio = new Random(System.currentTimeMillis());
	
}
