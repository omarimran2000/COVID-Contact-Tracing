package group7.covidcontacttracing;

import group7.covidcontacttracing.ContactCase.ContactCaseRestController;
import group7.covidcontacttracing.CovidCase.CovidCaseRestController;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
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

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWebControllerResponse() throws Exception{
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/contactform",
                String.class)).contains("Covid Case Contact");
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/questionnaire",
                String.class)).contains("Daily Questionnaire");
    }

}
