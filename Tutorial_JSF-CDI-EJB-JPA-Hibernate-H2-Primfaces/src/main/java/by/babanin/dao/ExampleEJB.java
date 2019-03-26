package by.babanin.dao;

import by.babanin.dao.entity.AddressEntity;
import by.babanin.dao.entity.EmployeeEntity;
import by.babanin.dao.entity.ProjectEntity;
import by.babanin.repository.AddressRepository;
import by.babanin.repository.EmployeeRepository;
import by.babanin.repository.ProjectRepository;

import javax.ejb.Stateless;

@Stateless
public class ExampleEJB {
    private AddressRepository addressRepository;
    private EmployeeRepository employeeRepository;
    private ProjectRepository projectRepository;

    public ExampleEJB() {
        addressRepository = ApplicationContext.getInstance().getAddressRepository();
        employeeRepository = ApplicationContext.getInstance().getEmployeeRepository();
        projectRepository = ApplicationContext.getInstance().getProjectRepository();
    }

    public void saveAddress(AddressEntity address) {
        addressRepository.save(address);
    }

    public void saveEmployee(EmployeeEntity employee) {
        employeeRepository.save(employee);
    }

    public void saveProject(ProjectEntity project) {
        projectRepository.save(project);
    }
}
