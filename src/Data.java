import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<User> users = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<String> students = new ArrayList<>();


    public Data(){
        students.add("1234");
        students.add("1111");
        students.add("2222");
        students.add("3333");
        students.add("4444");

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

    public boolean existsStudent(String id) {

        for (String currId : students) {
            if (currId.equals(id)) return true;
        }
        return false;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
