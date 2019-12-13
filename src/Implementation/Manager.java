package Implementation;

import java.time.LocalDate;
import java.util.List;

public class Manager {

    private Data data = new Data();
    private User currentUser;
    private int currProjCode;
    private String currentStudentId;

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
        this.currentUser = null;
    }

    public int addProject(String projectName, String description, int expectedDuration, User currentUser){

        if (!data.existsUser(currentUser)) return 0;

        if (currentUser.getFirstName() == null || currentUser.getFirstName().equals("") )
            return 0;

        if (currentUser.getLastName() == null || currentUser.getLastName().equals("") )
            return 0;

        if (currentUser.getPhoneNumber() == null || currentUser.getPhoneNumber().equals("") )
            return 0;

        if (currentUser.getEmail() == null || currentUser.getEmail().equals("") )
            return 0;

        if (projectName == null || projectName.equals("") )
            return 0;




        if (expectedDuration < 200 || expectedDuration > 300)
            return 0;

        boolean isDuplicate = data.checkDuplicateProject(projectName, LocalDate.now().getYear(), currentUser.getOrganization(),
                currentUser.getFirstName(), currentUser.getLastName());
        if (isDuplicate) return 0;

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

            currentStudentId = id;

            Student s = data.getStudentById(id);

            if (s.getFeed() != null) {
                System.out.println(s.getFeed());
                s.setFeed(null);
            }

            return true;
        }
        return false;
    }

    public void logoutStudent() {
        this.currentStudentId=null;
    }

    public List<Project> getProjects() {
        return data.getProjects();
    }

    public int registerToProject(int idProject, String idStudent, List<String> teammatesIds, String nameModerator) {

        if (nameModerator == null || nameModerator.equals("")) return 0;

        if(teammatesIds.size()<1)
            return 0;
        if(checkStatus(idProject)== Project.Status.IN_PROGRESS)
            return  0;
       //TODO check - register to not approved project
        Project pro=data.getProjectByCode(idProject);
        pro.setStatus(Project.Status.IN_PROGRESS);
        pro.setNameModerator(nameModerator);
        return pro.getCode();
    }

    public Project getProject(int idProject) {
        return data.getProjectByCode(idProject);
    }

    public void subscribeNotification(int id, int choose) {
        Student stu=data.getStudentById(currentStudentId);
        Project pro= data.getProjectByCode(id);
        pro.attach(stu);
        String type = choose == 1 ? "email" : "sms";
        stu.addPreferences(pro,type);


    }

    public void approveProjectByHeadOfDepartment(int id) {
        Project p=data.getProjectByCode(id);
        p.setStatus(Project.Status.APPROVED);
    }
}
