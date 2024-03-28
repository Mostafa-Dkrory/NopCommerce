package TestModules.Wishlist;

import Pages.HomePage;
import Pages.WishlistPage;
import TestModules.Base.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WishlistModuleTest extends BaseTest {
    @Test
    public void addToWishlist() {

        HomePage home = homePage;
        String pName = home.getTheProductName18();
        home.scrollToProduct();
        home.addToWishList();
        assertTrue(home.isAddedToWishlistSuccessfully());
        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.gotoWishlistFromNotoficationBar();
        assertEquals(pName, wishlistPage.getFirstProductName(), "Wrong product added to the wishlist");
    }
    @Test(dependsOnMethods = "addToWishlist")
    public void removeFromWishlist() {
        WishlistPage wishlistPage = new WishlistPage(driver);
        wishlistPage.removeProduct();
        assertTrue(wishlistPage.isWishListEmpty(), "Failed to remove product from wishlist");

    }
}
