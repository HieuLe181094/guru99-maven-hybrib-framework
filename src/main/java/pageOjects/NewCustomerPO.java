package pageOjects;

import interfaces.BasePageUI;
import interfaces.NewCustomerPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.security.Key;

public class NewCustomerPO extends ManagementP0{

    public NewCustomerPO(WebDriver driver) {
        super(driver);
    }

    @Step("Enter Customer Name: {value}")
    public void enterToCustomerNameTextbox(String value) {
        enterToTextboxByName("name", value);
    }

    @Step("Press keyboard for Customer Name")
    public void enterKeyboardToCustomerNameTextbox(Keys keys) {
        enterKeyboardToTextboxByName("name", keys);
    }

    @Step("Get Customer Name error message")
    public String getCustomerNameErrorMessage() {
        return getErrorMessageByField("Customer Name", "message");
    }

    @Step("Enter Address: {value}")
    public void enterToAddressTextarea(String address) {
        waitForElementVisivle(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
        sendKeysToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, address);
    }

    @Step("Press keyboard for Address")
    public void enterKeyboardToAddressTextares(Keys keyboardToAddress) {
        waitForElementVisivle(driver, NewCustomerPageUI.ADDRESS_TEXTAREA);
        sendKeyBoardToElement(driver, NewCustomerPageUI.ADDRESS_TEXTAREA, keyboardToAddress);
    }

    @Step("Get City error message")
    public String getCityErrorMessage() {
        return  getErrorMessageByField("City", "message4");
    }

    @Step("Enter City: {value}")
    public void enterToCityTextbox(String value) {
        enterToTextboxByName("city", value);
    }

    @Step("Press keyboard for City")
    public void enterKeyboardToCityTextbox(Keys keys) {
      enterKeyboardToTextboxByName("city", keys);
    }

    @Step("Enter State: {value}")
    public void enterToStateTextbox(String value) {
        enterToTextboxByName("state", value);
    }

    @Step("Press keyboard for State")
    public void enterKeyboardToStateTextbox(Keys keys) {
        enterKeyboardToTextboxByName("state", keys);
    }

    @Step("Get State error message")
    public String getStateErrorMessage() {
        return getErrorMessageByField("State", "message5");
    }

    @Step("Enter PIN: {value}")
    public void enterToPinTextbox(String value) {
        enterToTextboxByName("pinno", value);
    }

    @Step("Get PIN error message")
    public String getPinErrorMessage() {
        return getErrorMessageByField("PIN", "message6");
    }

    @Step("Press keyboard for PIN")
    public void enterKeyboardToPinTextbox(Keys keys) {
        enterKeyboardToTextboxByName("pinno", keys);
    }

    @Step("Enter Telephone: {value}")
    public void enterToTelephoneTextbox(String value) {
        enterToTextboxByName("telephoneno",value);
    }

    @Step("Press keyboard for Telephone")
    public void enterKeyboardToTelephoneTextbox(Keys keys) {
        enterKeyboardToTextboxByName("telephoneno", keys);
    }

    @Step("Get Telephone error message")
    public String getTelephoneErrorMessage() {
        return  getErrorMessageByField("Telephone Number", "message7");
    }

    @Step("Enter Email: {value}")
    public void enterToEmailTextbox(String value) {
        enterToTextboxByName("emailid", value);
    }

    @Step("Press keyboard for City")
    public void enterKeyboardToEmailTextbox(Keys keys) {
        enterKeyboardToTextboxByName("emailid", keys);
    }

    @Step("Get Email error message")
    public String getEmailErrorMessage() {
        return getErrorMessageByField("E-mail", "message9");
    }

    @Step("Verify field label is displayed: {labelName}")
    public boolean isFieldLabelDisplayed(String labelName) {
        return isElementDisplayed(driver, BasePageUI.FIELD_LABEL_BY_TEXT, labelName);
    }
}
