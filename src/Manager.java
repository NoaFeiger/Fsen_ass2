import java.time.LocalDate;

public class Manager {

    private Data data = new Data();
    private User currentUser;
    private int currProjCode;


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

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void logout(){
        setCurrentUser(null);
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
}
