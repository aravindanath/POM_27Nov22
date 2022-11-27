package testscripts;

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


        HomePage hm = new HomePage(driver);
        hm.navigateToRegister();

        RegisterPage rp = new RegisterPage(driver);
        rp.registerNewUser(fn,ln,email,mobile,password,password);

    }
}
