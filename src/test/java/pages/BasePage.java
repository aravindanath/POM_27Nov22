package pages;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BasePage
{
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    public static String getValues(String key){
        String path = System.getProperty("user.dir")+ File.separator+"config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties properties = new Properties();
            properties.load(fis);
            value = properties.getProperty(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public  static void mousehover(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }



    public  static void click(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.click(element).build().perform();
    }


    public  static void dragANDDrop(WebDriver driver, WebElement element1, WebElement element2){
        Actions action = new Actions(driver);
        action.dragAndDrop(element1, element2).build().perform();
    }


    public static void acceptAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();

    }


    public static void dismissAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

    }


    public static void acceptAlert(WebDriver driver,String text){
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(text);
        alert.accept();

    }


    public  static void rightClick(WebDriver driver, WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).build().perform();
    }


    public  static void selectByValue(WebElement element,String value){
        Select sel  = new Select(element);
        sel.selectByValue(value);
    }


    public  static void selectByIndex(WebElement element,int index){
        Select sel  = new Select(element);
        sel.selectByIndex(index);
    }


    public  static void selectByvisibleText(WebElement element,String value){
        Select sel  = new Select(element);
        sel.selectByVisibleText(value);
    }

    public  static void screenShot(WebDriver driver){
        try {
//            TakesScreenshot srcShot = (TakesScreenshot) driver;
//            File src = srcShot.getScreenshotAs(OutputType.FILE);
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshot.png");
            FileUtils.copyFile(screenshotFile, dest);
        }catch (IOException e){

        }

    }


    public  static void scrollToElement(WebDriver driver,WebElement element){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
    }


    public static String firstname(){
        Faker faker = new Faker();
        String fn = faker.name().firstName();
        System.out.println("First name: " + fn);
        return fn;
    }

    public static String lastName(){
        Faker faker = new Faker();
        String ln = faker.name().lastName();
        System.out.println("Last name: " + ln);
        return ln;
    }

    public static String emailid(){
        Faker faker = new Faker();
        String ln = faker.name().firstName();
        System.out.println(ln+"@testmail.com");
        return ln+"@testmail.com";
    }

    public static String phonenumeber(){
        Faker faker = new Faker();
        System.out.println(faker.number().digits(10));
        return faker.number().digits(10);
    }

    public static String password(){
        return "pa$$0Rd@123";
    }
}
