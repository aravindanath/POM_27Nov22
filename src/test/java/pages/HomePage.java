package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

// Object repositories

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccount;

    @FindBy(linkText = "Register")
    WebElement registerButton;



    // Business Logic


    public void navigateToRegister() {
        myAccount.click();
        registerButton.click();
    }


}
