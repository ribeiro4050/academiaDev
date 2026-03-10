package academiaDev.plan;

public class PremiumPlan implements SubscriptionPlan {

    @Override
    public boolean canEnroll(int activeEnrollments) {
        return true;
    }
}