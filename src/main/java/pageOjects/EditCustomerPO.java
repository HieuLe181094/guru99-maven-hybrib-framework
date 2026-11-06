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

    public void enterKeyboardToCustomerIDTextbox(Keys keys) {
        enterKeyboardToTextboxByName("cusid", keys);
    }

    public String getCustomerIDErrorMessage() {
        return getErrorMessageByField("Customer ID", "message14");
    }
}
