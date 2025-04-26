package APITest;

import api.AddEmployeeAPI;
import api.UpdatePersonalDetailsAPI;
import Assertions.CustomAssertions;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.qameta.allure.Allure;
import org.testng.annotations.Test;

public class APITests {

    @Test
    public void testAddEmployeeAndUpdateDetails() {
        // Step 0: Use manually copied Cookie
        String cookie = "orangehrm=rt4jbj0o823vcevao5taamgoug"; // 👈 حطي هنا الكوكي اللي هتجيبيه من Postman أو المتصفح.

        // Step 1: Add New Employee
        Response addEmployeeResponse = AddEmployeeAPI.addEmployee(
                "Sara", "Ahmed", "Ali", "03511", cookie);

        // Assertions on Add Employee
        CustomAssertions.assertStatusCode(addEmployeeResponse, 200, "Add Employee failed! Status code is not 200");
        CustomAssertions.assertFieldNotNull(addEmployeeResponse, "data.empNumber", "Employee Number is missing!");
        CustomAssertions.assertFieldNotNull(addEmployeeResponse, "data.employeeId", "Employee ID is missing!");

        // Extract empNumber and employeeId
        String empNumber = addEmployeeResponse.jsonPath().getString("data.empNumber");
        String employeeId = addEmployeeResponse.jsonPath().getString("data.employeeId");

        // Step 2: Update Personal Details
        Response updateDetailsResponse = UpdatePersonalDetailsAPI.updatePersonalDetails(empNumber, employeeId, cookie);

        // Assertions on Update Personal Details
        CustomAssertions.assertStatusCode(updateDetailsResponse, 200, "Update Personal Details failed! Status code is not 200");
    }
}
