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
public class VerifyAddressField extends BaseTest {
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

    @Story("Verify Address cannot be empty")
    @Test
    public void NC5_Adress_cannot_be_empty(){
        newCustomerPage.enterToAddressTextarea("");
        newCustomerPage.enterKeyboardToAddressTextares(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getCityErrorMessage(),"City Field must be not blank");
    }

//    @Test
//    public void NC6_Address_cannot_have_first_blank_name(){
//        newCustomerPage.enterToCustomerNameTextbox("");
//        Assert.assertEquals(newCustomerPage.getCustomerNameErrorMessage(), "Numbers are not allowed");
//    }


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
