package tests.reqres_tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.User;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class PostRegisterSuccessfulTest {

    @Test
    public void registerNewUserTest() {
        User user = User.builder()
                .email("eve.holt@reqres.in")
                .password("pistol")
                .build();
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("https://reqres.in/api/register")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }
}
