package org.uptospeed.backend.webservices;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.uptospeed.backend.data.RequestData;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class AnalysisResourceTest {

    @Test
    public void testAnalyzeEndpointSuccess() {
        given().when()
                .contentType(ContentType.JSON)
                .body(buildSentence("Hello, my name is Luis"))
                .post("/analyze")
                .then()
                .statusCode(200);
    }

    @Test
    public void testAnalyzeEndpointError() {
        given().when()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body("Hello, my name is Luis")
                .post("/analyze")
                .then()
                .statusCode(400);
    }

    @Test
    public void testAnalyzeEndpointTextPlainError() {
        given().when()
                .contentType(ContentType.TEXT)
                .accept(ContentType.JSON)
                .body("Hello, my name is Luis")
                .post("/analyze")
                .then()
                .statusCode(415);
    }

    private RequestData buildSentence(String text) {
        RequestData data = new RequestData();
        data.setSentence(text);
        return data;
    }

}