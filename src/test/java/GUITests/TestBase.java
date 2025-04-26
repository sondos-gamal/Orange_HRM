package GUITests;

import DriverManager.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class TestBase {
    protected WebDriver driver;
    DriverManager driverManager;

    @BeforeMethod
    public void setup() {
        driverManager = new DriverManager();
        driverManager.initDriver("chrome");
        driver = driverManager.getDriver();
    }

    @AfterMethod
    public void terminateDriver() {
        System.out.println("Quitting WebDriver in TestBase...");
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
}