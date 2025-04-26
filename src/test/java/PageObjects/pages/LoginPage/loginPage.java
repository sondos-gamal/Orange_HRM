package PageObjects.pages.LoginPage;
import Assertions.NativeAssertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
    BrowserActions browserActions;
    NativeAssertion nativeAssertion;

    public loginPage(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        nativeAssertion = new NativeAssertion(driver);
    }
    //LOCATORS

    By UserName=By.xpath("//*[@name=\"username\"]");
    By Password=By.xpath("//*[@name=\"password\"]");
    By LoginButton=By.xpath("//*[@type=\"submit\"]");

    //ACTIONS

    public void NavigateToURL(String url){
        browserActions.navigateToURl(url);
    }
    public void enterUserName(String input) {
        browserActions.type(UserName, input);
    }

        public void enterpassword(String input) {
            browserActions.type(Password, input);
        }

        public void clickButton() {
            browserActions.click(LoginButton);
        }
    }

