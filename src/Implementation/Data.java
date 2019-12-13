package Implementation;

import acptTests.auxiliary.DBData;

import java.util.ArrayList;
import java.util.List;

import static acptTests.ProjectTest.*;
import static acptTests.ProjectTest.USER_USER;

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

        User u1 = new User(DBData.names[0][USER_FirstName], DBData.names[0][USER_LastName], "stam@ibm.com", "03-7777777", "IBM", DBData.users[0][USER_PASS]);
        u1.setUsername(DBData.users[0][USER_USER]);
        User u2 = new User(DBData.names[1][USER_FirstName], DBData.names[1][USER_LastName], "stam@microsoft.com", "03-6666666", "MicroSoft", DBData.users[1][USER_PASS]);
        u2.setUsername(DBData.users[1][USER_USER]);
        User u3 = new User(DBData.names[2][USER_FirstName], DBData.names[2][USER_LastName], "stam@ibm.com", "03-7777777", "IBM", DBData.users[2][USER_PASS]);
        u3.setUsername(DBData.users[2][USER_USER]);
        User u4 = new User(DBData.names[0][USER_FirstName], DBData.names[0][USER_LastName], "stam@ibm.com", "03-7777777", "IBM", DBData.users[0][USER_PASS]);
        u4.setUsername(DBData.users[0][USER_USER]);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);



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


    public boolean existsUser(User currentUser) {

        for (User u: users){
            if (u.equals(currentUser))
                return true;
        }

        return false;


    }
}
