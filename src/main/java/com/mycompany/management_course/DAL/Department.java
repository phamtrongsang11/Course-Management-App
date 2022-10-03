/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

public class Department {

    private String Name, StartDate;
    private int DepartmentID, Administrator;
    private double Budget;

    public Department() {

    }

    public Department(int DepartmentID, String Name, double Budget, String StartDate, int Administrator) {
        this.Name = Name;
        this.StartDate = StartDate;
        this.DepartmentID = DepartmentID;
        this.Administrator = Administrator;
        this.Budget = Budget;
    }

    @Override
    public String toString() {
        return "Department{" + "Name=" + Name + ", StartDate=" + StartDate + ", DepartmentID=" + DepartmentID + ", Administrator=" + Administrator + ", Budget=" + Budget + '}';
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public int getDepartmentID() {
        return DepartmentID;
    }

    public void setDepartmentID(int DepartmentID) {
        this.DepartmentID = DepartmentID;
    }

    public int getAdministrator() {
        return Administrator;
    }

    public void setAdministrator(int Administrator) {
        this.Administrator = Administrator;
    }

    public double getBudget() {
        return Budget;
    }

    public void setBudget(double Budget) {
        this.Budget = Budget;
    }

}
