package group7.covidcontacttracing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/questionnaire")
    public String questionnaire() {
        return "questionnaire";

    }

    @GetMapping("/contactform")
    public String contactForm() {
        return "contactform";

    }
}
