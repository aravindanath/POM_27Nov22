package testscripts;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.RegisterPage;

public class TC_RF_001 extends BaseTest{

    /**
     * @Author Arvind
     * Description: Validate Registering an Account by providing only the Mandatory fields
     */

    @Test
    public void TC_RF_001(){

        String fn = BasePage.firstname(),ln = BasePage.lastName(), mobile = BasePage.phonenumeber(),email = BasePage.emailid(),password = BasePage.password();

        ExtentTest test = reports.createTest("TC_RF_001");
        HomePage hm = new HomePage(driver);
        test.info(driver.getTitle());
        test.info("user is navigating to register page");
        hm.navigateToRegister();
        test.info("user is navigated to register page");
        RegisterPage rp = new RegisterPage(driver);
        test.info("user is filling data to register new user");
        rp.registerNewUser(fn,ln,email,mobile,password,password);
        test.info("user is sucessfully  registered new user");

    }
}
