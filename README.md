# Project Title

**OrangeHRM Automation Framework**

A comprehensive end-to-end automation framework for OrangeHRM demo site combining:

- **API Automation** (RestAssured + TestNG)
- **UI Automation** (Selenium WebDriver + TestNG + POM)
- **Data-Driven Testing** (JSON)
- **File Uploads** (Robot Class)
- **Reporting** (Allure and ExtentReports)

---

##  Tech Stack & Tools

- **Language:** Java 24
- **Build:** Maven
- **TestNG:** Test orchestration
- **RestAssured:** API testing
- **Selenium WebDriver:** UI testing
- **Page Object Model:** Structured page objects
- **Gson:** JSON parsing
- **Robot Class:** Native file dialog handling
- **JavaScript Executor:** Complex UI interactions
- **Allure:** Automated test reporting
- **ExtentReports:** Alternative HTML reporting
- **Target Application:** `https://opensource-demo.orangehrmlive.com`

---



## API Automation (RestAssured)

1. **Login API**: session cookie
2. **Add Employee**: POST `/api/v2/pim/employees` → validates `empNumber` & `employeeId`
3. **Update Personal Details**: PUT `/api/v2/pim/employees/{empNumber}/personal-details`

**CustomAssertions** verifies status codes & JSON fields.

---

## UI Automation (Selenium WebDriver)

- **POM Design:** Each page class wraps locators & actions.
- **Login Flow:** Reads credentials from `config.properties`.
- **Contact Details:** Uses JSON-driven values for city, state, mobile.
- **File Upload:** Click "Add" → Robot Class to paste file path & confirm.
- **Dropdowns:** JSExecutor to open & click complex custom dropdowns.

**Example: Select Job Title**
```java
jobPage.selectJobTitleJS("Software Engineer");
```

---

##  Reporting

### Allure Reports

1. **Add Dependency:**
   ```xml
   <dependency>
     <groupId>io.qameta.allure</groupId>
     <artifactId>allure-testng</artifactId>
     <version>2.21.0</version>
   </dependency>
   ```
2. **@Listeners({AllureTestNg.class})** on `TestBase`
3. **Generate & Serve:**
   ```bash
   mvn clean test
   mvn allure:serve
   ```


