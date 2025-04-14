package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CombasePage {
    public WebDriver driver;
	
	public CombasePage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements( driver,this);
	 }
}
