package pageOjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class PageGenerator {
    public static <T extends BasePage> T getPageInstance(Class<T> pageClass, WebDriver driver) {
        try {
            // Lấy contructor nhận Webdriver
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
            // Tạo instance mới của page class
            return constructor.newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Can not init page class" + pageClass.getSimpleName(), e);
        }
    }

    public static MainPO getMainPage(WebDriver driver){return new MainPO(driver);}

    public static LoginPO getLoginPage(WebDriver driver){ return new LoginPO(driver);}

    public static ManagementP0 getManagementPage(WebDriver driver) {return new ManagementP0(driver);}

    public static NewCustomerPO getNewCustomerPage(WebDriver driver){return new NewCustomerPO(driver);}

    public static EditCustomerPO getEditCustomerPage(WebDriver driver){return new EditCustomerPO(driver);}

    public static DeteleCustomerPO getDeleteCustomerPage(WebDriver driver){return new DeteleCustomerPO(driver);}

}
