package academiaDev.plan;

public class BasicPlan implements SubscriptionPlan {
    @Override
    public boolean canEnroll(int activeEnrollments){
        return activeEnrollments <3;
    }
}