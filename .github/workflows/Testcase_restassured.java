
import static io.restassured.RestAssured.given;
import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;
import static org.hamcrest.core.IsEqual.equalTo;

import io.restassured.response.ValidatableResponse;
import org.testng.TestNG;
import org.testng.annotations.Test;

public class Testcase_restassured {

    @Test
    public void testStatusCode() {

        given().get("https://jsonplaceholder.typicode.com/posts/3").
                then().statusCode(200);


    }

    @Test
    public void testlogging() {
        given().get("http://www.groupkt.com/post/c9b0ccb9/country-and-other-related-rest-webservices.htm\n").then().statusCode(200).log().all();
    }


    @Test
    public void testEqualtofunction() {

        given().get("http://www.groupkt.com/country/get/iso2code/US").then().body("RestResponse.result.name", equalTo("United States of America")).log().all();

    }

    @Test
    public void testParmertersAndHeaders() {
        given().param("key1", "value1").header("headA", "valueA").when().get("http://www.groupkt.com/country/get/iso2code/GB").then().statusCode(200).log().all();

    }


    @Test
    public void testsingleContent() {
        given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then().body("CUSTOMER.FIRSTNAME", equalTo("Sue")).log().all();

    }

    @Test
    public void testcircuitvalidation() {
        given().when().get("http://ergast.com/api/f1/2017/circuits.json").then().assertThat().statusCode(200).header("content-length",equalTo("4551"));

    }
}