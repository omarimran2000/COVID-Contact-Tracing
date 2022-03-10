package group7.covidcontacttracing;

import group7.covidcontacttracing.ContactCase.ContactCaseRestController;
import group7.covidcontacttracing.CovidCase.CovidCaseRestController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CovidContactTracingApplicationTests {

    @Autowired
    private WebController webController;

    @Autowired
    private ContactCaseRestController contactCaseRestController;

    @Autowired
    private CovidCaseRestController covidCaseRestController;

    @Test
    void contextLoads() throws Exception{
        assertThat(webController).isNotNull();
        assertThat(contactCaseRestController).isNotNull();
        assertThat(covidCaseRestController).isNotNull();
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testWebControllerResponse() throws Exception{

        String str = mockMvc.perform(get("/contactform")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        assert(str.contains("Covid Case Contact"));

        str = mockMvc.perform(get("/questionnaire")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        assert(str.contains("Daily Questionnaire"));
    }

}
