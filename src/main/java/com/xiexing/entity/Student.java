/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Student
 * Author:   com.xiexing
 * Date:     2018/11/7 20:52
 * Description:
 */
package com.xiexing.entity;

public class Student {

    private String studentName;
    private Integer studentAge;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                '}';
    }
}