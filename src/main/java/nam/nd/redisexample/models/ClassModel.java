package nam.nd.redisexample.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:38 PM
 */

@Entity
@Getter
@Setter
@Data
@Table(name = "class")
public class ClassModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer quantity;

    private Long teacherId;
}
