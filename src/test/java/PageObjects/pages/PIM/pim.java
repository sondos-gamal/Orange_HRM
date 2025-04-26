package PageObjects.pages.PIM;

import Assertions.NativeAssertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class pim {
        BrowserActions browserActions;
        NativeAssertion nativeAssertion;

        public pim (WebDriver driver) {
            browserActions = new BrowserActions(driver);
            nativeAssertion = new NativeAssertion(driver);
        }
        //LOCATORS

        By EmployeeID=By.xpath("//div[@data-v-957b4417='']//input[@class='oxd-input oxd-input--active']");
        By SearchButton=By.xpath("//button[text()=' Search ']");
        By EditButton=By.xpath("//*[@class='oxd-icon bi-pencil-fill']");

        //ACTIONS

        public void enterEmployeeID(String input) {
            browserActions.type(EmployeeID, input);
        }


        public void clickSearchButton() {
            browserActions.click(SearchButton);
        }

         public void clickEditButton() {
        browserActions.click(EditButton);
         }
    }



