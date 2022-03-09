package group7.covidcontacttracing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactCaseRepository extends CrudRepository<ContactCase, Long> {
    List<ContactCase> findByNameAndId(@Param("name") String name, @Param("id") Long id);
    List<ContactCase> findByneedHelp(@Param("needHelp") boolean needHelp);
    List<ContactCase> findByfilledOut(@Param("filledOut") boolean filledOut);
}
