package group7.covidcontacttracing.CovidCase;

import group7.covidcontacttracing.CovidCase.CovidCase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CovidCaseRepository extends CrudRepository<CovidCase, Long> {
    CovidCase findCovidCaseByCaseID(@Param("caseID") Long caseID);

}
