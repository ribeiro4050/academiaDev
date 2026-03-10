package academiaDev.service;

import academiaDev.exception.EnrollmentException;
import academiaDev.model.*;

public class EnrollmentService {

    public void enroll(Student student, Course course){

        if(course.getStatus() != CourseStatus.ACTIVE){
            throw new EnrollmentException("Curso inativo ou com vagas lotadas.");
        }

        int active = student.getEnrollments().size();

        if(!student.getSubscriptionPlan().canEnroll(active)){
            throw new EnrollmentException("Seu plano tem o limite de 3 matrículas, dê um upgrade no plano para contratar mais.");
        }

        boolean already = student.getEnrollments()
                .stream()
                .anyMatch(e -> e.getCourse().equals(course));

        if(already){
            throw new EnrollmentException("O estudante já está matriculado neste curso.");
        }

        Enrollment enrollment = new Enrollment(student, course);

        student.getEnrollments().add(enrollment);
    }
}