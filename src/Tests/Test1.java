package Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.BasePage;
import Pages.methodPage;

public class Test1 extends BasePage {

	@BeforeMethod
	public void SetUp() {
		IniciarBrowser();
		IngresarGoogle();
		
	}
	
	@AfterMethod
	public void exit() {
		driver.close();
		driver.quit();
	}
	
	@Test
	public void scenario1() {
		methodPage Mtds = new methodPage(driver);
		Mtds.Search("The name of the wind");
		Mtds.btnSearch();
		Mtds.searchTitle("The Books - Patrick Rothfuss");
		Assert.assertTrue(Mtds.verifyLink("https://www.patrickrothfuss.com/content/books.asp"));
	}
	
	@Test
	public void scenario2() {
		methodPage Mtds = new methodPage(driver);
		Mtds.Search("The name of the w");
		Mtds.clickFirstSugg();
		Mtds.searchTitle("The Books - Patrick Rothfuss");
		Assert.assertTrue(Mtds.verifyLink("https://www.patrickrothfuss.com/content/books.asp"));

	}
}
