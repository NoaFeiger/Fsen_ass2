import javax.swing.text.MutableAttributeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {


    private Scanner scanner;
    private Manager manager;

    public CLI(){
        this.scanner = new Scanner(System.in);
        this.manager = new Manager();
    }


    public void mainMenu(){

        System.out.println("Home page!\n" +
                "Please choose one of the following options:");
        System.out.println("1) Login submitter \n2) Login as student \n3) Register as submitter\n4) Approve project head of department \n5) Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                loginMenu();
                break;
            case 2:
                loginAsStudent();
            case 3:
                registerMenu();
                break;
            case 4:
                approveProjectMenu();
                break;

            case 5:
                exit();
                break;
        }
    }

    private void approveProjectMenu() {
        System.out.println("Enter ID:");
        int id = Integer.parseInt(scanner.nextLine());
        manager.approveProjectByHeadOfDepartment(id);
        System.out.println("Project approved");
        mainMenu();
    }

    private void loginAsStudent() {
        System.out.println("Enter ID:");
        String id = scanner.nextLine();
        boolean succ= manager.loginAsStudent(id);
        if(succ){
            System.out.println("Login successful!");
            loggedInStudentMenu();
        }
        else
        {
            System.out.println("Invalid details, sorry!");
            mainMenu();
        }
    }

    private void loggedInStudentMenu() {

        System.out.println("1) Register project \n2) view site \n3) Notification System \n4) Logout \n5) Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                registerProject();
                break;
            case 2:
                viewSite();
                break;
            case 3:
                NotificationSystem();
                break;

            case 4:
                manager.logoutStudent();
                mainMenu();
                break;
            case 5:
                exit();
                break;
        }
    }

    private void NotificationSystem() {
        System.out.println("Enter ID Project :");
        int id =Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Type of notification (1=email 2=sms) :");
        int choose = Integer.parseInt(scanner.nextLine());
        manager.subscribeNotification(id, choose);
        System.out.println("Register successful!");
        loggedInStudentMenu();

    }

    private void viewSite() {
        System.out.println("Enter Project ID :");
        int idProject = Integer.parseInt(scanner.nextLine());
        Project pro=manager.getProject(idProject);
        if (pro == null) System.out.println("No such project exists");
        else System.out.println(pro);
        loggedInStudentMenu();
    }

    private void registerProject() {
        List<Project> projects=manager.getProjects();
        for(Project p: projects){
            System.out.println(p);
            System.out.println("----------------------");
        }
        System.out.println("Enter Project ID :");
        int idProject = Integer.parseInt(scanner.nextLine());
        //TODO check if exists
        System.out.println("Enter Your ID:");
        String idStudent = scanner.nextLine();
        System.out.println("Enter Your teammates ID (-1 to finish):");
        List<String> teammatesIds=new ArrayList<>();
        while (true){
            String id= scanner.nextLine();
            if(id.equals("-1"))
                break;
            teammatesIds.add(id);
        }
        System.out.println("Enter moderator name:");
        String nameModerator = scanner.nextLine();

        System.out.println("Are you sure about that? (y/n)");
        String choice = scanner.nextLine();

        switch (choice){
            case "y":
                break;
            case "n":
                addProjectMenu();
                break;
            default:
                break;
        }
        
        int code= manager.registerToProject(idProject,idStudent,teammatesIds,nameModerator);
        if(code==-1){
            System.out.println("Error: Insufficient amount of teammates");
            loggedInStudentMenu();
        }
        else if(code==-2)
        {
            System.out.println("Error: project is already in progress");
            loggedInStudentMenu();
        }
        System.out.println("Registration successful");
        loggedInStudentMenu();
    }


    private void exit() {
        System.exit(0);

    }

    private void registerMenu() {

        System.out.println("First name:");
        String firstName = scanner.nextLine();
        System.out.println("Last name:");
        String lastName = scanner.nextLine();
        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Phone number:");
        String phoneNumber = scanner.nextLine();
        System.out.println("Organization name:");
        String organizationName = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();


        manager.register(firstName, lastName, email, phoneNumber, organizationName, password);
        System.out.println("Registration successful");

        mainMenu();

    }

    private void loginMenu() {

        System.out.println("Email:");
        String email = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();


        if (manager.login(email, password)){
            System.out.println("Login successful");
            loggedInMenu();
        }

        else {
            System.out.println("Details incorrect");
            mainMenu();
        }
    }

    private void loggedInMenu(){

        System.out.println("1) Add a project\n2) Check status\n3) Logout\n4) Exit");

        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice){
            case 1:
                addProjectMenu();
                break;
            case 2:
                checkStatus();
                break;
            case 3:
                manager.logout();
                System.out.println("Logout successful");
                mainMenu();
                break;
            case 4:
                exit();
                break;
        }
    }

    private void checkStatus() {

        System.out.println("Project code:");
        int code = Integer.parseInt(scanner.nextLine());

        Project.Status status = manager.checkStatus(code);

        if (status == null) {
            System.out.println("Error: there is no project with this code");
            loggedInMenu();
        }

        System.out.println("Status = " + status);

        loggedInMenu();

    }

    private void addProjectMenu() {

        System.out.println("Project name:");
        String projectName = scanner.nextLine();
        System.out.println("Description:");
        String description = scanner.nextLine();
        System.out.println("Expected duration:");
        int expectedDuration = Integer.parseInt(scanner.nextLine());

        User currentUser = manager.getCurrentUser();

        System.out.println("Are you sure about that? (y/n)");
        String choice = scanner.nextLine();

        switch (choice){
            case "y":
                break;
            case "n":
                addProjectMenu();
                break;
            default:
                break;
        }

        int prodCode = manager.addProject(projectName, description, expectedDuration, currentUser);

        if (prodCode == -1) {
            System.out.println("Invalid details, sorry!");
            loggedInMenu();
        }

        System.out.println("Successful! Your project code is " + prodCode);

        loggedInMenu();
    }


}

