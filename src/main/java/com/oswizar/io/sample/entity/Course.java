
package com.oswizar.io.sample.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Course {

    public static void main(String[] args) {
        Course course = new Course();
        System.out.println(course);
    }

    private String name;
    private Integer code;
    private Boolean isActive;
    private Boolean isFlag;
    private Integer isExist;
    private Integer isEnable;

//    public String getCourseName() {
//        return courseName;
//    }
//
//    public void setCourseName(String courseName) {
//        this.courseName = courseName;
//    }
//
//    public Integer getCode() {
//        return code;
//    }
//
//    public void setCode(Integer code) {
//        this.code = code;
//    }
//
//    public Boolean getStatus() {
//        return status;
//    }
//
//    public void setStatus(Boolean status) {
//        this.status = status;
//    }
//
//    public boolean isFlag() {
//        return flag;
//    }
//
//    public void setFlag(boolean flag) {
//        this.flag = flag;
//    }
//
//    public int getIsEnable() {
//        return isEnable;
//    }
//
//    public void setIsEnable(int isEnable) {
//        this.isEnable = isEnable;
//    }
//
//    public Integer getIsExist() {
//        return isExist;
//    }
//
//    public void setIsExist(Integer isExist) {
//        this.isExist = isExist;
//    }
}
