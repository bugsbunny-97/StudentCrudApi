package com.springbootcrud.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long studentId;

    @Column(name = "Name")
    private String studentName;

    @Column(name = "DOB")
    private String dateOfBirth;

    @Column(name = "City")
    private String studentCity;

    @Column(name = "Department")
    private String studentDepartment;

    public Student(){
    }

    public Student(String studentName, String dateOfBirth, String studentCity, String studentDepartment, Teacher teacher) {
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.studentCity = studentCity;
        this.studentDepartment = studentDepartment;
        this.teacher = teacher;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId")
    private Teacher teacher;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", studentCity='" + studentCity + '\'' +
                ", studentDepartment='" + studentDepartment + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
