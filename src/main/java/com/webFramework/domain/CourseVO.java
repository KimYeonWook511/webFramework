package com.webFramework.domain;

public class CourseVO {
    private int courseNo;
    private String courseName;

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "CourseVO{" +
                "courseNo=" + courseNo +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
