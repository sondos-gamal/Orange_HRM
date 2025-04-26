package Assertions;

import io.restassured.response.Response;
import org.testng.Assert;

public class CustomAssertions {

    public static void assertStatusCode(Response response, int expectedStatusCode, String message) {
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode, message);
    }

    public static void assertFieldNotNull(Response response, String jsonPath, String message) {
        String fieldValue = response.jsonPath().getString(jsonPath);
        Assert.assertNotNull(fieldValue, message);
    }
}
