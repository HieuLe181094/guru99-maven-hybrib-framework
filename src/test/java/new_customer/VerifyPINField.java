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
public class VerifyPINField extends BaseTest {
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

    @Story("Veriry PIN must be numberic")
    @Test
    public void NC16_PIN_must_be_numberic(){
        newCustomerPage.enterToPinTextbox("1234PIN");
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"Characters are not allowed");
    }

    @Story("Veriry PIN cannot be empty")
    @Test
    public void NC17_PIN_cannot_be_empty(){
        newCustomerPage.enterToPinTextbox("");
        newCustomerPage.enterKeyboardToPinTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"PIN Code must not be blank");
    }

    @Story("Veriry PIN must have 6 digits")
    @Test
    public void NC18_PIN_must_have_6_digits(){
        newCustomerPage.enterToPinTextbox("12");
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"PIN Code must have 6 Digits");
    }

    @Story("Veriry PIN cannot have special charater")
    @Test
    public void NC19_PIN_cannot_have_special_charater(){
        newCustomerPage.enterToPinTextbox("!@#");
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"Special characters are not allowed");
    }

    @Story("Veriry PIN cannot have first blank space")
    @Test
    public void NC20_PIN_cannot_have_first_blank_space(){
        newCustomerPage.enterToPinTextbox(" ");
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"Characters are not allowed");
    }

    // Trên hệ thống đang cho nhập PIN với space ở kí tự đầu tiên
    @Story("Veriry PIN cannot have blank space")
    @Test
    public void NC21_PIN_cannot_have_blank_space(){
        newCustomerPage.enterToPinTextbox(" ");
        Assert.assertEquals(newCustomerPage.getPinErrorMessage(),"Characters are not allowed");
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
