package TestModules.ShoppingCart;

import TestModules.Base.BaseTest;
import Pages.HomePage;
import Pages.ShoppingCartPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ShoppingCartModuleTest extends BaseTest {

    @Test
    public void addProductToCart(){
        HomePage home = homePage;
        String pName = home.getTheProductName18();
        String pPrice = home.getItemPrice();
        home.scrollToProduct();
        home.addToShoppingCart();
        assertTrue(home.isAddedToShoppingCartSuccessfully());
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.gotoShoppingCartFromNotoficationBar();
        assertEquals(pName,cartPage.getFirstProductName(),"Wrong product added to the cart");
    }
    @Test(dependsOnMethods = "addProductToCart")
    public void removeFromCart(){
        ShoppingCartPage cartPage = new ShoppingCartPage(driver);
        cartPage.removeProduct();
        assertTrue(cartPage.isEmptyShoppingCart(),"Failed to remove product from shopping cart");

    }
}
