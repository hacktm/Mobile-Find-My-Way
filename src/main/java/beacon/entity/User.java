package beacon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.binary.Base64;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="users"
)
public class User implements java.io.Serializable {


    private Long id;
    private String firstName;
    private String lastName;
    private String userFunction;
    private String description;
    private byte[] picture;

    public User() {
    }

    public User(UserJson json) {
        this.firstName = json.getFirstName();
        this.lastName = json.getLastName();
        this.userFunction = json.getUserFunction();
        this.description = json.getDescription();
        try {
            this.picture = Base64.decodeBase64(json.getPicture().getBytes());
        } catch (Exception ex) {
            System.out.println("failed base64 decoding");
        }
    }

    public void copyOver(UserJson json) {
        this.firstName = json.getFirstName();
        this.lastName = json.getLastName();
        this.userFunction = json.getUserFunction();
        this.description = json.getDescription();
        try {
            this.picture = Base64.decodeBase64(json.getPicture().getBytes());
        } catch (Exception ex) {
            System.out.println("failed base64 decoding");
        }
    }

    public User(String firstName, String lastName, String userFunction, String description) {
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

    @JsonIgnore
    @Lob
    @Column(name="picture")
    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}
