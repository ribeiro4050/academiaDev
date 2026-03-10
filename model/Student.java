package academiaDev.model;

import academiaDev.plan.SubscriptionPlan;
import java.util.*;

public class Student extends User {
    private SubscriptionPlan subscriptionPlan;
    private List<Enrollment> enrollments = new ArrayList<>();

    public Student(String name, String email, SubscriptionPlan plan){
        super(name, email);
        this.subscriptionPlan = plan;
    }
    public List<Enrollment> getEnrollments() {
        return enrollments;
    }
    public void setSubscriptionPlan(SubscriptionPlan plan){
        this.subscriptionPlan = plan;
    }
    public SubscriptionPlan getSubscriptionPlan(){
        return subscriptionPlan;
    }
}