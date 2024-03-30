package Pages;


import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseClass {
    public WebDriver driver;
    final private By searchInputField = By.id("small-searchterms");
    final private By searchBtn = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    final private By currencySelect = By.id("customerCurrency");
    final private By itemPrice = By.xpath("//div[3]/div[1]/span");
    final private By productTitle = By.className("product-title");
    final private By categoryTitle = By.xpath("//div[@class='page-title']/h1");
    final private By productItem = By.xpath("//div[@data-productid='18']/div[1]/a");
    final private By productItemName43 = By.xpath("//div[@data-productid='43']/div[2]/h2/a");
    final private By productItemName18 = By.xpath("//div[@data-productid='18']/div[2]/h2/a");
    final private By addToShoppingCartBtn = By.xpath("//div[@data-productid='18']/div[2]/div[3]/div[2]/button[1]");
    final private By addToWishListBtn = By.xpath("//div[@data-productid='18']/div[2]/div[3]/div[2]/button[3]");
    final private By addToCompareListBtn = By.xpath("//div[@data-productid='43']/div[2]/div[3]/div[2]/button[2]");
    final private By homeLoginBtn = By.className("ico-login");
    final private By facebookIcon = By.className("facebook");
    final private By twitterIcon = By.className("twitter");
    final private By rssIcon = By.xpath("//a[contains(text(), 'RSS')]");
    final private By youtubeIcon = By.className("youtube");
    public String dollarSign = "$";
    public String euroSign = "€";
    private final By registerBtn = By.className("ico-register");
    private final By noResultMSG = By.className("no-result");

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
    }

    public LoginPage clickLoginBtn(){
        waitToPresent(homeLoginBtn);
        waitToBeClickable(homeLoginBtn).click();
        //driver.findElement(homeLoginBtn).click();
        return new LoginPage(driver);

    }public RegisterPage clickRegisterBtn(){
        driver.findElement(registerBtn).click();
        return new RegisterPage(driver);
    }

    public void chooseCategory(String category){
        clickOn(By.linkText(category));
    }
    /*public String getPageCategory(){
        return getText(By.className("page-title"));
    }*/
    private By getMainCategoryXpath(int mainCategoryNum){
        return By.xpath("//div[@class='header-menu']/ul/li["+mainCategoryNum+"]/a");
    }
    private By getSubCategoryXpath(int mainCategoryNum,int subCategoryNum){
        return By.xpath("//div[@class='header-menu']/ul/li["+mainCategoryNum+"]/ul/li["+subCategoryNum+"]/a");
    }
    public void enterProductNameToSearch(String productName){
        sendKeys(searchInputField,productName);
    }
    public void search(){
        clickOn(searchBtn);
    }
    public Boolean isNoResultMSG(){
        return isDisplayed(noResultMSG);
    }

    public List<String> getTheTitlesOfSearchResults(){
        List<String> titles = new ArrayList<String>();
        getWebElements(productTitle).forEach((webElement) -> {
            titles.add(webElement.getText());
        });
        return titles;
    }
    public void changeCurrency(String currency){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        selectByText(currencySelect,currency);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String getItemPrice(){
        driver.navigate().refresh();
        scrollTo(itemPrice);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return getText(itemPrice);
    }
    public String chooseMainCategory(int mainCategoryNum){
        clickOn(getMainCategoryXpath(mainCategoryNum));
        return getText(getMainCategoryXpath(mainCategoryNum));
    }
    public String chooseSubCategory(int mainCategoryNum,int subCategoryNum){
        hoverOn(getMainCategoryXpath(mainCategoryNum));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String categoryName = getText(getSubCategoryXpath(mainCategoryNum,subCategoryNum));
        clickOn(getSubCategoryXpath(mainCategoryNum,subCategoryNum));
        return categoryName;
    }
    public String getCategoryTitle(){
        return getText(categoryTitle);
    }

    /*
    * PRODUCT SECTION
    */
    public void goToProductPage(){
        clickOn(productItem);
    }
    public String getTheProductName43(){
        return getText(productItemName43);
    }
    public String getTheProductName18(){
        return getText(productItemName18);
    }
    public void scrollToProduct(){
        scrollTo(By.xpath("//div[@class='title']"));
    }
    public void addToShoppingCart(){
        clickOn(addToShoppingCartBtn);
    }
    public void addToWishList(){
        clickOn(addToWishListBtn);
    }
    public void addToCompareList(){
        clickOn(addToCompareListBtn);
    }
    public boolean isAddedToShoppingCartSuccessfully(){
        return waitToPresent(By.className("bar-notification")).isDisplayed();
    }
    public boolean isAddedToWishlistSuccessfully(){
        return waitToPresent(By.className("bar-notification")).isDisplayed();
    }


    /*
    * SOCIAL MEDIA
    */
    public void clickOnFacebook(){
        clickOn(facebookIcon);
    }
    public void clickOnYoutube(){
        clickOn(youtubeIcon);
    }
    public void clickOnTwitter(){
        clickOn(twitterIcon);
    }
    public void clickOnRSS(){
        clickOn(rssIcon);
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

}
