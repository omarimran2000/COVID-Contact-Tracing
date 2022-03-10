package group7.covidcontacttracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CovidCaseTests {

    @Autowired
    MockMvc mvc;

    @Test
    public void covidCaseAddTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/covidCaseAdd"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("{\"contactCases\":[],\"id\":4}")));

    }

    @Test
    public void findCovidCaseTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/covidCaseAdd"));
        mvc.perform(MockMvcRequestBuilders.get("/covidCaseAdd"));
        mvc.perform(MockMvcRequestBuilders.get("/findCovidCase").param("caseID","3"))
                .andExpect(status().isOk())
                .andExpect((content().string(containsString("{\"contactCases\":[],\"id\":3}"))));

    }


}
