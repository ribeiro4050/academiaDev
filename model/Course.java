package academiaDev.model;

public class Course {
    private String title;
    private String description;
    private String instructor;
    private int duration;
    private DifficultyLevel difficultyLevel;
    private CourseStatus status;

    public Course(String title, String description, String instructor, int duration, DifficultyLevel difficultyLevel, CourseStatus status  ) {
        this.title = title;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.difficultyLevel = difficultyLevel;
        this.status = status;
    }
    public String getTitle() {
        return title;
    }

    public String getInstructorName() {
        return instructor;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }



}