/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

/**
 *
 * @author Administrator
 */
public class CourseIntructor {
    private int CourseID, PersonID, Credits;

    public int getCredits() {
        return Credits;
    }

    public String getTitle() {
        return Title;
    }

    public String getLastname() {
        return Lastname;
    }
    private String Title,Lastname, Firstname;

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setCredits(int Credits) {
        this.Credits = Credits;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }
    public CourseIntructor(String Lastname, String Firstname, int PersonID)
    {
        this.Lastname = Lastname;
        this.Firstname = Firstname;
        this.PersonID = PersonID;
    }
    public CourseIntructor(String Title)
    {
        this.Title = Title;
    }
    public CourseIntructor(int CourseID, int PersonID, String Title, String Lastname, String Firstname) {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
        this.Title = Title;
        this.Lastname = Lastname;
        this.Firstname = Firstname;
    }
    

    public void setCourseID(int CourseID) {
        this.CourseID = CourseID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public int getCourseID() {
        return CourseID;
    }

    public int getPersonID() {
        return PersonID;
    }
    
    public CourseIntructor(){
        
    }
    
    public CourseIntructor(int CourseID, int PersonID)
    {
        this.CourseID = CourseID;
        this.PersonID = PersonID;
    }

    @Override
    public String toString() {
        return "CourseIntructor{" + "CourseID=" + CourseID + ", PersonID=" + PersonID + ", Credits=" + Credits + ", Title=" + Title + ", Lastname=" + Lastname + ", Firstname=" + Firstname + '}';
    }
    
}
