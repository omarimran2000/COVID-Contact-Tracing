package group7.covidcontacttracing.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository ;
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam(value = "username") String username)
    {
        try{

            userRepository.findCovidCaseByUsername(username).getId();
            return "true";

        }catch (Exception exception){
            return "false";
        }
    }
}
