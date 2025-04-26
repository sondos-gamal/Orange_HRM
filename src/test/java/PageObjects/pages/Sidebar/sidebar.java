package PageObjects.pages.Sidebar;

import Assertions.NativeAssertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class sidebar {
    BrowserActions browserActions;
    NativeAssertion nativeAssertion;

    public sidebar(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        nativeAssertion = new NativeAssertion(driver);
    }
    //LOCATORS

    By PIM_Button = By.xpath("//span[text()=\"PIM\"]");


    //ACTIONS

    public void clickPIMButton() {
        browserActions.click(PIM_Button);
    }

}