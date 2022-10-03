/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phamt
 */
public class DepartmentDAL extends MyDatabaseManager {

    public DepartmentDAL() {
        super();
        this.connectDB();
    }

    public ArrayList<Department> readDepartment() throws SQLException {
        ArrayList<Department> deList = new ArrayList<>();
        String query = "SELECT * FROM department";
        ResultSet rs = this.doReadQuery(query);
        while (rs.next()) {
            Department de = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), rs.getString("StartDate"), rs.getInt("Administrator"));
            deList.add(de);
        }
        return deList;
    }
    
    public Department readDepartmentByID(int id) throws SQLException {
        Department de = null;
        String query = "SELECT * FROM department WHERE DepartmentID = '" + id + "'";
        ResultSet rs = this.doReadQuery(query);
        if (rs.next()) {
            de = new Department(rs.getInt("DepartmentID"), rs.getString("Name"), rs.getDouble("Budget"), rs.getString("StartDate"), rs.getInt("Administrator"));
        }
        return de;
    }
    
    
    
}
