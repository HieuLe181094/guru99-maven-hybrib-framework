package edit_customer;

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
@Feature("Edit Customer")
public class VerifyCustomerID extends BaseTest {
    @Parameters({"url", "browser"})
    @BeforeClass
    public void beforeClass(String url, String browser){
        driver = getBrowserDriver(url,browser);
        mainPage = PageGenerator.getPageInstance(MainPO.class, driver);

        loginPage = mainPage.clickToBankProjectSite("Bank Project");
        loginPage.enterToUserIDTextbox(GlobalContaints.GURU_ADMIN_USER);
        loginPage.enterToPasswordTextbox(GlobalContaints.GURU_ADMIN_PASSWORD);
        loginPage.clickToLoginButton();
        managementPage = PageGenerator.getPageInstance(ManagementP0.class, driver);

        managementPage.openSideBar("Edit Customer");
        editCustomerPage = PageGenerator.getPageInstance(EditCustomerPO.class,driver);
    }

    @Story("Verify Customer ID cannot be empty")
    @Test
    public void EC1_Customer_ID_cannot_be_empty(){
        editCustomerPage.enterToCustomerIDTextbox("");
        editCustomerPage.enterKeyboardToCustomerIDTextbox(Keys.TAB);
        Assert.assertEquals(editCustomerPage.getCustomerIDErrorMessage(),"Customer ID is required");

    }

    @AfterClass(alwaysRun = true)
    public void afterClass(){
        closeBrowser();
    }

    MainPO mainPage;
    LoginPO loginPage;
    ManagementP0 managementPage;
    NewCustomerPO newCustomerPage;
    EditCustomerPO editCustomerPage;
}
