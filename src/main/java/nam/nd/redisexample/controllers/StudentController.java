package nam.nd.redisexample.controllers;

import nam.nd.redisexample.models.Student;
import nam.nd.redisexample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author nam.nd
 * @created 04/07/2021 - 5:47 PM
 */

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/get-student")
    public ResponseEntity<?> getAllStudents(){
        List<Student> students = studentService.findAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }


    @PostMapping("/create-student")
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        Student student1 = this.studentService.saveStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @PutMapping("/update-student")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        Student student1 = this.studentService.saveStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.OK);
    }

    @GetMapping("/get-student/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id){
        Optional<Student> student = this.studentService.findOne(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }


    @DeleteMapping("/delete-student/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable long id){
         this.studentService.deleteStudentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
