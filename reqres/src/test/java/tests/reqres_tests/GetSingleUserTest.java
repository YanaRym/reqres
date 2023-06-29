package tests.reqres_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetSingleUserTest {

    @Test
    public void getSingleUserResponseTest() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);

    }
}
