package com.springbootcrud.student.studentService;

import com.springbootcrud.student.model.Teacher;
import com.springbootcrud.student.studentRepository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public String createTeacher(Teacher teacher) {
        try{
            teacherRepository.save(new Teacher(teacher.getTeacherName(), teacher.getTeacherSubject()));
            return "Teacher created successfully";
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Teacher> getTeacherById(long teacherId){
        try{
            return teacherRepository.findById(teacherId);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Teacher> getAllTeacher() {
        try {
            return teacherRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteTeacher(long teacherId) {
        try{
            if(teacherRepository.findById(teacherId).isPresent()){
                teacherRepository.deleteById(teacherId);
                return "Teacher deleted successfully";
            }
            else{
                return "Teacher does not exist";
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public String updateTeacher(Teacher teacher, long teacherId){
        try{
            Optional<Teacher> existingTeacher = teacherRepository.findById(teacherId);
            if(existingTeacher.isPresent()){
                Teacher newTeacher = existingTeacher.get();
                newTeacher.setTeacherName(teacher.getTeacherName());
                newTeacher.setTeacherSubject(teacher.getTeacherSubject());
                teacherRepository.save(newTeacher);
                return "Teacher updated successfully for Id : "+teacherId;
            }
            else{
                return "Teacher does not exist";
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
