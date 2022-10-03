/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

import java.sql.Date;

/**
 *
 * @author ACER
 */
public class Person {

    private int PersonID;
    private String lastName, firstName;
    private Date Date;

    public Person() {

    }

    public Person(String lastName, String firstName, Date Date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Date = Date;
    }

    public Person(String lastName, String firstName, int PersonID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.PersonID = PersonID;
    }

    public Person(int personID, String lastName, String firstName, Date Date) {
        this.PersonID = personID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.Date = Date;
    }

    public int getPersonID() {
        return PersonID;
    }

    public void setPersonID(int PersonID) {
        this.PersonID = PersonID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "lastName=" + lastName + ", firstName=" + firstName + ", Date=" + Date + '}';
    }

}
