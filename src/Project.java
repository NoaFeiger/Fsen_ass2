import java.time.LocalDate;

public class Project {

    enum Status {
        UNDER_REVIEW,
        APPROVED,
        REJECTED,
        IN_PROGRESS
    }

    private String name;
    private String description;
    private int expectedDuration;
    private Status status;
    private LocalDate creationDate;
    private int code;
    private User submitter;

    public Project(String name, String description, int expectedDuration, int code, User submitter){
        this.name = name;
        this.description = description;
        this.expectedDuration = expectedDuration;
        this.code = code;
        this.submitter = submitter;
        this.status = Status.UNDER_REVIEW;
        this.creationDate = LocalDate.now();
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public User getSubmitter() {
        return submitter;
    }

    public int getCode() {
        return code;
    }

    public Status getStatus() {
        return status;
    }
}