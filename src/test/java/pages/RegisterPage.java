package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-firstname")
    WebElement firstnameTextField;

    @FindBy(id = "input-lastname")
    WebElement lastnameTextField;

    @FindBy(id = "input-email")
    WebElement emailtextfield;

    @FindBy(id = "input-telephone")
    WebElement telephoneTextField;

    @FindBy(id = "input-password")
    WebElement passwordTextField;

    @FindBy(id = "input-confirm")
    WebElement confirmPasswordTextField;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement privacyPolicyCheckBox;

    @FindBy(xpath ="//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
    WebElement successMsgField;





    public void registerNewUser(String firstname, String lastname, String email, String telephone,String password, String confirmPassword){
        firstnameTextField.sendKeys(firstname);
        lastnameTextField.sendKeys(lastname);
        emailtextfield.sendKeys(email);
        telephoneTextField.sendKeys(telephone);
        passwordTextField.sendKeys(password);
        confirmPasswordTextField.sendKeys(confirmPassword);
        System.out.println("password: " + password);
        privacyPolicyCheckBox.click();
        continueButton.click();
        Assert.assertEquals(successMsgField.getText().trim(),"Your Account Has Been Created!", "Account is not created!");
    }







}
