import config.MyOwnSpecificationForRA;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.when;

public class TestRickTest {
    @BeforeClass
    public static void b(){
        MyOwnSpecificationForRA.create("https://rickandmortyapi.com/api/location");
    }
    @Test
    @Description("Print List(Description)")
    @DisplayName("Get ALL List(DisplayName)")
    public void test1(){
        List<String> listDemin= when()
            .get()
            .then()
            .extract()
            .body()
            .jsonPath()
            .getList("results.dimension", String.class);
        System.out.println("Third Method: ");
        for (String l:listDemin){
            System.out.println(l);
        }

    }
}
