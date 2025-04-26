package PageObjects.pages.ContactDetails;

import Assertions.NativeAssertion;
import BrowserActions.BrowserActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.datatransfer.StringSelection;
import java.awt.Toolkit;

public class contactDetails {

    BrowserActions browserActions;
    NativeAssertion nativeAssertion;

    public contactDetails(WebDriver driver) {
        browserActions = new BrowserActions(driver);
        nativeAssertion = new NativeAssertion(driver);
    }

    // LOCATORS
    By ContactDetailsButton = By.xpath("//a[text()='Contact Details']");
    By street1 = By.xpath("//label[text()='Street 1']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    By street2 = By.xpath("//label[text()='Street 2']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    By City = By.xpath("//label[text()='City']/ancestor::div[@class='oxd-input-group oxd-input-field-bottom-space']//input");
    By State = By.xpath("//label[text()='State/Province']/following::input[1]");
    By Mobile = By.xpath("//label[text()='Mobile']/following::input[1]");
    By AttatchmentButton = By.xpath("//button[normalize-space()='Add']");
    By saveButton = By.xpath("//*[@type='submit']");
    By SuccessMessage = By.xpath("//div[@id='oxd-toaster_1']");
    By BrowseButton = By.xpath("//div[normalize-space()='Browse']");
    By SaveAttachmentButton = By.xpath("(//button[normalize-space()='Save'])[2]");
    By GridTable = By.xpath("//div[@class='oxd-table-row oxd-table-row--with-border']//div[text()='Admin']");

    // ACTIONS
    public void clickContactDetailsButton() {
        browserActions.click(ContactDetailsButton);
    }

    public void enterstreet1(String input) {
        browserActions.type(street1, input);
    }

    public void enterstreet2(String input) {
        browserActions.type(street2, input);
    }

    public void entercity(String input) {
        browserActions.type(City, input);
    }

    public void enterstate(String input) {
        browserActions.type(State, input);
    }

    public void entermobileNumber(String input) {
        browserActions.type(Mobile, input);
    }

    public void clickAttatchmentButton() {
        browserActions.click(AttatchmentButton);
    }

    public void clicksaveButton() {
        browserActions.click(saveButton);
    }

    public void clickBrowseButton() {
        browserActions.click(BrowseButton);
    }

    public void clickSaveAttachmentButton() {
        browserActions.click(SaveAttachmentButton);
    }

    public void ValidateSuccessMessage() {
        nativeAssertion.assertElementIsDisplayed(SuccessMessage);
    }

    public void ValidateGridTable() {
        nativeAssertion.assertElementIsDisplayed(GridTable);
    }

    /**
     * Uploads a file using Robot class by sending the file path to the system clipboard and then using keyboard events to
     * select the file in the file explorer.
     *
     * @param fileName The name of the file with extension under src/resources
     */
    public void uploadAttachment(String fileName) {
        // Click the "Add" button first
        browserActions.click(AttatchmentButton);

        // Then open the "Browse" button (if necessary for your page flow)
        clickBrowseButton();

        // Build the full path of the file to upload
        String filePath = System.getProperty("user.dir") + "\\src\\resources\\" + fileName;

        // Now, let's use Robot to simulate file selection in the system's File Explorer
        try {
            Robot robot = new Robot();
            robot.delay(2000); // wait for File Explorer to open

            // Set the file path to the system clipboard
            StringSelection stringSelection = new StringSelection(filePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

            // Press Ctrl + V to paste the file path
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            // Press Enter to select the file
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
