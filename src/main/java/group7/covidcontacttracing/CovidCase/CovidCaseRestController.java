package group7.covidcontacttracing.CovidCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Covid Case REST Controller Class
 *
 * @author Wintana Yosief
 * @version March 9, 2022
 */
@RestController
public class CovidCaseRestController {
    @Autowired
    private CovidCaseRepository covidCaseRepository;

    /**
     * Function to add a Covid case
     *
     * @return
     */
    @GetMapping("/covidCaseAdd")
    public CovidCase covidCaseAdd() {
        CovidCase covidCase = new CovidCase();
        covidCaseRepository.save(covidCase);
        return covidCase;

    }

    /**
     * Function to find a Covid case from its ID
     *
     * @param caseID of the Covid case
     * @return
     */
    @GetMapping("/findCovidCase")
    public CovidCase covidCaseFind(@RequestParam(value = "caseID") String caseID) {
        return covidCaseRepository.findCovidCaseByCaseID(Long.valueOf(caseID));
    }
}
