package nam.nd.redisexample.schedules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nam.nd.redisexample.dtos.StudentDto;
import nam.nd.redisexample.repositories.redis.RedisStudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nam.nd
 * @created 04/07/2021 - 10:01 PM
 */


@Component
@EnableScheduling
public class StudentSchedule {

    private static final Logger log = LoggerFactory.getLogger(StudentSchedule.class);

    @Autowired
    private RedisStudentRepository studentRepository;

    @Scheduled(fixedRate = 60000)
    private void process() throws JsonProcessingException {
        List<StudentDto> result = this.studentRepository.findAll();

        ObjectMapper mapper = new ObjectMapper();

        if(!result.isEmpty()){
            String dtos = mapper.writeValueAsString(result);
            log.info("schedule: ===========> {}", dtos);
        }
    }
}
