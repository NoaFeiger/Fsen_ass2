package bridgeProject;

import Implementation.Manager;
import Implementation.User;
import acptTests.auxiliary.DBRegisteredProjectInfo;
import acptTests.auxiliary.DBSuggestedProjectInfo;

public class BridgeReal implements BridgeProject{

    Manager manager = new Manager();

    @Override
    public void registerNewTechnicalAdviser(String user, String password) {

    }

    @Override
    public void addNewStudent(String user, String password) {

    }

    @Override
    public int addNewProject(String user, String pass, DBSuggestedProjectInfo suggestedProject) {

        User u = new User(suggestedProject.firstName, suggestedProject.lastName, suggestedProject.email, suggestedProject.phone, suggestedProject.organization, pass);
        u.setUsername(user);


        return manager.addProject(suggestedProject.projectName, suggestedProject.description,
                suggestedProject.numberOfHours, u);

    }

    @Override
    public int registerToProject(String user, String pass, DBRegisteredProjectInfo registeredProject) {

        return manager.registerToProject(registeredProject.projectId, registeredProject.studentList.get(0), registeredProject.studentList.subList(1, registeredProject.studentList.size()), registeredProject.academicAdviser);

    }
}
