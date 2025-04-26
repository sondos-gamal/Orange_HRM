package PageObjects.pages.JobDetails;

import Assertions.NativeAssertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class jobDetails {

        BrowserActions browserActions;
        NativeAssertion nativeAssertion;

        public jobDetails (WebDriver driver) {
            browserActions = new BrowserActions(driver);
            nativeAssertion = new NativeAssertion(driver);
        }
        //LOCATORS

        By jobDetailsButton=By.xpath("//a[text()='Job']");
        By Date =By.xpath("//input[@placeholder='yyyy-dd-mm']");
        By JobTitle=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
        By EmploymentStatus=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[5]");
        By SubUnit = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[3]");
        By ChosenSubUnit=By.xpath("//div[text()='Quality Assurance']");
        By ChosenJobTitle=By.xpath("//div[text()='Software Engineer']");
        By ChosenEmploymentStatus=By.xpath("//div[text()='Part-Time Contract']");
        By saveButton = By.xpath("//*[@type='submit']");
        By SuccessMessage = By.xpath("//div[@id='oxd-toaster_1']");
        By toggle = By.xpath("//div[contains(@class, 'oxd-switch-wrapper')]//input[@type='checkbox']");




    //ACTIONS




        public void clickjobDetailsButton() {
            browserActions.click(jobDetailsButton);
        }
         public void EnterDate() {
              browserActions.type(Date,"2015-15-06");
        }

        public void SelectJob(){
            browserActions.click(JobTitle);
            browserActions.click(ChosenJobTitle);

        }

         public void Selectstaus(){
            browserActions.click(EmploymentStatus);
            browserActions.click(ChosenEmploymentStatus);

    }

    public void SelectUnit(){
        browserActions.click(SubUnit);
        browserActions.click(ChosenSubUnit);

    }
    public void ClickSaveButton(){
            browserActions.click(saveButton);
    }
    public void ValidateSuccessMessage() {
        nativeAssertion.assertElementIsDisplayed(SuccessMessage);
    }




    }




