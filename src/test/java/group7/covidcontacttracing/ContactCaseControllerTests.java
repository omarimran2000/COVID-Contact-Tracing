package group7.covidcontacttracing;

import group7.covidcontacttracing.ContactCase.ContactCaseRestController;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
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

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @Order(2)
    void testContactCaseAdd() throws Exception{
        mockMvc.perform(get("/contactCaseAdd")
                .param("name", "NAME")
                .param("phone", "PHONE")
                .param("email", "EMAIL")
                .param("exposureDate", "EXPOSURE_DATE")
                .param("covidID", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @Order(4)
    void testContactCaseHelp() throws Exception{
        mockMvc.perform(get("/contactCaseHelp")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @Order(4)
    void testContactCaseFind() throws Exception{
        mockMvc.perform(get("/findContactCase")
                .param("name", "NAME")
                .param("id", "2")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @Order(4)
    void testContactCaseNotFilledOut() throws Exception{
        mockMvc.perform(get("/contactCaseNotFilledOut")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @Order(4)
    void testContactCaseSymptoms() throws Exception{
        mockMvc.perform(get("/contactCaseSymptoms")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

    @Test
    @Order(3)
    void testContactCaseFill() throws Exception{
        mockMvc.perform(get("/contactCaseAddFilled")
                .param("name", "NAME")
                .param("id", "2")
                .param("symptoms", "Yes")
                .param("help", "Yes")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print());
    }

}
