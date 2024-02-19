package com.springbootcrud.student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teacherId")
    private long teacherId;

    @Column(name = "teacherName")
    private String teacherName;

    @Column(name = "teacherSubject")
    private String teacherSubject;

    public Teacher(){

    }

    public Teacher(String teacherName, String teacherSubject) {
        this.teacherName = teacherName;
        this.teacherSubject = teacherSubject;
    }

    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(String teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId=" + teacherId +
                ", teacherName='" + teacherName + '\'' +
                ", teacherSubject='" + teacherSubject + '\'' +
                '}';
    }
}
