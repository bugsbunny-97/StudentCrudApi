package com.springbootcrud.student.studentController;

import com.springbootcrud.student.model.Student;
import com.springbootcrud.student.model.StudentDTO;
import com.springbootcrud.student.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody StudentDTO studentDTO){
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable long id, @RequestBody StudentDTO studentDTO){
        return ResponseEntity.ok(studentService.updateStudent(id, studentDTO));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id){
        return ResponseEntity.ok(studentService.deleteStudent(id));
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id){
        Optional<Student> student = studentService.getStudentById(id);
        return student.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent(){
        List<Student> student = studentService.getAllStudent();
        if(!student.isEmpty()) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudentByDepartmentOrCity(@RequestParam(required = false) String studentDepartment, @RequestParam(required = false) String studentCity){
        List<Student> student = studentService.getStudentByDepartmentOrCity(studentDepartment,studentCity);
        if(!student.isEmpty()) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{teacherId}")
    public ResponseEntity<List<Student>> getStudentsByTeacherId(@PathVariable long teacherId){
        List<Student> student = studentService.getStudentsByTeacherId(teacherId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }
}