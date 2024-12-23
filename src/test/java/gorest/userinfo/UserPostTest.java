package gorest.userinfo;

import gorest.model.UserPojo;
import gorest.testbase.TestBase;
import gorest.utils.TestUtils;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserPostTest extends TestBase {

    static String name = "user1";
    static String email = TestUtils.getRandomValue() + "user1245@gmail.com";
    static String gender = "female";
    static String status = "active";

    @Test
    public void createUsers() {
        UserPojo userPojo = new UserPojo();
        userPojo.setName(name);
        userPojo.setEmail(email);
        userPojo.setGender(gender);
        userPojo.setGender(status);

        Response response = given().log().all()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer 3b603aaa3461be76c5254dd45b9e4812bdbc0edb04871175bf44c595940f395d")
                .when()
                .body(userPojo)
                .post("/users");
        response.prettyPrint();
        response.then().statusCode(422);
    }

}
