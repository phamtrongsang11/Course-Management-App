/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phamt
 */
public class OnlineDAL extends CourseDAL {

    public OnlineDAL() {
        super();
        this.connectDB();
    }

    public ArrayList<OnlineCourse> readAllOnlineCourse() throws SQLException {
        ArrayList<Course> courseList = this.readCourse();

        ArrayList<OnlineCourse> onlList = new ArrayList<>();
        for (Course course : courseList) {
            String query = "SELECT * FROM onlinecourse WHERE CourseID = '" + course.getCourseID() + "'";
            ResultSet rs = this.doReadQuery(query);
            if (rs.next()) {
                OnlineCourse onl = new OnlineCourse(course.getCourseID(), course.getTitle(), course.getCredits(), course.getDepartmentID(), rs.getString("url"));
                onlList.add(onl);
            }

        }
        return onlList;
    }

    /*
    public OnlineCourse readOnlineCourseByID(int id) throws SQLException {
        OnlineCourse onl = null;
        String query = "SELECT * FROM onlinecourse WHERE CourseID = '" + id + "'";
        ResultSet rs = this.doReadQuery(query);
        if (rs.next()) {
            onl = new OnlineCourse(rs.getInt("CourseID"), rs.getString("url"));

        }
        return onl;
    }
     */
    public int insertOnline(OnlineCourse onl) throws SQLException {
        int result = 0;
        if (insertCourse(onl) > 0) {
            String query = "INSERT INTO onlinecourse VALUES (?, ?)";
            PreparedStatement p = this.getConnection().prepareStatement(query);
            p.setInt(1, onl.getCourseID());
            p.setString(2, onl.getUrl());
            result = p.executeUpdate();
        }
        return result;
    }

    public int updateOnline(OnlineCourse onl) throws SQLException {
        int result = 0;
        if (this.updateCourse(onl) > 0) {
            String query = "UPDATE onlinecourse SET url = ? WHERE CourseID = ?";
            PreparedStatement p = this.getConnection().prepareStatement(query);
            p.setString(1, onl.getUrl());
            p.setInt(2, onl.getCourseID());
            result = p.executeUpdate();
        }
        return result;
    }

    public int deleteOnline(int id) throws SQLException {

        String query = "DELETE FROM onlinecourse WHERE CourseID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, id);
        int result = p.executeUpdate();
        if (result > 0) {
            this.deleteCourse(id);
        }
        return result;
    }

}
