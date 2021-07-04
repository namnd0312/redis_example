package nam.nd.redisexample.services.impl;

import nam.nd.redisexample.dtos.StudentDto;
import nam.nd.redisexample.models.Student;
import nam.nd.redisexample.repositories.StudentRepository;
import nam.nd.redisexample.repositories.redis.RedisStudentRepository;
import nam.nd.redisexample.services.StudentService;
import nam.nd.redisexample.services.mappers.StudentMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:46 PM
 */

@Transactional
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisStudentRepository redisStudentRepository;

    @Override
    public Student createStudent(StudentDto dto) {
        logger.info("create student in service layer");
        Student student = studentMapper.toEntity(dto);
        Student result = this.studentRepository.save(student);
        StudentDto studentDto = studentMapper.toDto(result);
        this.redisStudentRepository.save(studentDto);
        return result;
    }

    @Override
    @CachePut(value = "student", key = "#dto.id")
    public Student updateStudent(StudentDto dto) throws Exception {
        logger.info("update student in service layer");

        if(StringUtils.isEmpty(dto.getId())){
            throw new Exception("field id required");
        }

        Student student = studentMapper.toEntity(dto);
        return this.studentRepository.save(student);
    }

    @Cacheable(value = "student", key = "#id")
    @Override
    public StudentDto findOne(Long id) {
        logger.info("find student in service layer id: {}", id);

        Optional<Student> student = this.studentRepository.findById(id);
        return student.map(value -> studentMapper.toDto(value)).orElse(null);
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
