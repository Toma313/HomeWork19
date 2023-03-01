import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.rickAndMorty.Characters;
import models.rickAndMorty.Result;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import static rest.RestGet.*;

public class TestRickAndMortyModels {
    static String url = "https://rickandmortyapi.com/api/";
    static Characters characters;
    @BeforeClass
    public static void b() throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        characters=om.readValue(Get(url+"character"), Characters.class);
    }
    @Test
    public void test1(){
        assertNotNull("Characters info next equals not null", characters.info.next);
        System.out.println(characters.info.next);
    }
    @Test
    public void test2(){
        assertTrue(String.valueOf(characters.info.count),characters.info.count >700);
    }
    @Test
    public void test3(){
        assertEquals(String.valueOf(characters.results.get(0).name),"", characters.results.get(0).name);
    }
    @Test
    public void test4(){
        for (Result l: characters.results){
            assertNotNull(l.id);
        }
    }

    @Test
    public void test5() throws Exception {
        for (Result l : characters.results) {
            for (String ll : l.episode) {
                System.out.println(ll);
                if (!ll.contains(url)) {
                    throw new Exception("in episodes not contains..");
                }
            }
        }
    }
    @Test
    public void test6(){
        for (Result l : characters.results) {
            for (String ll : l.episode) {
                assertEquals(200, getStatuCode(ll));
                System.out.println(ll+" = "+getStatuCode(ll));
                }
            }
        }
}
