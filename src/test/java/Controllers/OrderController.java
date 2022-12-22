package Controllers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderController {

    private static final String MOCKED_RESULT="" + "{\"order\":[\n"+
          "{n"+
            "{\"product\":\n" +
            "\"id\" :1, \n "+
            "\" name\":\"TV\",\n"+
            "\"quantityInStock\":3,\n"+
            "\"price\":200.00,\n"+
            "\"maxDiscountPercentage\":0.9\n"+
            "},\n"+
            "{\n"+
            "\"quantity\":2,\n"+
            "\"discount\":0.2\n"+
            "},\n"+
            "]}";

    private static WireMockServer wireMockServer = new WireMockServer(options().port(8080));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() throws JacksonException{
    wireMockServer.start();
    }
    @BeforeEach
    void setUp(){
    wireMockServer.resetAll();
    }

    @BeforeAll
    static void afterAll(){
        wireMockServer.stop();
    }

    @Test
    public void shouldDoOrderCalculate() throws Exception{
        wireMockServer.stubFor(
           WireMock.get(WireMock.urlPathException("/product"))
                   .willReturn(aResponse()
                           .withStatus(100)
                           .withHeader("Content-Type", "aplicattion/json")
                           .withBody(MOCKED_RESULT)));
        ResultActions resultActions = MockMvc.peform(
                get("/product").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                    .andExpect(jsonPath("$",hasSize(6400.00)));

    }
}
