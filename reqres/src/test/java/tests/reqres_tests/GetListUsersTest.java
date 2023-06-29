package tests.reqres_tests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.UsersList;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetListUsersTest {

    @Test
    public void getListUsersResponseTest () {
        Response response = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }

    @Test
    public void getUsersEmailTest () {
        String body = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .log().all()
                .statusCode(HTTP_OK)
                .extract().body().asString();
        UsersList usersList = new Gson().fromJson(body, UsersList.class);
        String email = usersList.getData().get(2).getEmail();
        String expectedEmail = "tobias.funke@reqres.in";
        Assert.assertEquals(email, expectedEmail);
    }
}
