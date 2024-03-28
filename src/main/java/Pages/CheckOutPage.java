package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage extends BaseClass {
    final private By countryField = By.id("BillingNewAddress_CountryId");
    final private By cityField = By.xpath("BillingNewAddress_City");
    final private By addressField = By.xpath("BillingNewAddress_Address1");
    final private By zipPostalCodeField = By.xpath("BillingNewAddress_ZipPostalCode");
    final private By phoneNumberField = By.xpath("BillingNewAddress_PhoneNumber");
    final private By billingContinueBtn = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
    final private By shippingMethodContinueBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    final private By paymentMethodContinueBtn = By.className("payment-method-next-step-button");
    final private By paymentInfoContinueBtn = By.className("payment-info-next-step-button");
    final private By confirmOrderContinueBtn = By.className("confirm-order-next-step-button");
    final private By successfulOrderMSG = By.xpath("//*[@class=\"section order-completed\"]/div[1]");

    protected CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public void selectCountry(String country){
        selectByText(countryField,country);
    }

    public void enterCity(String city){
        sendKeys(cityField,city);
    }
    public void enterAddress(String address){
        sendKeys(addressField,address);
    }public void enterZipCode(String zipCode){
        sendKeys(zipPostalCodeField,zipCode);
    }public void enterPhoneNumber(String phoneNumber){
        sendKeys(phoneNumberField,phoneNumber);
    }

    public void billingContinueBtn(){
        waitToPresent(billingContinueBtn).click();;
    }
    public void shippingContinueBtn(){
        waitToPresent(shippingMethodContinueBtn).click();;
    }
public void paymentMethodContinueBtn(){
        waitToPresent(paymentMethodContinueBtn).click();;
    }public void paymentInfoContinueBtn(){
        waitToPresent(paymentInfoContinueBtn).click();;
    }
    public void confirmOrderContinueBtn(){
        waitToPresent(confirmOrderContinueBtn).click();;
    }




}
