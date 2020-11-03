package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class methodPage extends obj_homepage {

	
	public methodPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Search(String searching) {
		waitForElementVisible(txtboxSearch, 10);
		txtboxSearch.sendKeys(searching);
		
	}
	
	public void btnSearch() {
		driver.switchTo().defaultContent();
		btnSearchGoogle.click();
	}
	
	public void clickFirstSugg() {
		espera(500);
		listSugg.get(0).click();
	}
	public void searchTitle(String title) {
		for ( WebElement e: resultCards) {
			WebElement el = e.findElement(By.cssSelector(".LC20lb.DKV0Md"));
			if(el.getText().equals(title)) {
				el.click();
				break;
			}
		}
	}
	
	public boolean verifyLink(String url) {
		
		return driver.getCurrentUrl().toString().equals(url);
	}
}
