package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import Config.ConfigReader;

public class AddEmployeeAPI {

    public static Response addEmployee(String firstName, String middleName, String lastName, String employeeId, String cookie) {
        String baseURI = ConfigReader.getProperty("baseURI");

        String requestBody = "{"
                + "\"firstName\":\"" + firstName + "\","
                + "\"middleName\":\"" + middleName + "\","
                + "\"lastName\":\"" + lastName + "\","
                + "\"empPicture\":null,"
                + "\"employeeId\":\"" + employeeId + "\""
                + "}";

        Response response = given()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .header("Cookie", cookie)
                .body(requestBody)
                .when()
                .post("pim/employees");

        return response;
    }
}
