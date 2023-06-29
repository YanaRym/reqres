package tests.reqres_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetSingleResourceTest {

    @Test
    public void getSingleResourceTest() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/unknown/2")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }
}
