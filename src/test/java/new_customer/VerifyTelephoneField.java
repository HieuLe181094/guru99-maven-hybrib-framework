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
public class VerifyTelephoneField extends BaseTest {
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

    @Story("Verify Telephone cannot be empty")
    @Test
    public void NC22_Telephone_cannot_be_empty(){
        newCustomerPage.enterToTelephoneTextbox("");
        newCustomerPage.enterKeyboardToTelephoneTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getTelephoneErrorMessage(),"Telephone no must not be blank");
    }

    @Story("Verify Telephone cannot have first character as blank space")
    @Test
    public void NC23_Telephone_cannot_have_first_character_as_blank_space(){
        newCustomerPage.enterToTelephoneTextbox(" ");
        Assert.assertEquals(newCustomerPage.getTelephoneErrorMessage(),"Characters are not allowed");
    }

    @Story("Verify Telephone cannot have spaces")
    @Test
    public void NC24_Telephone_cannot_have_spaces(){
        newCustomerPage.enterToTelephoneTextbox("123 123");
        Assert.assertEquals(newCustomerPage.getTelephoneErrorMessage(),"Characters are not allowed");
    }

    @Story("Verify Telephone cannot have special character")
    @Test
    public void NC25_Telephone_cannot_have_special_charater(){
        newCustomerPage.enterToTelephoneTextbox("123!@#");
        Assert.assertEquals(newCustomerPage.getTelephoneErrorMessage(),"Special characters are not allowed");
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
