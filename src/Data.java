import java.awt.image.PixelGrabber;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<User> users = new ArrayList<>();
    private List<Project> projects = new ArrayList<>();
    private List<Student> students = new ArrayList<>();


    public Data(){
        students.add(new Student("1234"));
        students.add(new Student("1111"));
        students.add(new Student("2222"));
        students.add(new Student("3333"));
        students.add(new Student("4444"));

    }

    public Student getStudentById(String id){
        for (Student s: students){
            if (s.getId().equals(id)) {
                return s;
            }
        }
        return null;
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

        for (Student currStud : students) {
            if (currStud.getId().equals(id)) return true;
        }
        return false;
    }

    public List<Project> getProjects() {
        return projects;
    }
}
