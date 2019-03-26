package by.babanin.dao;

import by.babanin.repository.AddressRepository;
import by.babanin.repository.EmployeeRepository;
import by.babanin.repository.ProjectRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContext {
    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    private static class Singleton{
        static final ApplicationContext INSTANCE = new ApplicationContext();
    }

    private ApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        addressRepository = context.getBean(AddressRepository.class);
        employeeRepository = context.getBean(EmployeeRepository.class);
        projectRepository = context.getBean(ProjectRepository.class);
    }

    public static ApplicationContext getInstance() {
        return Singleton.INSTANCE;
    }

    public AddressRepository getAddressRepository() {
        return addressRepository;
    }

    public EmployeeRepository getEmployeeRepository() {
        return employeeRepository;
    }

    public ProjectRepository getProjectRepository() {
        return projectRepository;
    }
}
