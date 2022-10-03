package com.mycompany.management_course.BUS;

import com.mycompany.management_course.DAL.Course;
import com.mycompany.management_course.DAL.CourseDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author phamt
 */
public class CourseBUS {

    private CourseDAL courseDAL = new CourseDAL();
    private static ArrayList<Course> courseList = new ArrayList<>();

    public CourseBUS() {

    }

    public ArrayList<Course> readCourse() throws SQLException {

        courseList = courseDAL.readCourse();

        return courseList;
    }

    public Course readCourseByID(int id) throws SQLException {
        return courseDAL.readCourseByID(id);
    }

    public int insertCourse(Course course) throws SQLException {
        return courseDAL.insertCourse(course);

    }

    public int updateCourse(Course course) throws SQLException {
        return courseDAL.updateCourse(course);

    }

    public int deleteCourse(int courseID) throws SQLException {
        return courseDAL.deleteCourse(courseID);

    }

    public ArrayList<Course> findCourse(String title) {

        ArrayList<Course> result = new ArrayList<>();

        for (Course c : courseList) {
            if (c.getTitle().toLowerCase().indexOf(title.toLowerCase()) >= 0) {
                
                result.add(c);
            }
        }
        return result;

    }

    public int getNewID() throws SQLException {

        return courseDAL.getLastID() + 1;

    }

}
