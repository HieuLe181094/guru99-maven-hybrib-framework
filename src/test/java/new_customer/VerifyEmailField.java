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

import javax.naming.NamingEnumeration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Epic("Bank Guru")
@Feature("New Customer")
public class VerifyEmailField extends BaseTest {
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

    @Story("Verify Email cannot be empty")
    @Test
    public void NC26_Email_cannot_be_empty(){
        newCustomerPage.enterToEmailTextbox("");
        newCustomerPage.enterKeyboardToEmailTextbox(Keys.TAB);
        Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID must not be blank");
    }

    @Story("Verify Email must be in correct format")
    @Test
    public void NC26_Email_must_be_in_correct_format(){
        newCustomerPage.enterToEmailTextbox("guru99@gmail");
        Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");
    }

    @Story("Verify Email cannot have space")
    @Test
    public void NC28_Email_cannot_have_space(){
        newCustomerPage.enterToEmailTextbox(" ");
        Assert.assertEquals(newCustomerPage.getEmailErrorMessage(),"Email-ID is not valid");
    }

    @Story("Verify all field labels are displayed")
    @Test
    public void NC29_Verify_all_field_labels(){
        List<String> expectedLabels = Arrays.asList(
                "Customer Name", "Gender", "Date of Birth ", "Address", "City", "State", "PIN",
                "Telephone Number", "E-mail");
        for (String label : expectedLabels) {
            Assert.assertTrue(
                    newCustomerPage.isFieldLabelDisplayed(label),
                    "Field label is not displayed: " + label
            );
        }
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
