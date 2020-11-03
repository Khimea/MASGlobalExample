package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class obj_homepage extends BasePage{
	
	
	@FindBy(how = How.CSS, using = ".gLFyf.gsfi")
	protected WebElement txtboxSearch;
	
	@FindBy(how = How.CSS, using = ".gNO89b")
	protected WebElement btnSearchGoogle;
	
	@FindBy(how = How.CSS, using = ".RNmpXc")
	protected WebElement btnGoodLuck;
	
	@FindBy(how = How.CSS, using = ".g")
	protected List<WebElement> resultCards;
	
	@FindBy(how = How.CSS, using = ".sbct")
	protected List<WebElement> listSugg;
	
	
}
