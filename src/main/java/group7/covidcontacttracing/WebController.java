package group7.covidcontacttracing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/questionnaire")
    public String addressBookCreate()
    {
        return "questionnaire";

    }
}
