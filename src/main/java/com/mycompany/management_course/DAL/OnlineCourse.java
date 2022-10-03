/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

/**
 *
 * @author phamt
 */
public class OnlineCourse extends Course {

    private String url;

    public OnlineCourse() {

    }

    public OnlineCourse(String url) {
        this.url = url;
    }

    public OnlineCourse(int CourseID, String Title, int Credits, int DepartmentID, String url) {
        super(CourseID, Title, Credits, DepartmentID);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "OnlineCourse{" + "url=" + url + '}';
    }

}
