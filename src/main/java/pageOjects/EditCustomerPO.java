package pageOjects;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class EditCustomerPO extends ManagementP0 {


    public EditCustomerPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter Customer ID: {value}")
    public void enterToCustomerIDTextbox(String value) {
        enterToTextboxByName("cusid", value);
    }

    @Step("Press keyboard for Customer ID")
    public void enterKeyboardToCustomerIDTextbox(Keys keys) {
        enterKeyboardToTextboxByName("cusid", keys);
    }

    @Step("Get Customer ID error message")
    public String getCustomerIDErrorMessage() {
        return getErrorMessageByField("Customer ID", "message14");
    }

}
