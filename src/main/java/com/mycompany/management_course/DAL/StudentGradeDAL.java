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
 * @author huynh
 */
public class StudentGradeDAL extends MyDatabaseManager {
    public  StudentGradeDAL() {
        super();
        this.connectDB();
    }
    public ArrayList<StudentGrade> readStudentGrade() throws SQLException {
        ArrayList<StudentGrade> StudentGradeList = new ArrayList<>();
        String query = "SELECT * FROM studentgrade WHERE 1";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            StudentGrade studentgrade = new StudentGrade(rs.getInt("EnrollmentID"), rs.getInt("CourseID"), rs.getInt("StudentID"), rs.getDouble("Grade"));
            StudentGradeList.add(studentgrade);
        }
        return StudentGradeList;
    }
    public int insertStudentGrade(StudentGrade studengrade) throws SQLException {

        
        String query = "INSERT studentgrade(CourseID, StudentID, Grade) VALUES (?, ?, ?)";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, studengrade.getCourseID());
        p.setInt(2, studengrade.getStudentID());
        p.setDouble(3, studengrade.getGrade());
        int result = p.executeUpdate();
        return result;
    }
    public int deleteStudentGrade(int EnrollmentID) throws SQLException {

        String query = "DELETE FROM studentgrade WHERE EnrollmentID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, EnrollmentID);
        int result = p.executeUpdate();
        return result;
    }
    public int updateStudentGrade(StudentGrade student) throws SQLException {

        String query = "UPDATE studentgrade SET CourseID = ?, StudentID = ?, Grade = ? WHERE EnrollmentID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, student.getCourseID());
        p.setInt(2, student.getStudentID());
        p.setDouble(3, student.getGrade());
        p.setDouble(4, student.getEnrollment());
        int result = p.executeUpdate();
        return result;
    }
    public int getLastID() throws SQLException{
        int id = 0;
        String query = "SELECT EnrollmentID FROM studentgrade ORDER BY EnrollmentID DESC LIMIT 1";
        ResultSet rs = this.doReadQuery(query);
        if(rs.next()){
            id = rs.getInt("EnrollmentID");
        }
        return id;
    }
}
