package pageOjects;

import commons.BasePage;
import interfaces.BasePageUI;
import org.openqa.selenium.WebDriver;

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

    public DeleteCustomerPO openDeleteCustomerPage(String pageName){
        waitForElementClickable(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME, pageName);
        clickToElement(driver, BasePageUI.DYNAMIC_SIDEBAR_LINK_BY_NAME,pageName);
        return PageGenerator.getPageInstance(DeleteCustomerPO.class, driver);
    }
}
