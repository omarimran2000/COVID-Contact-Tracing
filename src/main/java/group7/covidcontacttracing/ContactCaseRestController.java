package group7.covidcontacttracing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ContactCaseRestController {
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private  ContactCaseRepository contactCaseRepository;

    @GetMapping("/contactCaseAdd")
    public ContactCase contactCaseAdd(@RequestParam(value="name") String name,
                                      @RequestParam(value="phone") String phone,
                                      @RequestParam(value="email") String email,
                                      @RequestParam(value="exposureDate") String exposureDate,
                                      @RequestParam(value="covidID") String covidID)
    {
        ContactCase contactCase = new ContactCase(counter.incrementAndGet(),covidID,name,email,exposureDate,phone);
        contactCaseRepository.save(contactCase);

        return contactCase;

    }
    @GetMapping("/contactCaseHelp")
    public List<ContactCase> contactCaseHelp()
    {
        return contactCaseRepository.findByneedHelp(true);
    }
    @GetMapping("/contactCaseNotFilledOut")
    public List<ContactCase> contactCaseNotFilledOut()
    {
        return contactCaseRepository.findByfilledOut(false);
    }
    @GetMapping("/findContactCase")
    public List<ContactCase> contactCaseName(@RequestParam(value="name") String name, @RequestParam(value="id") String id)
    {
        return contactCaseRepository.findByNameAndId(name,Long.valueOf(id));
    }

}