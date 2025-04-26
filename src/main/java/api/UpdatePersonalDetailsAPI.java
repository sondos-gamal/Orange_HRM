package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import Config.ConfigReader;

public class UpdatePersonalDetailsAPI {

    public static Response updatePersonalDetails(String empNumber, String employeeId, String cookie) {
        String baseURI = ConfigReader.getProperty("baseURI");

        String requestBody = "{"
                + "\"lastName\":\"QCFFF\","
                + "\"firstName\":\"LOLO\","
                + "\"middleName\":\"Weal\","
                + "\"employeeId\":\"" + employeeId + "\","
                + "\"otherId\":\"5\","
                + "\"drivingLicenseNo\":\"5845\","
                + "\"drivingLicenseExpiredDate\":\"2025-08-31\","
                + "\"gender\":\"1\","
                + "\"maritalStatus\":\"Single\","
                + "\"birthday\":\"1998-11-30\","
                + "\"nationalityId\":55"
                + "}";

        Response response = given()
                .baseUri(baseURI)
                .header("Content-Type", "application/json")
                .header("Cookie", cookie)
                .body(requestBody)
                .when()
                .put("pim/employees/" + empNumber + "/personal-details");

        return response;
    }
}
