package group7.covidcontacttracing;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = AFTER_EACH_TEST_METHOD)
public class LoginTests {
    @Autowired
    MockMvc mvc;

    @Test
    public void loginTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/checkUser").param("username","omarimran"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

        mvc.perform(MockMvcRequestBuilders.get("/checkUser").param("username","lebron"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));

    }
}
