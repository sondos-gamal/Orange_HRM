package GUITests;

import PageObjects.pages.ContactDetails.contactDetails;
import PageObjects.pages.JobDetails.jobDetails;
import PageObjects.pages.LoginPage.loginPage;
import PageObjects.pages.PIM.pim;
import PageObjects.pages.Sidebar.sidebar;
import org.testng.annotations.BeforeMethod;
import Config.ConfigReader;
import org.testng.annotations.Test;
import Utilities.RandomDataGenerator;
import Utilities.JsonReader;
import com.google.gson.JsonObject;

import java.util.jar.JarEntry;

public class E2Etestcase extends TestBase {

    JsonObject contact = JsonReader.read("contactDetails.json")
            .getAsJsonObject("contact");

    String city    = contact.get("city").getAsString();
    String state   = contact.get("state").getAsString();
    String mobile  = contact.get("mobile").getAsString();

    loginPage loginPage;
    sidebar sidebar;
    pim pim;
    contactDetails contactDetails;
    jobDetails jobDetails;
    String url = ConfigReader.getProperty("baseURI");

    @BeforeMethod
    public void setupTest() {
        loginPage = new loginPage(driver);
        sidebar = new sidebar(driver);
        pim =new pim(driver);
        contactDetails = new contactDetails(driver);
        jobDetails = new jobDetails(driver);


    }


    @Test
    public void E2E() throws InterruptedException {
        String street1 = RandomDataGenerator.generateRandomString(7);
        String street2 = RandomDataGenerator.generateRandomString(8);

        loginPage.NavigateToURL(url);
        loginPage.enterUserName("Admin");
        loginPage.enterpassword("admin123");
        loginPage.clickButton();
        sidebar.clickPIMButton();
        pim.enterEmployeeID("");
        pim.clickSearchButton();
        pim.clickEditButton();
        //
        contactDetails.clickContactDetailsButton();
        contactDetails.enterstreet1(street1);
        contactDetails.enterstreet2(street2);
        contactDetails.entercity(city);
        contactDetails.enterstate(state);
        contactDetails.entermobileNumber(mobile);
        contactDetails.clicksaveButton();
        contactDetails.ValidateSuccessMessage();
        //add attachment
        contactDetails.uploadAttachment("S_Automation Task.pdf");
        Thread.sleep(2000);
        contactDetails.clickSaveAttachmentButton();
        contactDetails.ValidateGridTable();
        contactDetails.ValidateSuccessMessage();

        //
        jobDetails.clickjobDetailsButton();
        jobDetails.EnterDate();
        jobDetails.SelectJob();
        jobDetails.SelectJob();
        jobDetails.SelectUnit();
        jobDetails.ClickSaveButton();
        jobDetails.ValidateSuccessMessage();




    }
}
