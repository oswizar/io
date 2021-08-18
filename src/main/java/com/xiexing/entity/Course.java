/**
 * Copyright (C): 长安新生(深圳)金融投资有限公司
 * FileName: Course
 * Author:   com.xiexing
 * Date:     2018/11/7 20:53
 * Description:
 */
package com.xiexing.entity;

public class Course {

    private String courseName;
    private Integer code;
    private Boolean status = new Boolean(true);

    private boolean flag;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }


    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
