package com.mycompany.management_course.DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phamt
 */
public class CourseDAL extends MyDatabaseManager {

    public CourseDAL() {
        super();
        this.connectDB();
    }

    public ArrayList<Course> readCourse() throws SQLException {
        ArrayList<Course> courseList = new ArrayList<>();
        String query = "SELECT * FROM course";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            Course course = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"));
            courseList.add(course);
        }
        return courseList;
    }

    public Course readCourseByID(int id) throws SQLException {
        Course course = null;
        String query = "SELECT * FROM course WHERE CourseID = '" + id + "'";
        ResultSet rs = this.doReadQuery(query);
        if (rs.next()) {
            course = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"));

        }
        return course;
    }

    public int updateCourse(Course course) throws SQLException {

        String query = "UPDATE course SET Title = ?, Credits = ?, DepartmentID = ? WHERE CourseID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setString(1, course.getTitle());
        p.setInt(2, course.getCredits());
        p.setInt(3, course.getDepartmentID());
        p.setInt(4, course.getCourseID());
        int result = p.executeUpdate();
        return result;
    }

    public int insertCourse(Course course) throws SQLException {

        String query = "INSERT course VALUES (?, ?, ?, ?)";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, course.getCourseID());
        p.setString(2, course.getTitle());
        p.setInt(3, course.getCredits());
        p.setInt(4, course.getDepartmentID());
        int result = p.executeUpdate();
        return result;
    }

    /*
    public ArrayList<Course> findCourse(String title) throws SQLException {
        ArrayList courseList = new ArrayList<>();
        String query = "SELECT * FROM course WHERE Title LIKE ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setString(1, title);
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Course course = new Course(rs.getInt("CourseID"), rs.getString("Title"), rs.getInt("Credits"), rs.getInt("DepartmentID"));
                courseList.add(course);

            }
        } else {
            System.out.println("Not found any course match your name");
        }
        return courseList;

    }
     */
    public int deleteCourse(int courseID) throws SQLException {

        String query = "DELETE FROM course WHERE CourseID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, courseID);
        int result = p.executeUpdate();
        return result;
    }

    public int getLastID() throws SQLException {
        int id = 0;
        String query = "SELECT CourseID FROM course ORDER BY CourseID DESC LIMIT 1";
        ResultSet rs = this.doReadQuery(query);
        if (rs.next()) {
            id = rs.getInt("CourseID");
        }
        return id;
    }
}
