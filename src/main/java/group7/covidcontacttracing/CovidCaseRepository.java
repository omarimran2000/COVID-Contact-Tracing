package group7.covidcontacttracing;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CovidCaseRepository extends CrudRepository<CovidCase, Long> {
    CovidCase findCovidCaseByCaseID(@Param("caseID") Long caseID);

}
