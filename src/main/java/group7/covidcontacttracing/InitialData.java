package group7.covidcontacttracing;

import group7.covidcontacttracing.ContactCase.ContactCase;
import group7.covidcontacttracing.ContactCase.ContactCaseRepository;
import group7.covidcontacttracing.CovidCase.CovidCase;
import group7.covidcontacttracing.CovidCase.CovidCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class InitialData implements ApplicationRunner {
    @Autowired
    private ContactCaseRepository contactCaseRepository;
    @Autowired
    private CovidCaseRepository covidCaseRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CovidCase covidCase = new CovidCase();
        covidCaseRepository.save(covidCase);

        ContactCase contactCase = new ContactCase(String.valueOf(covidCase.getID()),"Braxton","brax@gmail.com","2022-03-01","6135441111");
        contactCaseRepository.save(contactCase);
        covidCase.addContactCase(contactCase);

        covidCaseRepository.save(covidCase);



    }
}
