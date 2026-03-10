package academiaDev.util;

import academiaDev.model.*;
import academiaDev.plan.*;

import java.util.*;

public class InitialData {

    public static Map<String, Course> loadCourses(){

        Map<String, Course> courses = new HashMap<>();

        courses.put("Java Básico",
                new Course("Java Básico","Intro Java",
                        "Carlos",20,DifficultyLevel.BEGINNER,CourseStatus.ACTIVE));

        courses.put("Spring Boot",
                new Course("Spring Boot","API REST",
                        "Marina",30,DifficultyLevel.INTERMEDIATE,CourseStatus.ACTIVE));

        courses.put("Arquitetura",
                new Course("Arquitetura","Software Design",
                        "Pedro",40,DifficultyLevel.ADVANCED,CourseStatus.ACTIVE));

        return courses;
    }

    public static Map<String, User> loadUsers(){

        Map<String, User> users = new HashMap<>();

        users.put("admin@email.com",
                new Admin("Administrador","admin@email.com"));

        users.put("aluno@email.com",
                new Student("João","aluno@email.com", new BasicPlan()));

        return users;
    }
}