package nam.nd.redisexample.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:37 PM
 */

@Entity
@Getter
@Setter
@Data
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer age;

    private String address;

    private String phone;

    private String email;

    private Long classId;
}
