package nam.nd.redisexample.controllers;

import nam.nd.redisexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:47 PM
 */

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


}
