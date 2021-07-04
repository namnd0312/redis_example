package nam.nd.redisexample.services.impl;

import nam.nd.redisexample.models.Student;
import nam.nd.redisexample.repositories.StudentRepository;
import nam.nd.redisexample.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:46 PM
 */

@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @CachePut(value = "student", key = "#student.id")
    @Override
    public Student saveStudent(Student student) {
        logger.info("save student in service layer");
        return this.studentRepository.save(student);
    }

    @Cacheable(value = "student", key = "#id")
    @Override
    public Optional<Student> findOne(Long id) {
        logger.info("find student in service layer id: {}", id);
        return this.studentRepository.findById(id);
    }

    @Override
    public List<Student> findAllStudents() {
        logger.info("tìm kiếm all student in service layer");
        return this.studentRepository.findAll();
    }

    @CacheEvict(value = "student", allEntries = false, key = "#id")
    @Override
    public void deleteStudentById(long id) {
        logger.info("delete student in service layer id: {}", id);
        this.studentRepository.deleteById(id);
    }
}
