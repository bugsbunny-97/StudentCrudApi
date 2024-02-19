package com.springbootcrud.student.studentService;

import com.springbootcrud.student.model.Teacher;
import com.springbootcrud.student.studentRepository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher) {
        try{
            return teacherRepository.save(new Teacher(teacher.getTeacherName(), teacher.getTeacherSubject()));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
