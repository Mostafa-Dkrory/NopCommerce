
package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BaseClass {
    final private By maleRadioBtn = By.id("gender-male");
    final private By femaleRadioBtn = By.id("gender-female");
    final private By firstnameField = By.id("FirstName");
    final private By lastnameField = By.id("LastName");
    final private By daySelect = By.xpath("//div[4]/div/select[1]");
    final private By monthSelect = By.xpath("//div[4]/div/select[2]");
    final private By yearSelect = By.xpath("//div[4]/div/select[3]");
    final private By emailField = By.id("Email");
    final private By companyNameField = By.id("Company");
    final private By passwordField = By.id("Password");
    final private By confirmPasswordField = By.id("ConfirmPassword");
    final private By registerBtn = By.id("register-button");
    final private By successfulRegistrationMessage = By.xpath("//div[3]/div/div/div/div[2]/div[1]");
    final private By existEmailMessage = By.xpath("//form/div[1]/ul/li");
    final private By confirmPasswordErrorMessage = By.id("ConfirmPassword-error");

    public RegisterPage(WebDriver driver){
        super(driver);
    }
    public void selectGender(String gender){
        if(gender.equals("male"))
            clickOn(maleRadioBtn);
        else
            clickOn(femaleRadioBtn);
    }
    public void enterFirstname(String firstname){
        sendKeys(firstnameField,firstname);
    }
    public void enterLastname(String lastname){
        sendKeys(lastnameField,lastname);
    }
    public void selectDay(String day){
        selectByText(daySelect,day);
    }
    public void selectMonth(String month){
        selectByText(monthSelect,month);
    }
    public void selectYear(String year){
        selectByText(yearSelect,year);
    }
    public void enterEmail(String email){
        sendKeys(emailField,email);
    }
    public void enterCompanyName(String name){
        sendKeys(companyNameField,name);
    }
    public void enterPassword(String password){
        sendKeys(passwordField,password);
    }
    public void enterConfirmPassword(String password){
        sendKeys(confirmPasswordField,password);
    }
    public void register(){
        clickOn(registerBtn);
    }
    public String getActualSuccessfulRegistrationMessage(){
        return getText(successfulRegistrationMessage);
    }
    public String getActualExistEmailMessage(){
        return getText(existEmailMessage);
    }
    public String getActualConfirmPasswordMessage(){
        return getText(confirmPasswordErrorMessage);
    }


}
