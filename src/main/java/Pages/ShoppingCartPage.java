package Pages;
import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BaseClass {
    protected HomePage homePage;
    private final By productName = By.className("product-name");
    private final By removeProductBtn = By.className("remove-btn");
    private final By quantityField = By.className("qty-input");
    private final By price = By.className("product-unit-price");
    private final By totalPrice = By.className("product-subtotal");
    private final By emptyShoppingCartMessage = By.className("no-data");
    private final By updateCartBtn = By.id("updatecart");
    private final By termsOfServiceCkBx = By.id("termsofservice");
    private final By checkOutBtn = By.id("checkout");

    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }
    public String getFirstProductName(){
        return getText(productName);
    }
    public void removeProduct(){
        clickOn(removeProductBtn);
    }
    public boolean isEmptyShoppingCart(){
        return waitToPresent(emptyShoppingCartMessage).isDisplayed();
    }
    public void updateCart(){
        clickOn(updateCartBtn);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.scrollToProduct();
    }
    public void gotoShoppingCartFromNotoficationBar(){
        clickOn(By.xpath("//*[@id='bar-notification']/div/p/a"));
    }
    public String getPrice(){
        return getText(price);
    }
    public String getTotalPrice(){
        return getText(totalPrice);
    }
    public String getQuantity(){
        return getAttribute(quantityField,"value");
    }
    public void setQuantity(String quantity){
        sendKeys(quantityField,quantity);
    }public void scrollToCartFooter(){
        scrollTo(By.className("cart-footer"));
    }public void agreeTerms(){
        clickOn(By.id("termsofservice"));
    }

    public void agreeWithTOS(){
        clickOn(termsOfServiceCkBx);
    }
    public void proccedToCheckOut(){
        clickOn(checkOutBtn);
    }
}