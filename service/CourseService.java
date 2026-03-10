package academiaDev.service;

import academiaDev.model.*;
import java.util.*;

public class CourseService {
    private Map<String, Course> courses;
    public CourseService(Map<String, Course> courses){
    this.courses = courses;
    }
    public void changeStatus(String title, CourseStatus status){
        Course c = courses.get(title);

        if(c != null){
            c.setStatus(status);
        }
    }

    public Collection<Course> listCourses(){
        return courses.values();
    }
}

