package by.babanin.repository;

import by.babanin.dao.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    @Query(value = "SELECT * FROM EMPLOYEE WHERE FIRST_NAME=?1 AND LAST_NAME=?2", nativeQuery = true)
    EmployeeEntity findByFirstNameAndLastName(String firstName, String lastName);

    EmployeeEntity findByLastName(String lastName);
}
