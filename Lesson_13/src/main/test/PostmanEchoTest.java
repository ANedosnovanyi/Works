import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@DisplayName("Проверка методов коллекции Postman Echo из папки Request Methods ")
public class PostmanEchoTest {

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @DisplayName("Проверка метода Get Request")
    @Test
    void testGetRequest() {
        given().
                when().
                get("/get").
                then().
                statusCode(200).
                body("args", notNullValue()).
                body("headers", notNullValue()).
                body("url", notNullValue());
    }

    @DisplayName("Проверка метода Post Raw Text")
    @Test
    void testPostRawText() {
        String rawText = "This is a raw text.";

        given().
                contentType(ContentType.TEXT).
                body(rawText).
                when().
                post("/post").
                then().
                statusCode(200).
                body("data", equalTo(rawText));
    }

    @DisplayName("Проверка метода Post Form Data")
    @Test
    void testPostFormData() {
        given().
                contentType("application/x-www-form-urlencoded; charset=UTF-8").
                formParam("key1", "value1").
                formParam("key2", "value2").
                when().
                post("/post").
                then().
                statusCode(200).
                body("form.key1", equalTo("value1")).
                body("form.key2", equalTo("value2"));
    }

    @DisplayName("Проверка метода Put Request")
    @Test
    void testPutRequest() {
        given().
                body("some data").
                when().
                put("/put").
                then().
                statusCode(200).
                body("data", equalTo("some data")).
                body("json", nullValue()).
                body("url", notNullValue());
    }

    @DisplayName("Проверка метода Delete Request")
    @Test
    void testDeleteRequest() {
        given().
                when().
                delete("/delete").
                then().
                statusCode(200).
                body("args", equalTo(Collections.emptyMap())).
                body("data", equalTo(Collections.emptyMap())).
                body("files", equalTo(Collections.emptyMap())).
                body("form", equalTo(Collections.emptyMap())).
                body("json", nullValue()).
                body("headers", notNullValue()).
                body("url", equalTo("https://postman-echo.com/delete"));
    }

    @DisplayName("Проверка метода Patch Request")
    @Test
    void testPatchRequest() {
        given().
                body("some data").
                when().
                patch("/patch").
                then().
                statusCode(200).
                body("data", equalTo("some data")).
                body("json", nullValue()).
                body("url", notNullValue());
    }
}
