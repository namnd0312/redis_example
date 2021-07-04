package nam.nd.redisexample.services.impl;

import nam.nd.redisexample.models.Student;
import nam.nd.redisexample.repositories.StudentRepository;
import nam.nd.redisexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:46 PM
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        return this.studentRepository.findAll();
    }
}
