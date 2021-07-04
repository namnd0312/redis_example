package nam.nd.redisexample.repositories;

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
public class RedisUserRepository {
    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    private static final String STUDENT_TABLE = "student";

    public RedisUserRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Student user){
        hashOperations.put(STUDENT_TABLE, user.getId(), user);
    }
    public List findAll(){
        return hashOperations.values(STUDENT_TABLE);
    }

    public Student findById(String id){
        return (Student) hashOperations.get(STUDENT_TABLE, id);
    }

    public void update(Student student){
        save(student);
    }

    public void delete(String id){
        hashOperations.delete(STUDENT_TABLE, id);
    }

}
