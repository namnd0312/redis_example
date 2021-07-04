package nam.nd.redisexample.repositories;

import nam.nd.redisexample.models.ClassModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:44 PM
 */

@Repository
public interface ClassRepository extends JpaRepository<ClassModel, Long> {
}
