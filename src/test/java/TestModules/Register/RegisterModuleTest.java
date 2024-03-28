package TestModules.Register;

import TestModules.Base.BaseTest;
import Pages.RegisterPage;
import data.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterModuleTest extends BaseTest {
    
    
    @Test
    void validRegistration(){
        UserModel user = new UserModel();
        RegisterPage registerPage = homePage.clickRegisterBtn();
        registerPage.selectGender("male");
        registerPage.enterFirstname(user.getfName());
        registerPage.enterLastname(user.getlName());
        registerPage.enterEmail(user.getEmail());
        registerPage.enterPassword(user.getPassword());
        registerPage.enterConfirmPassword(user.getPassword());
        registerPage.enterCompanyName(user.getCompany());
        registerPage.selectDay("5");
        registerPage.selectMonth("May");
        registerPage.selectYear("2005");
        registerPage.register();
        Assert.assertEquals(registerPage.getActualSuccessfulRegistrationMessage(),"Your registration completed","failed to register with with valid data");
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        BaseTest.user = user;
    }
    
}
