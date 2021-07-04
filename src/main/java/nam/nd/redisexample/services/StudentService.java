package nam.nd.redisexample.services;

import nam.nd.redisexample.models.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:45 PM
 */
public interface StudentService {

    void saveStudent(Student student);

    Optional<Student> findOne(Long id);

    List<Student> findAllStudents();
}
