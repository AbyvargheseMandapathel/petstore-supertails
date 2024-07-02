package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PropertyPage {
WebDriver driver;

@FindBy(name = "firstname")
public WebElement firstname;

@FindBy(name = "lastname")
public WebElement lastname;

@FindBy(name = "email")
public WebElement email;

@FindBy(name = "phone")
public WebElement phoneno;

@FindBy(id = "locations")
public WebElement location;

@FindBy(name = "whatProperty")
public WebElement whatproperty;

@FindBy(name = "numberOfRooms")
public WebElement noofrooms;

@FindBy(name = "hearAbout")
public WebElement hearabout;

@FindBy(xpath="//button[text()='Send a request']")
public WebElement sendreq;

// Method to select option from dropdown
public void selectproperty(String proptype) {
    Select select = new Select(whatproperty);
    select.selectByVisibleText(proptype);
}
public void selectroom(String roomno) {
    Select select = new Select(noofrooms);
    select.selectByVisibleText(roomno);
}
public void selecthearabout(String heardabout) {
    Select select = new Select(hearabout);
    select.selectByVisibleText(heardabout);
}

public void submitvilla(String fname,String lname,String emailid,String phonenum,String locn,String prop,String room,String heard)
{
	firstname.click();
	firstname.sendKeys(fname);
	lastname.click();
	lastname.sendKeys(lname);
	email.click();
	email.sendKeys(emailid);
	phoneno.click();
	phoneno.sendKeys(phonenum);
	location.click();
	location.sendKeys(locn);
	selectproperty(prop);
	selectroom(room);
	selecthearabout(heard);
	sendreq.click();
}



public PropertyPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
}
