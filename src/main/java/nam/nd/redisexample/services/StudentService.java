package nam.nd.redisexample.services;

import nam.nd.redisexample.dtos.StudentDto;
import nam.nd.redisexample.models.Student;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:45 PM
 */
public interface StudentService {

    Student createStudent(StudentDto dto);

    Student updateStudent(StudentDto dto) throws Exception;

    StudentDto findOne(Long id);

    List<Student> findAllStudents();

    void deleteStudentById(long id);
}
