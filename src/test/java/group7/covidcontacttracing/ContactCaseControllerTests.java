package group7.covidcontacttracing;

import group7.covidcontacttracing.ContactCase.ContactCaseRestController;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContactCaseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ContactCaseRestController contactCaseRestController;

    @Test
    @Order(1)
    void contextLoads() throws Exception{
        assertThat(contactCaseRestController).isNotNull();
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(2)
    void testContactCaseAdd() throws Exception{
        String str = mockMvc.perform(get("/contactCaseAdd")
                .param("name", "NAME")
                .param("phone", "PHONE")
                .param("email", "EMAIL")
                .param("exposureDate", "EXPOSURE_DATE")
                .param("covidID", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        String[] params = str.replaceAll("[{}]","").split(",");

        assert(params[0].split(":")[1].equals("2"));
        assert(params[1].split(":")[1].equals("\"1\""));
        assert(params[2].split(":")[1].equals("\"NAME\""));
        assert(params[3].split(":")[1].equals("\"EMAIL\""));
        assert(params[4].split(":")[1].equals("\"EXPOSURE_DATE\""));
        assert(params[5].split(":")[1].equals("\"PHONE\""));
        assert(params[6].split(":")[1].equals("false"));
        assert(params[7].split(":")[1].equals("false"));
        assert(params[8].split(":")[1].equals("false"));
    }

    @Test
    @Order(4)
    void testContactCaseHelp() throws Exception{
        String str = mockMvc.perform(get("/contactCaseHelp")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        assert(!str.equals("[]"));
    }

    @Test
    @Order(4)
    void testContactCaseFind() throws Exception{
        String str = mockMvc.perform(get("/findContactCase")
                .param("name", "NAME")
                .param("id", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        String[] params = str.replaceAll("[{}]","").split(",");

        assert(!str.equals("[]"));
    }

    @Test
    @Order(4)
    void testContactCaseNotFilledOut() throws Exception{
        String str = mockMvc.perform(get("/contactCaseNotFilledOut")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        assert(!str.equals("[]"));
    }

    @Test
    @Order(4)
    void testContactCaseSymptoms() throws Exception{
        String str = mockMvc.perform(get("/contactCaseSymptoms")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        assert(!str.equals("[]"));
    }

    @Test
    @Order(3)
    void testContactCaseFill() throws Exception{
        String str = mockMvc.perform(get("/contactCaseAddFilled")
                .param("name", "NAME")
                .param("id", "2")
                .param("symptoms", "Yes")
                .param("help", "Yes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andReturn().getResponse().getContentAsString();

        String[] params = str.replaceAll("[{}]","").split(",");

        assert(params[6].split(":")[1].equals("true"));
        assert(params[7].split(":")[1].equals("true"));
        assert(params[8].split(":")[1].equals("true"));
    }

}
