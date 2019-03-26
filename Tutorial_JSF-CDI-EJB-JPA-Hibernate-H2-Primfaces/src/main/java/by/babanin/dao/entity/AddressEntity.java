package by.babanin.dao.entity;

import by.babanin.dao.ExampleEJB;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.StringJoiner;

@Named
@RequestScoped
@Entity
@Table(name = "ADDRESS")
public class AddressEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STREET")
    private String street;

    @Column(name = "POST_CODE", length = 10)
    private String postCode;

    @Transient
    @EJB
    private ExampleEJB exampleEJB;

    public AddressEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressEntity addressEntity = (AddressEntity) o;
        return Objects.equals(id, addressEntity.id) &&
                Objects.equals(country, addressEntity.country) &&
                Objects.equals(city, addressEntity.city) &&
                Objects.equals(street, addressEntity.street) &&
                Objects.equals(postCode, addressEntity.postCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, postCode);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AddressEntity.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .add("street='" + street + "'")
                .add("postCode='" + postCode + "'")
                .toString();
    }

    public void save() {
        exampleEJB.saveAddress(this);
    }
}
