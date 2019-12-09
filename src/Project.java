import java.time.LocalDate;

public class Project {

    public void approve() {
        this.status=Status.IN_PROGRESS;
    }


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

    @Override
    public String toString(){
        return "projectID:"+code+"\n nameProject:"+name+"\n description:"+description+"\n expectedDuration:"+
                expectedDuration;
    }
    public String getName() {
        return name;
    }

    public void setStatus(Status status) {
        this.status = status;
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