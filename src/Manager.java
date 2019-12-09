import java.time.LocalDate;
import java.util.List;

public class Manager {

    private Data data = new Data();
    private User currentUser;
    private int currProjCode;
    private String currentStudent;

    public Manager(){
        this.currProjCode = 1;
    }


    public boolean login(String email, String password){

        User user = data.getUser(email, password);
        if (user != null){
            currentUser = user;
            return true;
        }

        return false;

    }

    public void register(String firstName, String lastName, String email, String phoneNumber, String organizationName,
                         String password){

        User user = new User(firstName, lastName, email, phoneNumber, organizationName, password);
        data.addUser(user);

    }

    public User getCurrentUser() {
        return currentUser;
    }


    public void logout(){
        this.currentUser = currentUser;
    }

    public int addProject(String projectName, String description, int expectedDuration, User currentUser){

        if (expectedDuration < 200 || expectedDuration > 300)
            return -1;

        boolean isDuplicate = data.checkDuplicateProject(projectName, LocalDate.now().getYear(), currentUser.getOrganization(),
                currentUser.getFirstName(), currentUser.getLastName());
        if (isDuplicate) return -1;

        int projCode = currProjCode;

        Project project = new Project(projectName, description, expectedDuration, projCode, currentUser);
        currProjCode++;

        data.addProject(project);

        return projCode;

    }


    public Project.Status checkStatus(int code) {

        Project proj = data.getProjectByCode(code);

        if (proj == null) return null;

        return proj.getStatus();

    }

    public boolean loginAsStudent(String id) {
        boolean exists=data.existsStudent(id);
        if (exists){
            currentStudent = id;
            return true;
        }
        return false;
    }

    public void logoutStudent() {
        this.currentStudent=null;
    }

    public List<Project> getProjects() {
        return data.getProjects();
    }

    public int registerToProject(int idProject, String idStudent, List<String> teammatesIds, String nameModerator) {
        if(teammatesIds.size()<1)
            return -1;
        if(checkStatus(idProject)== Project.Status.IN_PROGRESS)
            return  -2;
       //TODO check - register to not approved project
        Project pro=data.getProjectByCode(idProject);
        pro.approve();
        return pro.getCode();
    }

    public Project getProject(int idProject) {
        return data.getProjectByCode(idProject);
    }
}
