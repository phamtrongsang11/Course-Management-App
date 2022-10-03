/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BUS;

import com.mycompany.management_course.DAL.Person;
import com.mycompany.management_course.DAL.PersonDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class PersonBUS {

    PersonDAL personDAL = new PersonDAL();
    ArrayList<Person> personList = new ArrayList<>();

    public ArrayList<Person> readStudent() throws SQLException {
        return personDAL.readStudent();
    }

    public Person readStudentByID(int id) throws SQLException {
        return personDAL.readStudentByID(id);
    }

    public ArrayList<Person> readTeacher() throws SQLException {
        return personDAL.readTeacher();
    }

    public int insertStudent(Person Student) throws SQLException {
        JOptionPane.showMessageDialog(null, "Insert complete.");
        return personDAL.insertStudent(Student);
    }

    public int insertTeacher(Person Teacher) throws SQLException {
        JOptionPane.showMessageDialog(null, "Insert complete.");
        return personDAL.insertTeacher(Teacher);
    }

    public int updatePerson(Person Person) throws SQLException {
        JOptionPane.showMessageDialog(null, "Update complete.");
        return personDAL.updatePerson(Person);
    }

    public int deleteStudent(int id) throws SQLException {
        JOptionPane.showMessageDialog(null, "Delete complete.");
        return personDAL.deleteStudent(id);
    }

    public ArrayList<Person> findStudent(String name) throws SQLException {
        return personDAL.findStudent(name);
    }

    public ArrayList<Person> findTeacher(String name) throws SQLException {
        return personDAL.findTeacher(name);
    }
}
