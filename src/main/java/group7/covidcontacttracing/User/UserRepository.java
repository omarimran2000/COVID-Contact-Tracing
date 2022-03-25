package group7.covidcontacttracing.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    User findCovidCaseByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
