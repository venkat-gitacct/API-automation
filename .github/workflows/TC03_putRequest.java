import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;


public class TC03_putRequest {

    public static Map<String, String> map = new HashMap<String, String>();

    @BeforeTest
    public void putdata(){
        map.put("userId", "2");
        map.put("id", "20");
        map.put("title", "this is projectdebug.com");
        map.put("body", "i am testing REST api with REST-Assured and sending a PUT 2nd request.");
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        RestAssured.basePath = "/posts/";
    }

    @Test
    public void testPUT(){
        given()
                .contentType("application/json")
                .body(map)
                .when()
                .put("/100")
                .then()
                .statusCode(200)
                .and()
                .body("title", equalTo("this is projectdebug.com"));
    }

   /* @Test
    public void testGET()
    {
        given().when().get("http://jsonplaceholder.typicode.com/").then().assertThat().body("title",equalTo("this is projectdebug.com")).log().all();

    }*/


/*@Test
    public void testGetPersons() {
        expect()
                .statusCode(200)
                .body(hasXPath("//*[self::person and self::person[@id='1'] and self::person/email[text()='test@hascode.com'] and self::person/firstName[text()='Tim'] and self::person/lastName[text()='Testerman']]"))
                .body(hasXPath("//*[self::person and self::person[@id='20'] and self::person/email[text()='dev@hascode.com'] and self::person/firstName[text()='Sara'] and self::person/lastName[text()='Stevens']]"))
                .body(hasXPath("//*[self::person and self::person[@id='11'] and self::person/email[text()='devnull@hascode.com'] and self::person/firstName[text()='Mark'] and self::person/lastName[text()='Mustache']]"))
                .when().get("/service/persons/xml");
    }*/

}

