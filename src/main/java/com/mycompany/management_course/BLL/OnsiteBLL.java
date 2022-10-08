/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BLL;

import com.mycompany.management_course.DAL.Course;
import com.mycompany.management_course.DAL.OnsiteCourse;
import com.mycompany.management_course.DAL.OnsiteDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamt
 */
public class OnsiteBLL {

    private ArrayList<OnsiteCourse> onsList = new ArrayList<>();
    private OnsiteDAL onsDAL = new OnsiteDAL();

    public OnsiteBLL() {

    }

    /*
    public OnsiteCourse readOnsiteCourseByID(int id){
        OnsiteCourse ons = null;
        try {
            ons = onsDAL.readOnsiteCourseByID(id);
        } catch (SQLException ex) {
            Logger.getLogger(CourseBUS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ons;
    }
     */
    public ArrayList<OnsiteCourse> readAllOnsiteCourse() throws SQLException {

        onsList = onsDAL.readAllOnlineCourse();

        return onsList;
    }

    public int insertOnsite(OnsiteCourse ons) throws SQLException {
        return onsDAL.insertOnsite(ons);
    }

    public int updateOnsite(OnsiteCourse ons) throws SQLException {
        return onsDAL.updateOnsite(ons);
    }

    public int deleteOnsite(int id) throws SQLException {
        return onsDAL.deleteOnsite(id);
    }

    public ArrayList<OnsiteCourse> findOnsite(String title) throws SQLException {
        //onsList = this.readAllOnsiteCourse();
        ArrayList<OnsiteCourse> result = new ArrayList<>();

        for (OnsiteCourse c : onsList) {
            if (c.getTitle().toLowerCase().indexOf(title.toLowerCase()) >= 0) {
                result.add(c);
            }
        }
        return result;

    }

    public int getSizeList() {
        return onsList.size();
    }
    
    public ArrayList<OnsiteCourse> getOnsiteList(){
        return this.onsList;
    }

    public ArrayList<OnsiteCourse> ReadOnsiteByNumPage(ArrayList<OnsiteCourse> onsList, int page, int numRecord) throws SQLException {

        //onsList = this.readAllOnsiteCourse();
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;

        return new ArrayList<OnsiteCourse>(onsList.subList(startRecord, Math.min(endRecord, onsList.size())));

    }
}
