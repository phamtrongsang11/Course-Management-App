/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BLL;

import com.mycompany.management_course.DAL.Person;
import com.mycompany.management_course.DAL.PersonDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ACER
 */
public class PersonBLL {

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

        return personDAL.insertStudent(Student);
    }

    public int insertTeacher(Person Teacher) throws SQLException {

        return personDAL.insertTeacher(Teacher);
    }

    public int updatePerson(Person Person) throws SQLException {

        return personDAL.updatePerson(Person);
    }

    public int deleteStudent(int id) throws SQLException {

        return personDAL.deleteStudent(id);
    }

    public ArrayList<Person> findStudent(String name) throws SQLException {
        return personDAL.findStudent(name);
    }

    public ArrayList<Person> findTeacher(String name) throws SQLException {
        return personDAL.findTeacher(name);
    }

    public ArrayList<Person> loadStudent(int page) throws SQLException {
        personList = this.readStudent();
        int startRecord = (page - 1) * 5;
        int endRecord = page * 5;
        return new ArrayList<Person>(personList.subList(startRecord, Math.min(endRecord, personList.size())));
    }

    public ArrayList<Person> loadTeacher(int page) throws SQLException {
        personList = this.readTeacher();
        int startRecord = (page - 1) * 5;
        int endRecord = page * 5;
        return new ArrayList<Person>(personList.subList(startRecord, Math.min(endRecord, personList.size())));
    }
}
