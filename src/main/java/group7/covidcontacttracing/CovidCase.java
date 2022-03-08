package group7.covidcontacttracing;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Covid Case Class
 * @version March 7, 2022
 * @author Wintana Yosief
 */
@Entity
public class CovidCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseID;
    @OneToMany
    private List<ContactCase> contactCases;

    public CovidCase() {
        contactCases = new ArrayList<ContactCase>();
    }

    public Long getID(){
        return caseID;
    }

    public void setID(long caseID){
        this.caseID = caseID;
    }

    public void addContactCase(ContactCase contactCase){
        contactCases.add(contactCase);
    }

    public void setContactCases(List<ContactCase> contactCases){
        this.contactCases = contactCases;
    }

    public List<ContactCase> getContactCases(){
        return contactCases;
    }
}
