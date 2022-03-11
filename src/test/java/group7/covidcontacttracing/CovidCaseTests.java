package group7.covidcontacttracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class CovidCaseTests {

    @Autowired
    MockMvc mvc;

    @Test
    public void covidCaseAddTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/covidCaseAdd"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("{\"contactCases\":[],\"id\":2}")));

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
