package group7.covidcontacttracing.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findCovidCaseByUsername(@Param("username") String username);
}
