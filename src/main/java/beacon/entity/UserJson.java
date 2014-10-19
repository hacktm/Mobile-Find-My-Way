package beacon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="users"
)
public class UserJson implements java.io.Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String userFunction;
    private String description;
    private String picture;

    public UserJson() {
    }

    public UserJson(String firstName, String lastName, String userFunction, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userFunction = userFunction;
        this.description = description;
    }

    @Id
    @GeneratedValue


    @Column(name="id", unique=true, nullable=false, scale=0)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name="firstname", nullable=false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name="lastname", nullable=false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name="userfunction", nullable=false)
    public String getUserFunction() {
        return userFunction;
    }

    public void setUserFunction(String userFunction) {
        this.userFunction = userFunction;
    }

    @Column(name="description", nullable=false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Lob
    @Column(name="picture")
    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
