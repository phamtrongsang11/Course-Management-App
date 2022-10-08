/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BLL;

import com.mycompany.management_course.DAL.CourseIntructor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.management_course.DAL.CourseIntructorDAL;

/**
 *
 * @author Administrator
 */
public class CourseIntructorBLL {
    private CourseIntructorDAL courseintructorDAL = new CourseIntructorDAL();
    private ArrayList<CourseIntructor> courseintructorList = new ArrayList<>();
    
    
    public ArrayList<CourseIntructor> readcourseintructor()
    {
        try {
            courseintructorList = courseintructorDAL.readCourseIntructor();
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    
    public int getSizeList(){
        return courseintructorList.size();
    }
    
    
    public ArrayList<CourseIntructor> ReadByCourseByNumPage(int page, int numRecord, String Title) throws SQLException {
       
        courseintructorList = this.searchCourse(Title);
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;
        
        
        return new ArrayList<CourseIntructor>(courseintructorList.subList(startRecord, Math.min(endRecord, courseintructorList.size())));

    }
    
    
    public ArrayList<CourseIntructor> ReadByPersonByNumPage(int page, int numRecord, String name) throws SQLException {
       
        courseintructorList = this.searchPerson(name);
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;
        
        
        return new ArrayList<CourseIntructor>(courseintructorList.subList(startRecord, Math.min(endRecord, courseintructorList.size())));

    }
    
    
    public ArrayList<CourseIntructor> ReadCourseIntructorByNumPage(int page, int numRecord) throws SQLException {
       
        courseintructorList = this.readcourseintructor();
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;
        
        
        return new ArrayList<CourseIntructor>(courseintructorList.subList(startRecord, Math.min(endRecord, courseintructorList.size())));

    }
    
    
    public ArrayList<CourseIntructor> searchPerson(String name)
    {
        try {
            courseintructorList = courseintructorDAL.searchPerson(name);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    
    public ArrayList<CourseIntructor> searchCourse(String name)
    {
        try {
            courseintructorList = courseintructorDAL.searchCourse(name);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    
    public ArrayList<CourseIntructor> readAllTeacher()
    {
        try {
            courseintructorList = courseintructorDAL.readAllTeacher();
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    public ArrayList<CourseIntructor> chooseTeacherforcourse(int courseID)
    {
        try {
            courseintructorList = courseintructorDAL.chooseTeacherforCourse(courseID);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    public ArrayList<CourseIntructor> readALLTitle()
    {
        try {
            courseintructorList = courseintructorDAL.readAllTitle();
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    
    public int getIDbyTitle(String Title)
    {
        int result = 0;
        try {
            result = courseintructorDAL.getIDbyTitle(Title);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public ArrayList<CourseIntructor> chooseTeacherForCourse(int courseID)
    {
        try {
            courseintructorList = courseintructorDAL.chooseTeacherforCourse(courseID);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courseintructorList;
    }
    
    public int insertCourseIntructor(CourseIntructor courseintructor) {
        int result = 0;
        try {
            result = courseintructorDAL.insertCourseIntructor(courseintructor);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public int updateCourseIntructor(CourseIntructor courseintructor, int a) {
        int result = 0;
        try {
            result = courseintructorDAL.updateCourseIntructor(courseintructor, a);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    
    public int deleteCourseIntructor(int courseID, int personID) {
        int result = 0;
        try {
            result = courseintructorDAL.deleteCourseIntructor(courseID, personID);
        } catch (SQLException ex) {
            Logger.getLogger(CourseIntructorBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
