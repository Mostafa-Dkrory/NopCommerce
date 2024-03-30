package TestModules.Login;

import Pages.LoginPage;
import TestModules.Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginModuleTest extends BaseTest {

    @Test(dependsOnMethods = "validRegistration")
    void LoginWithValidCredentials(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnHomeLoginBtn();
        assertEquals(loginPage.getWelcomeMSG(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.enterEmail(BaseTest.user.getEmail());
        loginPage.enterPassword(BaseTest.user.getPassword());
        loginPage.login();
        //assertFalse(loginPage.unSuccessfulLogin(),"Failed to Login WithValidCredentials");
        assertTrue(loginPage.myAccountAppear(),"Failed to Login WithValidCredentials");
        System.out.println("Email: " + BaseTest.user.getEmail());
        System.out.println("Password: " + BaseTest.user.getPassword());

    }
    @Test (dependsOnMethods = "LoginWithValidCredentials")
    public void Logout()  {
        LoginPage loginPage = new LoginPage(super.driver);
        assertTrue(loginPage.myAccountAppear(), "Failed to logout - You have to be loggedIn first ");
        loginPage.logout();
        assertTrue(loginPage.isLoginBtnDisplayed(), "Failed to Logout");
    }
    @Test()
    void LoginWithInValidCredentials(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnHomeLoginBtn();
        assertEquals(loginPage.getWelcomeMSG(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.enterEmail("email@email.com");
        loginPage.enterPassword("password");
        loginPage.login();
        assertTrue(loginPage.unSuccessfulLogin(),"Unsuccessfully login");

    }
    @Test()
    void LoginWithEmptyEmail(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnHomeLoginBtn();
        assertEquals(loginPage.getWelcomeMSG(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.enterPassword("password");
        loginPage.login();
        assertTrue(loginPage.isEmailErrorMSGDisplayed(),"Email error msg is not displayed as excepted");
    }
    @Test()
    void LoginWithEmptyPassword(){
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnHomeLoginBtn();
        assertEquals(loginPage.getWelcomeMSG(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.enterEmail("email@email.com");
        loginPage.login();
        assertTrue(loginPage.unSuccessfulLogin(),"Unsuccessfully login");
    }


}
