package interfaces;

import java.net.PortUnreachableException;

public class NewCustomerPageUI {
    // TEXT BOX
    public static final String CUSTOMER_NAME_TEXTBOX = "xpath=//input[@name='name']";
    public static final String ADDRESS_TEXTAREA = "xpath=//td[text()='Address']/parent::tr/td/textarea";
    public static final String CITY_TEXTBOX = "xpath=//input[@name='city']";

    // ERROR MESSAGE
    public static final String CUSTOMER_NAME_ERROR_MESSAGE = "xpath=//td[text()='Customer Name']/following-sibling::td/label[@id='message']";
    public static final String CITY_ERROR_MESSAGE = "xpath=//td[text()='City']/following-sibling::td/label[@id='message4']";
    public static final String STATE_ERROR_MESSAGE = "xpath=//td[text()='State']/following-sibling::td/label[@id='message5']";
    public static final String PIN_ERROR_MESSAGE = "xpath=//td[text()='PIN']/following-sibling::td/label[@id='message6']";

    // LABEL





}
