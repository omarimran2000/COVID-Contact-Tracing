package group7.covidcontacttracing.ContactCase;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Contact Case Class
 *
 * @author Omar Imran
 * @version March 8 2022
 */
@Entity
public class ContactCase {
    private Long id;
    private String covidID;
    private String name;
    private String email;
    private String exposureDate;
    private String phone;
    private boolean needHelp;
    private boolean filledOut;
    private boolean symptoms;
    private boolean quarantine;

    public ContactCase(String covidID, String name, String email, String exposureDate, String phone) {
        this.covidID = covidID;
        this.name = name;
        this.email = email;
        this.exposureDate = exposureDate;
        this.phone = phone;
        needHelp = false;
        filledOut = false;
        symptoms = false;
        quarantine = true;
    }

    public ContactCase() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCovidID() {
        return covidID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getExposureDate() {
        return exposureDate;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isNeedHelp() {
        return needHelp;
    }

    public boolean isFilledOut() {
        return filledOut;
    }

    public boolean isSymptoms() {
        return symptoms;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setCovidID(String covidID) {
        this.covidID = covidID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExposureDate(String exposureDate) {
        this.exposureDate = exposureDate;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setNeedHelp(boolean needHelp) {
        this.needHelp = needHelp;
    }

    public void setFilledOut(boolean filledOut) {
        this.filledOut = filledOut;
    }

    public void setSymptoms(boolean symptoms) {
        this.symptoms = symptoms;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public String toString() {
        return "Name: " + getName() + " Email: " + getEmail() + " Phone: " + getPhone() + " COVID_Contact_ID: " + getCovidID() + " Exposure Date: " + getExposureDate();
    }
}
