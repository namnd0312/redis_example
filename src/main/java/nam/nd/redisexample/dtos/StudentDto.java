package nam.nd.redisexample.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author nam.nd
 * @created 04/07/2021 - 9:24 PM
 */

@Getter
@Setter
public class StudentDto implements Serializable {

    private String id;

    private String name;

    private String age;

    private String address;

    private String phone;

    private String email;

    private String classId;

    private String timeUpdate;

}
