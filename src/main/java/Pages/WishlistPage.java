package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishlistPage extends BaseClass {
    private final By productName = By.className("product-name");
    private final By removeProductBtn = By.className("remove-btn");
    private final By emptyWishlistMessage = By.className("no-data");

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public String getFirstProductName(){
        return getText(productName);
    }
    public void removeProduct(){
        clickOn(removeProductBtn);
    }
    public boolean isWishListEmpty(){
        return waitToPresent(emptyWishlistMessage).isDisplayed();
    }
    public void gotoWishlistFromNotoficationBar(){
        clickOn(By.xpath("//*[@id='bar-notification']/div/p/a"));
    }
}