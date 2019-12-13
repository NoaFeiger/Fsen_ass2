package Implementation;

import java.util.HashMap;
import java.util.Map;

public class Student implements Observer{

    private String feed;
    private String id;
    private Map<Project, String> preferences;

    public Student(String id){
        this.id = id;
        this.feed = null;
        this.preferences = new HashMap<>();
    }

    @Override
    public void update(Subject subject) {
        Project project = (Project) subject;
        String msg = "; The project: " + preferences.get(project) + ":\n" + project.getName() + ", id: " + project.getCode() +
                " has been approved! URL: " + "www." + project.getCode() + ".com. Description: " +project.getDescription() + ". Submitter details: " + project.getSubmitter().getFirstName() + " " + project.getSubmitter().getLastName() + ", " + project.getSubmitter().getEmail();
        if (feed == null) feed = msg;
        else feed += msg;
    }
    public  void addPreferences (Project p, String type){
        preferences.put(p,type);
    }
    public String getId() {
        return id;
    }

    public String getFeed() {
        return feed;
    }

    public void setFeed(String feed) {
        this.feed = feed;
    }
}
