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
public class VerifyCityField extends BaseTest {
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

    @Story("Verify City cannot be empty")
    @Test
    public void NC8_City_cannot_be_empty(){
        newCustomerPage.enterToCityTextbox("");
        newCustomerPage.enterKeyboardToCityTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"City Field must be not blank");
    }

    @Story("Verify City cannot be numberic")
    @Test
    public void NC9_City_cannot_be_numberic(){
        newCustomerPage.enterToCityTextbox("city123");
        Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"Numbers are not allowed");
    }

    @Story("Verify City cannot have special charater")
    @Test
    public void NC10_City_cannot_have_special_charater(){
        newCustomerPage.enterToCityTextbox("City!@#");
        Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"Special characters are not allowed");
    }

    @Story("Verify City cannot have first blank space")
    @Test
    public void NC11_City_cannot_have_first_blank_space(){
        newCustomerPage.enterToCityTextbox(" ");
        newCustomerPage.enterKeyboardToCityTextbox(Keys.BACK_SPACE);
        Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"City Field must be not blank");
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
    DeleteCustomerPO deleteCustomerPage;
}
