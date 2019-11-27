/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Teacher
 * Author:   com.xiexing
 * Date:     2018/11/7 20:52
 * Description:
 */
package com.xiexing.entity;

import java.util.List;

public class Teacher {

    private String teacherName;
    private Integer teacherAge;
    private Course course;
    private List<Student> students;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Integer getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(Integer teacherAge) {
        this.teacherAge = teacherAge;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}