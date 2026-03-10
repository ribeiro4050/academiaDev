package academiaDev.support;

import academiaDev.model.User;

public class SupportTicket {

    private String title;
    private String message;
    private User user;

    public SupportTicket(String title, String message, User user) {
        this.title = title;
        this.message = message;
        this.user = user;
    }

    public String getTitle() {
        return title;
    }
}