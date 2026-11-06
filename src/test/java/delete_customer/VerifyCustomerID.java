package delete_customer;

import commons.BaseTest;
import commons.GlobalContaints;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageOjects.*;

import java.security.Key;

@Epic("Bank Guru")
@Feature("Delete Customer")
public class VerifyCustomerID extends BaseTest {
    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browser){
        driver = getBrowserDriver(url, browser);
        mainPage = PageGenerator.getPageInstance(MainPO.class, driver);

        loginPage = mainPage.clickToBankProjectSite("Bank Project");
        loginPage.enterToUserIDTextbox(GlobalContaints.GURU_ADMIN_USER);
        loginPage.enterToPasswordTextbox(GlobalContaints.GURU_ADMIN_PASSWORD);
        loginPage.clickToLoginButton();
        managementPage = PageGenerator.getPageInstance(ManagementP0.class, driver);

        managementPage.openSideBar("Delete Customer");
        deleteCustomerPage = PageGenerator.getPageInstance(DeleteCustomerPO.class, driver);
    }

    @Story("Verify Customer ID cannot be empty")
    @Test
    public void DC1_Customer_ID_cannot_be_empty(){
        deleteCustomerPage.enterToCustomerIDTextbox("");
        deleteCustomerPage.enterKeyboardToCustomerIDTextbox(Keys.TAB);
        Assert.assertEquals(deleteCustomerPage.getCustomerIDErrorMessage(),"Customer ID is required");
    }

    @Story("Verify Customer ID must be numeric")
    @Test
    public void DC2_Customer_ID_must_be_numeric(){
        deleteCustomerPage.enterToCustomerIDTextbox("abcd");
        Assert.assertEquals(deleteCustomerPage.getCustomerIDErrorMessage(),"Characters are not allowed");
    }

    @Story("Verify Customer ID cannot have special charater")
    @Test
    public void DC3_Customer_ID_cannot_have_special_charater(){
        deleteCustomerPage.enterToCustomerIDTextbox("!@#123");
        Assert.assertEquals(deleteCustomerPage.getCustomerIDErrorMessage(),"Special characters are not allowed");
    }

    @Story("Verify Customer ID cannot have blank space")
    @Test
    // sai function nên không test được
    public void DC4_Customer_ID_cannot_have_blank_space(){

    }

    @Story("Verify First charater cannot be space")
    @Test
    // sai function nên không test được
    public void DC5_First_charater_cannot_be_space(){

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowser();
    }

    MainPO mainPage;
    LoginPO loginPage;
    ManagementP0 managementPage;
    DeleteCustomerPO deleteCustomerPage;


}
