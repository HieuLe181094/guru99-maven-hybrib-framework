package pageOjects;

import commons.BasePage;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;

public class LoginPO extends BasePage {


    public LoginPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void enterToUserIDTextbox(String userID){
        waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.USER_ID_TEXTBOX, userID);
    }

    public void enterToPasswordTextbox(String password){
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public void clickToLoginButton() {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
