package interfaces;

public class BasePageUI {
    // Main Page
    public static final String DYNAMIC_SITE_BY_NAME = "Xpath=//div[@id='navbar-brand-centered']/ul/li/a[text()='%s']";

    // Management Page
    public static final String DYNAMIC_SIDEBAR_LINK_BY_NAME = "xpath=//ul[@class='menusubnav']//a[text()='%s']";

    // TEXT BOX
    public static final String TEXTBOX_BY_NAME = "xpath=//input[@name='%s']";

    // ERROR MESSAGE
    public static final String DYNAMIC_ERROR_MESSAGE_BY_FIELD = "xpath=//td[text()='%s']/following-sibling::td/label[@id='%s']";

    // LABEL
    public static final String FIELD_LABEL_BY_TEXT = "xpath=//table[@class='layout']//td[text()='%s']";

    // BUTTON
    public static final String SUBMIT_BUTTON = "xpath=//input[@name='AccSubmit']";
    public static final String RESET_BUTTON = "xpath=//input[@name='res']";

}
