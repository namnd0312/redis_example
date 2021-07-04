package nam.nd.redisexample.repositories;

import nam.nd.redisexample.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:43 PM
 */

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
