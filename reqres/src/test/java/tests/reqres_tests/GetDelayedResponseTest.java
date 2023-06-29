package tests.reqres_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetDelayedResponseTest {

    @Test
    public void getResponseTest() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?delay=3")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }
}
