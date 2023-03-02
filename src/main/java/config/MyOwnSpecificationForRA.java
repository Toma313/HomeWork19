package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;

public class MyOwnSpecificationForRA {

static  public void create(String urlbase){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(urlbase)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
            .build();
    RestAssured.responseSpecification =  new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();

}
}
