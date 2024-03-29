package E2E;

import Pages.*;
import TestModules.Base.BaseTest;
import data.UserModel;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class E2EModuleTest extends BaseTest {

    @Test
    void End2EndTest(){
        /* Registration */
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
        /* Login */
        LoginPage loginPage = homePage.clickLoginBtn();
        loginPage.clickOnHomeLoginBtn();
        assertEquals(loginPage.getWelcomeMSG(),"Welcome, Please Sign In!","Login Page is not loaded!");
        loginPage.enterEmail(BaseTest.user.getEmail());
        loginPage.enterPassword(BaseTest.user.getPassword());
        loginPage.login();
        assertTrue(loginPage.myAccountAppear(),"Failed to Login WithValidCredentials");
        /* Add To Shopping Cart */
        HomePage home = homePage;
        String pName = home.getTheProductName18();
        home.scrollToProduct();
        home.addToShoppingCart();
        assertTrue(home.isAddedToShoppingCartSuccessfully());
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.gotoShoppingCartFromNotoficationBar();
        assertEquals(pName,cartPage.getFirstProductName(),"Wrong product added to the cart");
        cartPage.agreeTerms();
        cartPage.proccedToCheckOut();

        /* CheckOut */
        CheckOutPage checkOutPage = new CheckOutPage(driver);
        checkOutPage.selectCountry("Egypt"); // 123 Stands for Egypt
        //checkOutPage.selectState(1);
        checkOutPage.enterCity(user.getCity());
        checkOutPage.enterAddress(user.getAddress());
        checkOutPage.enterZipCode(user.getZipCode());
        checkOutPage.enterPhoneNumber(user.getPhoneNumber());
        checkOutPage.billingContinueBtn();
        checkOutPage.shippingContinueBtn();
        checkOutPage.paymentMethodContinueBtn();
        checkOutPage.paymentInfoContinueBtn();
        checkOutPage.confirmOrderContinueBtn();
        assertTrue(checkOutPage.isSuccessfullyOrdered(),"Failed to Check Out!");
        timer(5000);








    }
}
