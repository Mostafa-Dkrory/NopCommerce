package TestModules.Home;

import TestModules.Base.BaseTest;
import Pages.HomePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

public class HomeModuleTest extends BaseTest {

    @BeforeMethod
    void gotoHome(){
        goHome();
    }
    @Test
    public void changeCurrencyToEuro() {
        HomePage home = homePage;
        home.changeCurrency("Euro");
        assertTrue(home.getItemPrice().contains(home.euroSign),"Failed to change currency to Euro");

    }

    @Test
    public void changeCurrencyToDollar() {
        HomePage home = homePage;
        home.changeCurrency("US Dollar");
        assertTrue(home.getItemPrice().contains(home.dollarSign),"Failed to change currency to Dollar");

    }
    @Test
    void TestFacebookLink(){
        HomePage home = homePage;
        home.clickOnFacebook();
        home.switchToNext();
        assertTrue(home.getCurrentUrl().contains("nopCommerce"),"FaceBook icon is not working");
        home.closeTab();
    }
    @Test
    void TestTwitterLink(){
        HomePage home = homePage;
        home.clickOnTwitter();
        home.switchToNext();
        assertEquals(home.getCurrentUrl(),"https://twitter.com/nopCommerce","Twitter icon is not working");
        home.closeTab();
    }
    @Test
    void TestYoutubeLink(){
        HomePage home = homePage;
        home.clickOnYoutube();
        home.switchToNext();
        assertEquals(home.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce","Youtube icon is not working");
        home.closeTab();
    }
    @Test
    void TestRSSLink(){
        HomePage home = homePage;
        home.clickOnRSS();
        //home.switchToNext();
        assertEquals(home.getCurrentUrl(),"https://demo.nopcommerce.com/news/rss/1","Twitter icon is not working");
        home.closeTab();
    }


}
