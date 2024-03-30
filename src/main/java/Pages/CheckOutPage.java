package Pages;

import Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Objects;

public class CheckOutPage extends BaseClass {
    final private By countryField = By.id("BillingNewAddress_CountryId");
    final private By stateField = By.id("BillingNewAddress_StateProvinceId");
    final private By cityField = By.id("BillingNewAddress_City");
    final private By addressField = By.id("BillingNewAddress_Address1");
    final private By zipPostalCodeField = By.id("BillingNewAddress_ZipPostalCode");
    final private By phoneNumberField = By.id("BillingNewAddress_PhoneNumber");
    final private By billingContinueBtn = By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]");
    final private By shippingMethodContinueBtn = By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button");
    final private By paymentMethodContinueBtn = By.className("payment-method-next-step-button");
    final private By paymentInfoContinueBtn = By.className("payment-info-next-step-button");
    final private By confirmOrderContinueBtn = By.className("confirm-order-next-step-button");
    final private By successfulOrderMSG = By.xpath("//*[@class=\"section order-completed\"]/div[1]");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    public void selectCountry(String country){

            try {
                // Sleep for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Handle any exceptions
                e.printStackTrace();
            }

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

        waitToBeClickable(confirmOrderContinueBtn).click();;

    }

    public boolean isSuccessfullyOrdered(){
        return Objects.equals(waitToPresent(successfulOrderMSG).getText(), "Your order has been successfully processed!");
    }


    public void selectState(int index) {
        selectByIndex(stateField,index);
    }
}
