package com.springbootcrud.student.studentService;

import com.springbootcrud.student.model.Student;
import com.springbootcrud.student.model.StudentDTO;
import com.springbootcrud.student.model.Teacher;
import com.springbootcrud.student.studentRepository.StudentRepository;
import com.springbootcrud.student.studentRepository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    TeacherRepository teacherRepository;

    public String createStudent(StudentDTO studentDTO) {
        try {
            Optional<Teacher> optionalTeacher = teacherRepository.findById(studentDTO.getTeacherId());
            if(optionalTeacher.isPresent()) {
                Teacher teacher = optionalTeacher.get();
                studentRepository.save(new Student(studentDTO.getStudentName(), studentDTO.getDateOfBirth(), studentDTO.getStudentCity(),
                        studentDTO.getStudentDepartment(), teacher));
                return "Student created successfully";
            }
            else{
                return "Teacher does not exist for this TeacherId : "+studentDTO.getTeacherId();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String updateStudent(long id, Student student){
        try{
            if(studentRepository.findById(id).isPresent()){
                Student studentExist = studentRepository.findById(id).get();
                studentExist.setStudentName(student.getStudentName());
                studentExist.setDateOfBirth(student.getDateOfBirth());
                studentExist.setStudentCity(student.getStudentCity());
                studentExist.setStudentDepartment(student.getStudentDepartment());
                studentRepository.save(studentExist);
                return "Student updated successfully for: "+id;
            }
            else{
                return "Student does not exist";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String deleteStudent(long id) {
        try {
            if(studentRepository.findById(id).isPresent()){
                studentRepository.deleteById(id);
                return "Student deleted successfully";
            }
            else{
                return "Student does not exist";
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<Student> getStudentById(long id) {
        try {
            return studentRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getAllStudent() {
        try {
            return studentRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Student> getStudentByDepartmentOrCity(String studentDepartment, String studentCity) {
        try {
            if(studentDepartment!=null && studentCity==null){
                return studentRepository.findByStudentDepartment(studentDepartment);
            }
            else if(studentDepartment==null && studentCity!=null){
                return studentRepository.findByStudentCity(studentCity);
            }
            else if(studentDepartment!=null && studentCity!=null){
                return studentRepository.findByStudentDepartmentAndStudentCity(studentDepartment, studentCity);
            }
            else{
                return List.of();
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
