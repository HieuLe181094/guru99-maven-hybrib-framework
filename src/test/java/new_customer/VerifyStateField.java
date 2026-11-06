package new_customer;

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

@Epic("Bank Guru")
@Feature("New Customer")
public class VerifyStateField extends BaseTest {
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

    @Story("Verify State cannot be empty")
    @Test
    public void NC12_State_cannot_be_empty(){
        newCustomerPage.enterToStateTextbox("");
        newCustomerPage.enterKeyboardToStateTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"State must not be blank");
    }

    @Story("Verify State cannot be numberic")
    @Test
    public void NC13_State_cannot_be_numberic(){
        newCustomerPage.enterToStateTextbox("1234");
        Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"Numbers are not allowed");
    }

    @Story("Verify State cannot have special charater")
    @Test
    public void NC14_State_cannot_have_special_charater(){
        newCustomerPage.enterToStateTextbox("State!@#");
        Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"Special characters are not allowed");
    }

    @Story("Verify State cannot have first blank space")
    @Test
    public void NC15_State_cannot_have_first_blank_space(){
        newCustomerPage.enterToStateTextbox(" ");
        newCustomerPage.enterKeyboardToStateTextbox(Keys.BACK_SPACE);
        Assert.assertEquals(newCustomerPage.getStateErrorMessage(),"State must not be blank");
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
