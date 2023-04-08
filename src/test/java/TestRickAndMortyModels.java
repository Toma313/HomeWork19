import config.MyOwnSpecificationForRA;
import models.rickAndMorty.location.Result;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestRickAndMortyModels {
    static String url1 = "https://rickandmortyapi.com/api/location";
 @BeforeClass
 public static void b(){
    MyOwnSpecificationForRA.create("https://rickandmortyapi.com/api/location");
}
    @Test
    public void test1(){ //all body to console
        System.out.println("VOLOSHCHUK TAMARA RUN JOB");
        String str = when()
                .get()
                .then().log().all().toString();
        System.out.println(str);
    }

    @Test
    public void test2(){
        when().get().then().body("info.count", equalTo(126));
    }

    @Test
    public void test5(){
       List<String> list1 =  when().get().then().extract().jsonPath().getList("results.dimension", String.class);
        System.out.println("First Method(as List): "+ list1);
    }
    @Test
    public void test6(){
        List<Result> listDem= when().get().then().extract().jsonPath().getList("results", Result.class);
        System.out.println("Second Method(every one)");
        for (Result l: listDem){
        System.out.println("Dimension: "+l.dimension);
    }
    }
}
