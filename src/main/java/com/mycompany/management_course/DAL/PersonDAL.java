/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACER
 */
public class PersonDAL extends MyDatabaseManager {

    public PersonDAL() {
        super();
        this.connectDB();
    }

    public ArrayList<Person> readStudent() throws SQLException {
        ArrayList<Person> studentList = new ArrayList<>();
        String Query = "Select * From person Where EnrollmentDate>0";

        ResultSet rs = this.doReadQuery(Query);
        if (rs != null) {
            while (rs.next()) {
                Person student = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getDate("EnrollmentDate"));
                studentList.add(student);
            }
        }

        return studentList;
    }

    public Person readStudentByID(int id) throws SQLException {
        Person student = new Person();
        String Query = "Select * from person Where EnrollmentDate>0 and PersonID = '" + id + "'";

        ResultSet rs = this.doReadQuery(Query);
        if (rs != null) {
            if (rs.next()) {
                student = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getDate("EnrollmentDate"));

            }
        }

        return student;
    }

    public ArrayList<Person> readTeacher() throws SQLException {
        ArrayList<Person> teacherList = new ArrayList<>();
        String Query = "Select * From person Where HireDate>0";

        ResultSet rs = this.doReadQuery(Query);
        if (rs != null) {
            while (rs.next()) {
                Person teacher = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getDate("HireDate"));
                teacherList.add(teacher);
            }
        }

        return teacherList;
    }

    public int insertStudent(Person Student) throws SQLException {

        String Query = "INSERT INTO `person`(`Lastname`, `Firstname`, `EnrollmentDate`) VALUES (?,?,?)";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(Query);
        preparedStatement.setString(1, Student.getLastName());
        preparedStatement.setString(2, Student.getFirstName());
        preparedStatement.setDate(3, (Date) Student.getDate());
        int re = preparedStatement.executeUpdate();

        return re;
    }

    public int insertTeacher(Person Teacher) throws SQLException {

        String Query = "INSERT INTO `person`(`Lastname`, `Firstname`, `HireDate`) VALUES (?,?,?)";
        PreparedStatement preparedStatement = this.getConnection().prepareStatement(Query);
        preparedStatement.setString(1, Teacher.getLastName());
        preparedStatement.setString(2, Teacher.getFirstName());
        preparedStatement.setDate(3, (Date) Teacher.getDate());
        int re = preparedStatement.executeUpdate();

        return re;
    }

    public int updatePerson(Person s) throws SQLException {
        String query = "Update Person SET FirstName = ? , LastName = ? " + " WHERE PersonID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setString(1, s.getFirstName());
        p.setString(2, s.getLastName());
        p.setInt(3, s.getPersonID());
        int result = p.executeUpdate();
        return result;
    }

    public int deleteStudent(int personID) throws SQLException {
        String query = "DELETE FROM Person WHERE PersonID = ?";
        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setInt(1, personID);
        int result = p.executeUpdate();
        return result;
    }

    public ArrayList<Person> findStudent(String name) throws SQLException {
        ArrayList<Person> studentList = new ArrayList<>();
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ? and EnrollmentDate>0";

        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setString(1, "%" + name + "%");
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Person student = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getDate("EnrollmentDate"));
                studentList.add(student);
            }
        }

        return studentList;
    }

    public ArrayList<Person> findTeacher(String name) throws SQLException {
        ArrayList<Person> teacherList = new ArrayList<>();
        String query = "SELECT * FROM Person WHERE concat(FirstName, ' ', LastName)  LIKE ? and HireDate>0";

        PreparedStatement p = this.getConnection().prepareStatement(query);
        p.setString(1, "%" + name + "%");
        ResultSet rs = p.executeQuery();
        if (rs != null) {
            while (rs.next()) {
                Person student = new Person(rs.getInt("PersonID"), rs.getString("Lastname"), rs.getString("Firstname"), rs.getDate("HireDate"));
                teacherList.add(student);
            }
        }

        return teacherList;
    }

    public static void main(String[] args) {
        PersonDAL p = new PersonDAL();
        /*Date date=new Date(2001-1900,07, 22);
        PersonDTO stu=new PersonDTO("Khanh", "Duy",date);
        try {
        p.insertStudent(stu);
        } catch (SQLException ex) {
        Logger.getLogger(PersonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        PersonDTO stu=new PersonDTO("Khanh", "Duycute",38);
        try {
        p.updatePerson(stu);
        } catch (SQLException ex) {
        Logger.getLogger(PersonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        //System.out.println(p.findStudent("Car").toString());
        /*PersonDTO stu=new PersonDTO("Li", "Ya",6);
        try {
            p.updatePerson(stu);
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
         */
    }

}
