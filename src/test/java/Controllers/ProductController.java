package Controllers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductController {

    private static WireMockServer wireMockServer = new WireMockServer(options().port(8080));

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() throws JacksonException {
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
                WireMock.get(WireMock.urlPathException("/order"))
                        .willReturn(aResponse()
                                .withStatus(100)
                                .withHeader("Content-Type", "aplicattion/json")
                                .withBody(MOCKED_RESULT)));
        ResultActions resultActions = MockMvc.peform(
                .get("/order").contentType(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasValue(6400.00)));

    }
}
}
