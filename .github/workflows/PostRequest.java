import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequest {

    @Test
    public void createEmployee() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        String requestBody = "{\n" +
                "  \"name\": \"tammy\",\n" +
                "  \"salary\": \"5000\",\n" +
                "  \"age\": \"20\"\n" +
                "}";


        Response response = null;

        try {
            response = RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                    .post("/create");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Response :" + response.asString());
        System.out.println("Status Code :" + response.getStatusCode());
        System.out.println("Does Reponse contains 'tammy'? :" + response.asString().contains("tammy"));


        assertEquals(200, response.getStatusCode());
    }
}