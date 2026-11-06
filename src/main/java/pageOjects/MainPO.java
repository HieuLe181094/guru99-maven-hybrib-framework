package pageOjects;

import commons.BasePage;
import interfaces.BasePageUI;
import interfaces.LoginPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPO extends BasePage {


    public MainPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public LoginPO clickToBankProjectSite(String siteName) {
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SITE_BY_NAME, siteName);
        clickToElement(driver, BasePageUI.DYNAMIC_SITE_BY_NAME, siteName);
        waitForUrlContains(driver, "/V1/index.php");
//        waitForElementVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
        return PageGenerator.getPageInstance(LoginPO.class, driver);
    }
}
