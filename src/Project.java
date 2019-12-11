import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Project implements Subject {

    public void approve() {
        setStatus(Status.IN_PROGRESS);
    }

    List<Observer> observers = new ArrayList<>();




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
        super();
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


    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public void setStatus(Status status) {
        this.status = status;
        notifyAllObservers();
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