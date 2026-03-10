package academiaDev.service;

import academiaDev.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class ReportService {

    public List<Course> coursesByDifficulty(List<Course> courses, String level){

        return courses.stream()
                .filter(c -> c.getDifficultyLevel() .name().equalsIgnoreCase(level))
                .sorted(Comparator.comparing(Course::getTitle))
                .collect(Collectors.toList());
    }

    public Set<String> uniqueInstructors(List<Course> courses){

        return courses.stream()
                .filter(c -> c.getStatus() == CourseStatus.ACTIVE)
                .map(Course::getInstructorName)
                .collect(Collectors.toSet());
    }

    public Optional<Student> topStudent(List<Student> students){

        return students.stream()
                .max(Comparator.comparing(s -> s.getEnrollments().size()));
    }
}