package test.com.example.demo.integration;




import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

public class HelloWorld extends AbstractResourceTest {

    @BeforeEach
    public void setup() {
        super.setup();
    }

    @Test
    public void test() throws Exception {
        String url = "http:/localhost:/pocetnaPacijenta";
        MvcResult  result = (MvcResult) mvc
                .perform(MockMvcRequestBuilders.get(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));
        int status = result.getResponse().getStatus();
        Assertions.assertEquals(200, status);

    }

}