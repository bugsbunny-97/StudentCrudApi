package com.springbootcrud.student.model;

public class StudentDTO {
    private String studentName;
    private String dateOfBirth;
    private String studentCity;
    private String studentDepartment;
    private long teacherId;

    public StudentDTO() {
    }

    public StudentDTO(String studentName, String dateOfBirth, String studentCity, String studentDepartment, long teacherId) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.studentCity = studentCity;
        this.studentDepartment = studentDepartment;
        this.teacherId = teacherId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getStudentCity() {
        return studentCity;
    }

    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }

    public String getStudentDepartment() {
        return studentDepartment;
    }

    public void setStudentDepartment(String studentDepartment) {
        this.studentDepartment = studentDepartment;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }
}
