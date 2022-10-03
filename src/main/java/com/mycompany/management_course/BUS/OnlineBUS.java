/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BUS;

import com.mycompany.management_course.DAL.Course;
import com.mycompany.management_course.DAL.OnlineCourse;
import com.mycompany.management_course.DAL.OnlineDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamt
 */
public class OnlineBUS {

    private ArrayList<OnlineCourse> onlList = new ArrayList<>();
    private OnlineDAL onlDAL = new OnlineDAL();

    public OnlineBUS() {

    }


    /*
    public OnlineCourse readOnlineCourseByID(int id){
        OnlineCourse onl = null;
        try {
             onl = onlDAL.readOnlineCourseByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(CourseBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return onl;
    }*/
    public ArrayList<OnlineCourse> readAllOnlineCourse() throws SQLException {
        onlList = onlDAL.readAllOnlineCourse();
        return onlList;
    }

    public int insertOnline(OnlineCourse onl) throws SQLException {
        return onlDAL.insertOnline(onl);
    }

    public int updateOnline(OnlineCourse onl) throws SQLException {
        return onlDAL.updateOnline(onl);
    }

    public int deleteOnline(int id) throws SQLException {
        return onlDAL.deleteOnline(id);
    }
    
    public int getSizeList(){
        return onlList.size();
    }

    public ArrayList<OnlineCourse> findOnline(String title) throws SQLException {
        //onlList = this.readAllOnlineCourse();
        ArrayList<OnlineCourse> result = new ArrayList<>();

        for (OnlineCourse c : onlList) {
            if (c.getTitle().toLowerCase().indexOf(title.toLowerCase()) >= 0) {
                result.add(c);
            }
        }
        return result;

    }

    public ArrayList<OnlineCourse> ReadOnlineByNumPage(int page, int numRecord) throws SQLException {
       
        onlList = this.readAllOnlineCourse();
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;

        return new ArrayList<OnlineCourse>(onlList.subList(startRecord, Math.min(endRecord, onlList.size())));

    }

}
