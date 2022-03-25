package group7.covidcontacttracing.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * User REST Controller Class
 *
 * @author Omar Imran
 * @version March 11 2022
 */
@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository ;

    /**
     * Authenticates users
     * @param username the user's username
     * @return if authenticated or not
     */
    @GetMapping("/checkUser")
    public String checkUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password)
    {
        try{

            userRepository.findCovidCaseByUsernameAndPassword(username, password).getId();
            return "true";

        }catch (Exception exception){
            return "false";
        }
    }
}
