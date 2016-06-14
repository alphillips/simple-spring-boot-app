package demo;

import java.util.List;

//import javax.ws.rs.HttpMethod;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import demo.domain.Item;


@Category(IntegrationTest.class)
public class ItemServiceITTest {

    
    private static RestTemplate restTemplate;
    private static String baseUrl;

    @BeforeClass
    public static void setup() {

        restTemplate = new RestTemplate();

        if (System.getProperty("baseUrl") != null) {
            baseUrl = System.getProperty("baseUrl");
        } else {
            baseUrl = "http://localhost:8080/";
        }

    }
    
    @Test
    public void getSuccess() throws Exception {
        
        //List<Item> items = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", ArrayList.class);

        ParameterizedTypeReference<List<Item>> typeRef = new ParameterizedTypeReference<List<Item>>() {};
        
        ResponseEntity<List<Item>> response = restTemplate.exchange(baseUrl + "/api/item/", HttpMethod.GET, null, typeRef);
        
        List<Item> returnedItems = response.getBody();
        
        assertTrue(returnedItems.size() == 2);
        
    }
    
}
