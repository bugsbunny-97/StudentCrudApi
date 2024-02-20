package com.springbootcrud.student.studentController;

import com.springbootcrud.student.model.Teacher;
import com.springbootcrud.student.studentService.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    TeacherService teacherService;
    @PostMapping("/teacher")
    public ResponseEntity<String> createTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.createTeacher(teacher), HttpStatus.CREATED);
    }

    @GetMapping("/teacher/{teacherId}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable long teacherId){
        Optional<Teacher> teacher = teacherService.getTeacherById(teacherId);
        if(teacher.isPresent()) {
            return new ResponseEntity<>(teacher.get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher(){
        return new ResponseEntity<>(teacherService.getAllTeacher(),HttpStatus.OK);
    }

    @PutMapping("/teacher/{teacherId}")
    public ResponseEntity<String> updateTeacher(@RequestBody Teacher teacher, @PathVariable long teacherId){
        return new ResponseEntity<>(teacherService.updateTeacher(teacher, teacherId), HttpStatus.OK);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ResponseEntity<String> deleteTeacher(@PathVariable long teacherId){
        return new ResponseEntity<>(teacherService.deleteTeacher(teacherId),HttpStatus.OK);
    }
}
