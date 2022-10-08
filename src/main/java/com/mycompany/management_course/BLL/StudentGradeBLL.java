/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.management_course.BLL;

import com.mycompany.management_course.DAL.StudentGrade;
import com.mycompany.management_course.DAL.Person;
import com.mycompany.management_course.DAL.Course;
import com.mycompany.management_course.DAL.StudentGradeDAL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huynh
 */
public class StudentGradeBLL {

    private StudentGradeDAL studengradeDAL = new StudentGradeDAL();
    private CourseBLL courseBUS = new CourseBLL();
    private PersonBLL personBUS = new PersonBLL();
    private ArrayList<StudentGrade> gradeList = new ArrayList<>();

    public ArrayList<StudentGrade> readStudentGrade() throws SQLException {

        gradeList = studengradeDAL.readStudentGrade();

        return gradeList;
    }

    public int insertStudentGrade(StudentGrade stu) throws SQLException {

        return studengradeDAL.insertStudentGrade(stu);

    }

    public int deleteStudentGrade(int id) throws SQLException {
        return studengradeDAL.deleteStudentGrade(id);

    }

    public int getNewID() throws SQLException {
        return studengradeDAL.getLastID() + 1;

    }

    public int getLastID() throws SQLException {
        return studengradeDAL.getLastID();

    }

    public int updateStu(StudentGrade stu) throws SQLException {
        return studengradeDAL.updateStudentGrade(stu);

    }

    public ArrayList<StudentGrade> findGradeByCourse(String courseName) throws SQLException {
        ArrayList<StudentGrade> result = new ArrayList<>();
        courseBUS.readCourse();
        ArrayList<Course> courseList = courseBUS.findCourse(courseName);
        for (StudentGrade stu : gradeList) {
            for (int i = 0; i < courseList.size(); i++) {
                if (stu.getCourseID() == courseList.get(i).getCourseID()) {
                    result.add(stu);
                    break;
                }
            }
        }
        return result;
    }

    public ArrayList<StudentGrade> findGradeByStudent(String studentName) throws SQLException {
        ArrayList<StudentGrade> result = new ArrayList<>();
        ArrayList<Person> studentList = personBUS.findStudent(studentName);
        for (StudentGrade stu : gradeList) {
            for (int i = 0; i < studentList.size(); i++) {
                if (stu.getStudentID() == studentList.get(i).getPersonID()) {
                    result.add(stu);
                    break;
                }
            }
        }
        return result;
    }
    
    public ArrayList<StudentGrade> ReadOnsiteByNumPage(ArrayList<StudentGrade> onsList, int page, int numRecord){

        //onsList = this.readAllOnsiteCourse();
        int startRecord = (page - 1) * numRecord;
        int endRecord = page * numRecord;

        return new ArrayList<StudentGrade>(onsList.subList(startRecord, Math.min(endRecord, onsList.size())));

    }

}
