/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BLL;

import com.mycompany.management_course.DAL.Department;
import com.mycompany.management_course.DAL.DepartmentDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamt
 */
public class DepartmentBLL {
    private DepartmentDAL depDAL = new DepartmentDAL();
    private static ArrayList<Department> depList = new ArrayList<Department>();
    
    public ArrayList<Department> readDepartment(){
        try {
            depList = depDAL.readDepartment();
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return depList;
    }
    
    public Department readDepartmentByID(int id){
        Department de = new Department();
        try {
            de = depDAL.readDepartmentByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentBLL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return de;
    }
    
    public ArrayList<Department> finDepartmentByName(String name){
        ArrayList<Department> result = new ArrayList<>();
        for(Department dep : depList){
            if(dep.getName().toLowerCase().indexOf(name.toLowerCase()) >= 0){
                result.add(dep);
            }
        }
        return result;
    }
    
   
}
