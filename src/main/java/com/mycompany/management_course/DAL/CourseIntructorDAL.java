/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.management_course.DAL;

import com.mycompany.management_course.DAL.MyDatabaseManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author Administrator
 */
public class CourseIntructorDAL extends MyDatabaseManager{
    public CourseIntructorDAL()
    {
        super();
        this.connectDB();
    }
    public ArrayList<CourseIntructor> readCourseIntructor() throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "SELECT courseinstructor.CourseID, Title, Credits, courseinstructor.PersonID , Lastname, Firstname FROM person, course, courseinstructor WHERE courseinstructor.CourseID=course.CourseID AND courseinstructor.PersonID=person.PersonID";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getInt("CourseID"), rs.getInt("PersonID"), rs.getString("Title"), rs.getString("Lastname"), rs.getString("Firstname"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    
    public ArrayList<CourseIntructor> readAllTeacher() throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "select * from person";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getString("Lastname"), rs.getString("Firstname"), rs.getInt("PersonID"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    
    public ArrayList<CourseIntructor> searchPerson(String name) throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "SELECT * FROM `courseinstructor`,`person`,`course` WHERE person.PersonID=courseinstructor.PersonID and course.CourseID=courseinstructor.CourseID and concat(person.Firstname,'',person.Lastname) LIKE '%"+name+"%'";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getInt("CourseID"), rs.getInt("PersonID"), rs.getString("Title"), rs.getString("Lastname"), rs.getString("Firstname"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    
    public ArrayList<CourseIntructor> searchCourse(String name) throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "SELECT * FROM `courseinstructor`,`person`,`course` WHERE person.PersonID=courseinstructor.PersonID and course.CourseID=courseinstructor.CourseID and course.Title LIKE '%"+name+"%'";
       
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getInt("CourseID"), rs.getInt("PersonID"), rs.getString("Title"), rs.getString("Lastname"), rs.getString("Firstname"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    public ArrayList<CourseIntructor> chooseTeacherforCourse(int CourseID) throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "SELECT Lastname, Firstname, PersonID FROM person WHERE person.HireDate IS NOT NULL AND person.PersonID NOT IN (SELECT courseinstructor.PersonID FROM courseinstructor WHERE courseinstructor.CourseID='"+CourseID+"')";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getString("Lastname"), rs.getString("Firstname"), rs.getInt("PersonID"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    
    public ArrayList<CourseIntructor> readAllTitle() throws SQLException
    {
        ArrayList<CourseIntructor> courseIntructorList = new ArrayList<>();
        String query = "SELECT  Title FROM course ";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            CourseIntructor course = new CourseIntructor(rs.getString("Title"));
            courseIntructorList.add(course);
        }
        return courseIntructorList;
    }
    
    
    public int getIDbyTitle(String Title) throws SQLException
    {
        int id = 0;
        String query = "SELECT CourseID from course WHERE Title = '"+Title+"' ";
        ResultSet rs = this.doReadQuery(query);
        if(rs.next()){
            id = rs.getInt("CourseID");
        }
        return id;
    }
    
    
    
    public int updateCourseIntructor(CourseIntructor courseIntructor, int oddPersonID) throws SQLException {

        String query = "UPDATE `courseinstructor` SET `PersonID` = ? WHERE `courseinstructor`.`CourseID` = ? AND `courseinstructor`.`PersonID` = '"+oddPersonID+"';";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseIntructor.getPersonID());
        p.setInt(2, courseIntructor.getCourseID());
        int result = p.executeUpdate();
        return result;
    }
    
    public int insertCourseIntructor(CourseIntructor courseIntructor) throws SQLException {

        
        String query = "INSERT courseinstructor(CourseID , PersonID) VALUES (?, ?)";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseIntructor.getCourseID());
        p.setInt(2, courseIntructor.getPersonID());
        int result = p.executeUpdate();
        return result;
    }
    
    
    public int deleteCourseIntructor(int courseID, int personID) throws SQLException {
        
        String query = "DELETE FROM courseinstructor WHERE CourseID = ? AND PersonID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        p.setInt(2, personID);
        int result = p.executeUpdate();
        return result;
    }
    public static void main(String[] args) throws SQLException {
        CourseIntructorDAL a = new CourseIntructorDAL();
        System.out.println(a.readCourseIntructor().toString());
    }
    
}
