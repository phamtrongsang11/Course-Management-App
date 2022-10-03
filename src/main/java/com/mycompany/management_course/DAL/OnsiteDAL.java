/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author phamt
 */
public class OnsiteDAL extends CourseDAL {

    public OnsiteDAL() {
        super();
        this.connectDB();
    }

    public ArrayList<OnsiteCourse> readAllOnlineCourse() throws SQLException {
        ArrayList<Course> courseList = this.readCourse();
        ArrayList<OnsiteCourse> onsList = new ArrayList<>();
        for (Course course : courseList) {
            String query = "SELECT * FROM onsitecourse WHERE CourseID = '" + course.getCourseID() + "'";
            ResultSet rs = this.doReadQuery(query);
            if (rs.next()) {
                OnsiteCourse ons = new OnsiteCourse(course.getCourseID(), course.getTitle(), course.getCredits(), course.getDepartmentID(), rs.getString("Location"), rs.getString("Days"), rs.getString("Time"));
                onsList.add(ons);
            }

        }
        return onsList;
    }

    /*

    public OnsiteCourse readOnsiteCourseByID(int id) throws SQLException {
        OnsiteCourse ons = null;
        String query = "SELECT * FROM onsitecourse WHERE CourseID = '" + id + "'";
        ResultSet rs = this.doReadQuery(query);
        if (rs.next()) {
            ons = new OnsiteCourse(rs.getInt("CourseID"), rs.getString("Location"), rs.getString("Days"), rs.getString("Time"));

        }
        return ons;
    }
     */
    public int insertOnsite(OnsiteCourse ons) throws SQLException {
        int result = 0;
        if (this.insertCourse(ons) > 0) {
            String query = "INSERT INTO onsitecourse VALUES (?, ?, ?, ?)";
            PreparedStatement p = this.getConnection().prepareStatement(query);
            p.setInt(1, ons.getCourseID());
            p.setString(2, ons.getLocation());
            p.setString(3, ons.getDays());
            p.setString(4, ons.getTime());
            result = p.executeUpdate();
        }
        return result;
    }

    public int updateOnsite(OnsiteCourse ons) throws SQLException {
        int result = 0;
        if (this.updateCourse(ons) > 0) {
            String query = "UPDATE onsitecourse SET Location = ?, Days = ?, Time = ? WHERE CourseID = ?";
            PreparedStatement p = this.getConnection().prepareStatement(query);
            p.setString(1, ons.getLocation());
            p.setString(2, ons.getDays());
            p.setString(3, ons.getTime());
            p.setInt(4, ons.getCourseID());
            result = p.executeUpdate();
        }
        return result;
    }

    public int deleteOnsite(int id) throws SQLException {

        String query = "DELETE FROM onsitecourse WHERE CourseID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, id);
        int result = p.executeUpdate();
        if (result > 0) {
            this.deleteCourse(id);
        }

        return result;
    }
}
