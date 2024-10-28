package project.repository.new_version;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.model.Account;

import java.util.List;

@Repository
public interface AccountJpaRepository extends JpaRepository<Account, Long> {

    @Query(value = "select acc from Account acc where acc.lastName = :lastName")
    List<Account> fBLN(@Param("lastName") String lastName);

    @Query(value = "select * from account where email = :email", nativeQuery = true)
    List<Account> fBE(@Param("email") String email);
}
