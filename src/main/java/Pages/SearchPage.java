package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends BaseClass {
    private final By noResultMSG = By.className("no-result");
    private final By searchTitle = By.className("page-title");
    final private By searchInputField = By.id("small-searchterms");
    final private By searchBtn = By.xpath("//*[@id=\"small-search-box-form\"]/button");
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void search(){
        clickOn(searchBtn);
    }
    public void enterProductNameToSearch(String productName){
        sendKeys(searchInputField,productName);
    }
    public Boolean isNoResultMSG(){
        return isDisplayed(noResultMSG);
    }
    public String getSearchTitle(){
        return getText(searchTitle);
    }
    public void chooseTag(String tag){

    }
}
