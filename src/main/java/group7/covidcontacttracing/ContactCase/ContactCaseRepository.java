package group7.covidcontacttracing.ContactCase;

import group7.covidcontacttracing.ContactCase.ContactCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
/**
 * Contact Case Repository Class
 *
 * @author Omar Imran
 * @version March 8 2022
 */
public interface ContactCaseRepository extends CrudRepository<ContactCase, Long> {
    List<ContactCase> findByNameAndId(@Param("name") String name, @Param("id") Long id);
    List<ContactCase> findByneedHelp(@Param("needHelp") boolean needHelp);
    List<ContactCase> findByfilledOut(@Param("filledOut") boolean filledOut);
    List<ContactCase> findBySymptoms(@Param("symptoms") boolean symptoms);
}
