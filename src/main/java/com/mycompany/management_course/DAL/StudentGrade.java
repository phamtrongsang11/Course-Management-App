/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

/**
 *
 * @author huynh
 */
public class StudentGrade {
    private int Enrollment, CourseID, StudentID;
    private double Grade;

    public StudentGrade(int CourseID, int StudentID, double Grade) {
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }

    public int getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(int Enrollment) {
        this.Enrollment = Enrollment;
    }

    public int getCourseID() {
        return CourseID;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public int getStudentID() {
        return StudentID;
    }

    public void setStudentID(int StudentID) {
        this.StudentID = StudentID;
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double Grade) {
        this.Grade = Grade;
    }

    public StudentGrade(int Enrollment, int CourseID, int StudentID, double Grade) {
        this.Enrollment = Enrollment;
        this.CourseID = CourseID;
        this.StudentID = StudentID;
        this.Grade = Grade;
    }

    public StudentGrade() {
    }

    @Override
    public String toString() {
        return "StudentGradeDAL{" + "Enrollment=" + Enrollment + ", CourseID=" + CourseID + ", StudentID=" + StudentID + ", Grade=" + Grade + '}';
    }
    
    
}
