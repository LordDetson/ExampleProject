package by.babanin.dao.entity;

import by.babanin.dao.ExampleEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

@Named
@RequestScoped
@Entity
@Table(name = "PROJECT")
public class ProjectEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @ManyToMany(mappedBy = "projectEntities")
    private Set<EmployeeEntity> employeeEntities;

    @Transient
    @EJB
    private ExampleEJB exampleEJB;

    public ProjectEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(Set<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProjectEntity projectEntity = (ProjectEntity) o;
        return Objects.equals(id, projectEntity.id) &&
                Objects.equals(title, projectEntity.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProjectEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("title='" + title + "'")
                .toString();
    }

    public void save() {
        exampleEJB.saveProject(this);
    }
}
