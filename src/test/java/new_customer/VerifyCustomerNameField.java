package new_customer;

import commons.BaseTest;
import commons.GlobalContaints;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageOjects.*;

public class VerifyNameField extends BaseTest {
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

        managementPage.openSideBar("New Customer");
        newCustomerPage = PageGenerator.getPageInstance(NewCustomerPO.class, driver);
    }

    @Test
    public void NC1_Name_cannot_be_empty(){
        newCustomerPage.enterToCustomerNameTextbox("");
        newCustomerPage.enterKeyboardToCustomerNameTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getErrorMessage(),"Customer name must not be blank");
    }

    @Test
    public void NC2_Name_cannot_be_numberic(){
        newCustomerPage.enterToCustomerNameTextbox("1234");
        Assert.assertEquals(newCustomerPage.getErrorMessage(), "Numbers are not allowed");
    }

    @Test
    public void NC3_Name_cannot_have_special_characters(){
        newCustomerPage.enterToCustomerNameTextbox("name!@#");
        Assert.assertEquals(newCustomerPage.getErrorMessage(),"Special characters are not allowed");
    }

    @Test
    public void NC4_Name_cannot_have_first_charater_as_blank_space(){
        newCustomerPage.enterToCustomerNameTextbox("");
        newCustomerPage.enterKeyboardToCustomerNameTextbox(Keys.BACK_SPACE);
        Assert.assertEquals(newCustomerPage.getErrorMessage(),"Customer name must not be blank");
    }
    
    @AfterClass(alwaysRun =true)
    public void afterClass(){
        closeBrowser();
    }

    MainPO mainPage;
    LoginPO loginPage;
    ManagementP0 managementPage;
    NewCustomerPO newCustomerPage;
    EditCustomerPO editCustomerPage;
    DeteleCustomerPO deleteCustomerPage;
}
