package tests.reqres_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.User;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class PatchUpdateTest {

    @Test
    public void patchUserUpdate() {
        User user = User.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        Response response = given()
                .body(user)
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }
}
