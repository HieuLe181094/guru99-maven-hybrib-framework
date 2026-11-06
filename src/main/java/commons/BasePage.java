package commons;

import interfaces.BasePageUI;
import interfaces.NewCustomerPageUI;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Matcher;


import static commons.GlobalContaints.LONG_TIMEOUT;

public class BasePage {
    protected WebDriver driver;

    // 1 hamd static có thể gọi trực tiếp từ class mà không cần thông qua đối tượng
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public By getByLocator(String locator) {
        if (locator ==  null || locator.isEmpty()) {
            throw new RuntimeException("Locator type cannot be empty");
        }
        switch (locator.split("=")[0].toLowerCase()) {
            case "id":
                return By.id(locator.substring(3));
            case "name":
                return By.name(locator.substring(5));
            case "class":
                return By.className(locator.substring(6));
            case "xpath":
                return By.xpath(locator.substring(6));
            case "css":
                return By.cssSelector(locator.substring(4));
            default:
                throw new RuntimeException("Locator type is not support.");
        }
    }

    public String castLocator(String locator, String... restParam) {
        for (String param : restParam) {
            locator = locator.replaceFirst("%s", Matcher.quoteReplacement(param));
        }
        return locator;
    }

    protected WebElement getWebElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElement(WebDriver driver, String locator, String... restParam) {
        return driver.findElements(getByLocator(castLocator(locator, restParam)));
    }

    public void clickToElement(WebDriver driver, String locator) {

        driver.findElement(getByLocator(locator)).click();
    }

    public  void clickToElement(WebDriver driver, String locator, String... restParam){
        WebElement element = driver.findElement(getByLocator(castLocator(locator, restParam)));
        System.out.println("Before click: " + element.getRect());
        System.out.println(((JavascriptExecutor) driver).executeScript("var r=arguments[0].getBoundingClientRect(); var e=document.elementFromPoint(r.left+r.width/2,r.top+r.height/2); return {target:arguments[0].outerHTML, blocker:e?e.outerHTML:null, x:r.left+r.width/2, y:r.top+r.height/2};", element));
        element.click();
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParam) {
        WebElement element = driver.findElement(getByLocator(castLocator(locator, restParam)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String valueToSend){
        driver.findElement(getByLocator(locator)).clear();
        driver.findElement(getByLocator(locator)).sendKeys(valueToSend);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String valueToSend, String... restParam){
        WebElement element = getWebElement(driver, castLocator(locator, restParam));
        element.clear();
        element.sendKeys(valueToSend);
    }

    public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public void sendKeysToElement(WebDriver driver, String locator, Keys key, String ...values){
        new Actions(driver).sendKeys(getWebElement(driver, castLocator(locator, values)), key).perform();
    }

    // dùng khi hàm clear không hoạt động đúng
    public void selectAllAndSenKey(WebDriver driver, String locator, String valueToSend){
        WebElement element = getWebElement(driver,locator);
        Keys key = null;
        if (GlobalContaints.OS_NAME.startsWith("Windows")){
            key = Keys.CONTROL;
        } else {
            key = Keys.COMMAND;
        }
        getWebElement(driver, locator).sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.BACK_SPACE));
        getWebElement(driver, locator).sendKeys(valueToSend);
    }



    protected String getElementText(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator)).getText();
    }

    public boolean isElementDisplayed(WebDriver diver, String locator){
        List<WebElement> elements = getListElement(driver, locator);
        return getWebElement(driver, castLocator(locator)).isDisplayed();
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... restParam){
        return getWebElement(driver, castLocator(locator, restParam)).isDisplayed();
    }

    public WebElement waitForElementVisible(WebDriver driver, String locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public WebElement waitForElementVisivle(WebDriver driver, String locator, String... restParam) {
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(getByLocator(castLocator(locator, restParam))));
    }

    public boolean waitForElementInvisible (WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public boolean waitForElementInvisible (WebDriver driver, String locator, String... restParam){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castLocator(locator, restParam))));
    }

    public List<WebElement> waitForListElementVisible(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator){
        return new  WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator)));
    }

    public boolean waitForListElementInvisible(WebDriver driver, String locator, String... restParam){
        return new  WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver, locator, restParam)));
    }

    public WebElement waitForElementClickable(WebDriver driver, String locator){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public WebElement waitForElementClickable(WebDriver driver, String locator, String... restParam){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(getByLocator(castLocator(locator, restParam))));
    }

    public void waitForUrlContains(WebDriver driver, String url) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException e) {
            System.out.println("Expected URL part: " + url);
            System.out.println("Actual URL: " + driver.getCurrentUrl());
            throw e;
        }
    }

    private Alert waitToAlertPesence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver){
        waitToAlertPesence(driver).accept();
    }

    public void cancelAlert(WebDriver driver){
        waitToAlertPesence(driver).dismiss();
    }


    // New Customer
    public void enterToTextboxByName(String textboxName, String value){
        String dynamicLocator = castLocator(BasePageUI.TEXTBOX_BY_NAME, textboxName);
        waitForElementVisivle(driver, dynamicLocator);
        sendKeysToElement(driver, dynamicLocator, value);
    }

    public void enterKeyboardToTextboxByName(String textboxName, CharSequence... keys){
        String dynamicLocator = castLocator(BasePageUI.TEXTBOX_BY_NAME, textboxName);
        waitForElementVisible(driver, dynamicLocator);
        driver.findElement(getByLocator(dynamicLocator)).sendKeys(keys);
    }


    // Error messgae
    public String getErrorMessageByField(String fieldName, String messageId) {
        String dynamicLocator = castLocator(BasePageUI.DYNAMIC_ERROR_MESSAGE_BY_FIELD, fieldName, messageId);
        waitForElementVisible(driver, dynamicLocator);
        return getElementText(driver, dynamicLocator);
    }

    @Step("Click to Submit button")
    public void clickToSubmitButton() {
        waitForElementClickable(driver, BasePageUI.SUBMIT_BUTTON);
        waitForElementClickable(driver, BasePageUI.SUBMIT_BUTTON);
    }
}
