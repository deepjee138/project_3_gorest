package gorest.userinfo;

import gorest.testbase.TestBase;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserDeleteTest extends TestBase {

    @Test
    public void VerifyUserDeleteSuccessfully() {
        given().log().ifValidationFails()
                .pathParam("id",7015056)
                .header("Authorization", "Bearer a4805c7c5cda603b60345e721f166223ec510ce5c21e457586a3e20739d66d85")
                .when()
                .delete("/users/{id}")
                .then().log().ifValidationFails().statusCode(404);
        given()
                .pathParam("id", 7015056)
                .when()
                .get("/{id}")
                .then()
                .statusCode(404);
    }


}
