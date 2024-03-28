package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseClass {
    WebDriver driver;
    final private By emailField = By.id("Email");
    final private By passwordField = By.id("Password");
    final private By loginBtn = By.className("login-button");
    final private By emailErrorMessage = By.id("Email-error");
    final private By errorMessage = By.xpath("//form/div[1]");
    final private By unSuccessfulLoginMessage = By.className("message-error");
    final private By myAccount = By.className("ico-account");
    final private By logoutBtn = By.className("ico-logout");
    final private By welcomeMSG = By.className("page-title");
    final private By homeLoginBtn = By.className("ico-login");

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }
    public void enterEmail(String email){
        sendKeys(emailField,email);
    }
    public void enterPassword(String password){
        sendKeys(passwordField,password);
    }
    public void login(){
        clickOn(loginBtn);
    }
    public void logout(){
        clickOn(logoutBtn);
    }
    public void clickOnHomeLoginBtn(){
        clickOn(homeLoginBtn);
    }
    public Boolean isEmailErrorMSGDisplayed(){
        return isDisplayed(emailErrorMessage);
    }
    public String getActualErrorMessage(){
        return getText(errorMessage);
    }
    public Boolean myAccountAppear(){
        return waitToPresent(myAccount).isDisplayed();
    }
    public Boolean isLoginBtnDisplayed(){
        //return waitToPresent(unSuccessfulLoginMessage).isDisplayed();
        return isDisplayed(homeLoginBtn);
    }
    public Boolean unSuccessfulLogin(){
        //return waitToPresent(unSuccessfulLoginMessage).isDisplayed();
        return isDisplayed(unSuccessfulLoginMessage);
    }

    public String getWelcomeMSG() {
        return getText(welcomeMSG);
    }
}

