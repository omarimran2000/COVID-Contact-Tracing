package group7.covidcontacttracing.ContactCase;

import group7.covidcontacttracing.CovidCase.CovidCase;
import group7.covidcontacttracing.CovidCase.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Contact Case REST Controller Class
 *
 * @author Omar Imran
 * @version March 8 2022
 */
@RestController
public class ContactCaseRestController {
    @Autowired
    private ContactCaseRepository contactCaseRepository;
    @Autowired
    private CovidCaseRepository covidCaseRepository;

    /**
     * Function used to add a contact case by the public health unit
     *
     * @param name         of the contact case
     * @param phone        number of the contact case
     * @param email        of the contact case
     * @param exposureDate of the contact case (SHOULD BE KEPT PRIVATE)
     * @param covidID      of the contact (SHOULD BE KEPT PRIVATE)
     * @return
     */
    @GetMapping("/contactCaseAdd")
    public ContactCase contactCaseAdd(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "phone") String phone,
                                      @RequestParam(value = "email") String email,
                                      @RequestParam(value = "exposureDate") String exposureDate,
                                      @RequestParam(value = "covidID") String covidID) {
        try {
            ContactCase contactCase = new ContactCase(covidID, name, email, exposureDate, phone);

            CovidCase covidCase = covidCaseRepository.findCovidCaseByCaseID(Long.parseLong(covidID));
            covidCase.addContactCase(contactCase);
            contactCaseRepository.save(contactCase);
            covidCaseRepository.save(covidCase);

            return contactCase;
        }catch (Exception ex){
            return null;
        }

    }

    /**
     * Used to find a list of all contact cases that need help
     *
     * @return list of contact cases
     */
    @GetMapping("/contactCaseHelp")
    public List<ContactCase> contactCaseHelp() {
        return contactCaseRepository.findByneedHelp(true);
    }

    /**
     * Used to find a list of all contact cases that have not filled out the form
     *
     * @return list of contact cases
     */
    @GetMapping("/contactCaseNotFilledOut")
    public List<ContactCase> contactCaseNotFilledOut() {
        return contactCaseRepository.findByfilledOut(false);
    }

    /**
     * Used to find a contact case based on a name and ID
     *
     * @param name of contact case
     * @param id   of contact case
     * @return list of contact cases
     */
    @GetMapping("/findContactCase")
    public ContactCase contactCaseName(@RequestParam(value="name") String name, @RequestParam(value="id") String id)
    {
        try {
            return contactCaseRepository.findByNameAndId(name, Long.valueOf(id)).get(0);
        }catch(Exception e){
            return null;
        }

    }

    /**
     * Used to find all the contact cases with symptoms
     *
     * @return list of contact cases
     */
    @GetMapping("/contactCaseSymptoms")
    public List<ContactCase> contactCaseSymptoms() {
        return contactCaseRepository.findBySymptoms(true);
    }

    /**
     * Used to add the answers from the questionnaire
     * @param name
     * @param id
     * @param symptoms
     * @param help
     * @return the case
     */
    @GetMapping("/contactCaseAddFilled")
    public ContactCase addFilled(@RequestParam(value = "name") String name,
                                 @RequestParam(value = "id") String id,
                                 @RequestParam(value = "symptoms") String symptoms,
                                 @RequestParam(value = "help") String help,
                                 @RequestParam(value = "quarantine") String quarantine) {
        ContactCase contactCase = contactCaseRepository.findByNameAndId(name, Long.valueOf(id)).get(0);
        contactCase.setFilledOut(true);

        contactCase.setSymptoms(symptoms.equals("Yes"));

        contactCase.setNeedHelp(help.equals("Yes"));
        contactCase.setQuarantine(quarantine.equals("Yes"));
        contactCaseRepository.save(contactCase);
        return contactCase;
    }
    /**
     * Used to find all the contact cases who are not following quarantine
     *
     * @return list of contact cases
     */
    @GetMapping("/contactCaseQuarantine")
    public List<ContactCase> contactCaseQuarantine() {
        return contactCaseRepository.findByQuarantine(false);
    }

}