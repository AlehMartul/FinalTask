package utils;

import aquality.selenium.browser.AqualityServices;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;

public class ApiUtil {

    public static Response post(String uri) {
        Response response = RestAssured.given().contentType(ContentType.JSON).post(uri);
        AqualityServices.getLogger().info("Getting response");
        return response;
    }

    public static Response get(String uri) {
        AqualityServices.getLogger().info("Getting info");
        Response response = RestAssured.get(uri).andReturn();
        return response;
    }

    public void postResult(String baseUri, String login, String password, String body) {
        RestAssured.given().contentType(ContentType.JSON).auth().preemptive().basic(login, password)
                .when().body(body)
                .post(baseUri);
    }

    public void postScreenshot(String baseUri, String login, String password, String pathToFile) {
        RestAssured.given().contentType("multipart/form-data").multiPart("attachment", new File(pathToFile))
                .auth().preemptive().basic(login, password)
                .post(baseUri);
    }
}
