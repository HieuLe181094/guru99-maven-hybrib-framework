package pageOjects;

import commons.BasePage;
import interfaces.BasePageUI;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class ManagementP0 extends BasePage {


    public ManagementP0(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void openSideBar(String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        clickToElementByJS(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
    }



    // Open page at the Management Page side
    public NewCustomerPO openNewCustomerPage(String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        return PageGenerator.getPageInstance(NewCustomerPO.class, driver);
    }

    public EditCustomerPO openEditCustomerPage(String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        return PageGenerator.getPageInstance(EditCustomerPO.class, driver);
    }

    public DeteleCustomerPO openDeleteCustomerPage(String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME,pageName);
        return PageGenerator.getPageInstance(DeteleCustomerPO.class, driver);
    }
}
