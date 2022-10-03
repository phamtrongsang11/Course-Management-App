package com.mycompany.management_course.DAL;

public class OnsiteCourse extends Course{

    
    private String Location, Days, Time;
    
    public OnsiteCourse(){
        
    }
    
    public OnsiteCourse(String Location, String Days, String Time) {
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    public OnsiteCourse(int CourseID, String Title, int Credits, int DepartmentID, String Location, String Days, String Time) {
        super(CourseID, Title, Credits, DepartmentID);
        this.Location = Location;
        this.Days = Days;
        this.Time = Time;
    }

    @Override
    public String toString() {
        return "OnsiteCourse{" + "Location=" + Location + ", Days=" + Days + ", Time=" + Time + '}';
    }
    

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getDays() {
        return Days;
    }

    public void setDays(String Days) {
        this.Days = Days;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    
    
   
}
