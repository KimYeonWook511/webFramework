package com.webFramework.domain;

import java.util.Date;

public class LectureVO {
    private int lectureNo;
    private int lectureTeacherNo;
    private String lectureName;
    private String lectureContent;
    private Date lectureOpenDate;
    private int lectureStudentCount;
    private int lectureState;

    public int getLectureNo() {
        return lectureNo;
    }

    public void setLectureNo(int lectureNo) {
        this.lectureNo = lectureNo;
    }

    public int getLectureTeacherNo() {
        return lectureTeacherNo;
    }

    public void setLectureTeacherNo(int lectureTeacherNo) {
        this.lectureTeacherNo = lectureTeacherNo;
    }

    public String getLectureName() {
        return lectureName;
    }

    public void setLectureName(String lectureName) {
        this.lectureName = lectureName;
    }

    public String getLectureContent() {
        return lectureContent;
    }

    public void setLectureContent(String lectureContent) {
        this.lectureContent = lectureContent;
    }

    public Date getLectureOpenDate() {
        return lectureOpenDate;
    }

    public void setLectureOpenDate(Date lectureOpenDate) {
        this.lectureOpenDate = lectureOpenDate;
    }

    public int getLectureStudentCount() {
        return lectureStudentCount;
    }

    public void setLectureStudentCount(int lectureStudentCount) {
        this.lectureStudentCount = lectureStudentCount;
    }

    public int getLectureState() {
        return lectureState;
    }

    public void setLectureState(int lectureState) {
        this.lectureState = lectureState;
    }

    @Override
    public String toString() {
        return "LectureDTO{" +
                "lectureNo=" + lectureNo +
                ", lectureTeacherNo=" + lectureTeacherNo +
                ", lectureName='" + lectureName + '\'' +
                ", lectureContent='" + lectureContent + '\'' +
                ", lectureOpenDate=" + lectureOpenDate +
                ", lectureStudentCount=" + lectureStudentCount +
                ", lectureState=" + lectureState +
                '}';
    }
}
