package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header extends BaseClass {
    WebDriver driver;
    private final By registerBtn = By.className("ico-register");
    private final By loginBtn = By.className("ico-login");
    private final By logoutBtn = By.className("ico-logout");
    private final By wishlistBtn = By.className("ico-wishlist");
    private final By shoppingCartBtn = By.className("ico-cart");
    private final By myAccountBtn = By.className("ico-account");

    public Header(WebDriver driver){
        super(driver);
    }
    public void goToRegisterPage(){
        clickOn(registerBtn);
    }
    public void goToLoginPage(){
        clickOn(loginBtn);
    }
    public void logout(){
        clickOn(logoutBtn);
    }
    public Boolean getRegisterText(){
        return waitToPresent(registerBtn).isDisplayed();
    }
    public void goToWishlistPage(){
        clickOn(wishlistBtn);
    }
    public void goToShoppingCartPage(){
        clickOn(shoppingCartBtn);
    }
}