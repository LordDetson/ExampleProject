package by.babanin.dao.entity;

import by.babanin.dao.ExampleEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Named
@RequestScoped
@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "EMPL_PROJ",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJECT_ID")
    )
    private Set<ProjectEntity> projectEntities;

    @Transient
    @EJB
    private ExampleEJB exampleEJB;

    public EmployeeEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public Set<ProjectEntity> getProjectEntities() {
        return projectEntities;
    }

    public void setProjectEntities(Set<ProjectEntity> projectEntities) {
        this.projectEntities = projectEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeEntity employeeEntity = (EmployeeEntity) o;
        return Objects.equals(id, employeeEntity.id) &&
                Objects.equals(firstName, employeeEntity.firstName) &&
                Objects.equals(lastName, employeeEntity.lastName) &&
                Objects.equals(birthday, employeeEntity.birthday) &&
                Objects.equals(addressEntity, employeeEntity.addressEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthday, addressEntity);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", EmployeeEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("birthday=" + birthday)
                .add("address=" + addressEntity)
                .toString();
    }

    public void save(AddressEntity addressEntity) {
        setAddressEntity(addressEntity);
        exampleEJB.saveEmployee(this);
    }
}
