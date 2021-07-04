package nam.nd.redisexample.repositories.redis;

import nam.nd.redisexample.dtos.StudentDto;
import nam.nd.redisexample.models.Student;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nam.nd
 * @created 04/07/2021 - 7:23 PM
 */

@Repository
public class RedisStudentRepository {
    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    private static final String STUDENT_TABLE = "student";

    public RedisStudentRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(StudentDto user){
        hashOperations.put(STUDENT_TABLE, user.getId(), user);
    }

    public List<StudentDto> findAll(){
        return hashOperations.values(STUDENT_TABLE);
    }

    public Student findById(String id){
        return (Student) hashOperations.get(STUDENT_TABLE, id);
    }

    public void update(StudentDto student){
        save(student);
    }

    public void delete(String id){
        hashOperations.delete(STUDENT_TABLE, id);
    }

}
