import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<User> users = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();


    public Data(){

    }

    public void addUser(User user){
        users.add(user);
    }

    public User getUser(String email, String password){

        for (User u: users){
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public void addProject(Project project){
        projects.add(project);
    }


    public boolean checkDuplicateProject(String projectName, int year, String organization, String firstName, String lastName) {

        for (Project p: projects){

            if (p.getName().equals(projectName) && p.getCreationDate().getYear() == year &&
                    ((p.getSubmitter().getFirstName().equals(firstName) &&
                        p.getSubmitter().getLastName().equals(lastName)) || p.getSubmitter().getOrganization().equals(organization))) {
                return true;
            }

        }

        return false;

    }

    public Project getProjectByCode(int code) {

        for (Project p: projects){

            if (p.getCode() == code) return p;

        }

        return null;

    }
}
