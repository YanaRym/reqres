package tests.reqres_tests;

import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import reqres.ResourcesList;

import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.HTTP_OK;

public class GetListResourceTest {

    @Test
    public void getResourcesListResponse() {
        Response response = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .extract().response();
        Assert.assertEquals(response.statusCode(), HTTP_OK);
    }

    @Test
    public void getColorTest() {
        String body = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .log().all()
                .extract().body().asString();
        ResourcesList resourcesList = new Gson().fromJson(body, ResourcesList.class);
        String colour = resourcesList.getData().get(0).getColor();
        System.out.println("Color's number is: " + colour);
    }
}
