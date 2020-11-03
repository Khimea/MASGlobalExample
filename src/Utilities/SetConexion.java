package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SetConexion {
	static WebDriver driver;	
	
	public static WebDriver setup() {
		System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
	    ChromeOptions options = new ChromeOptions();
	    //Inicia el browser maximizado
	    options.addArguments("start-maximized");
	    
	    /*
	     * Seteo handless- Comentar los siguientes 2 argumentos para poder visualizar los browsers
	     */
	    //Se escala para evitar NosuchElement
	 //   options.addArguments("window-size=1920,1080");
	    //Se ejecuta todo en memoria interna sin necesidad de visualizar los browsers
	  //  options.addArguments("headless");
	    /*
	     * 
	     */
	    
	    driver = new ChromeDriver(options);
	    return driver;
	}
	}