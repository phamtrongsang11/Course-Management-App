package com.mycompany.management_course.DAL;

public class Course {

    private String Title;
    private int CourseID, Credits, DepartmentID;

    public Course() {

    }

    public Course(int CourseID, String Title, int Credits, int DepartmentID) {
        this.Title = Title;
        this.CourseID = CourseID;
        this.Credits = Credits;
        this.DepartmentID = DepartmentID;
    }
    

    public String getTitle() {
        return Title;
    }

    public int getCourseID() {
        return CourseID;
    }

    public int getCredits() {
        return Credits;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    @Override
    public String toString() {
        return "Course{" + "Title=" + Title + ", CourseID=" + CourseID + ", Credits=" + Credits + ", DepartmentID=" + DepartmentID + '}';
    }

}
