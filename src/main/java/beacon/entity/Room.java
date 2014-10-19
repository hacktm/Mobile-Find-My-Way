package beacon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="rooms"
)
public class Room implements java.io.Serializable {


    private Long id;
    private String name;
    private String location;
    private Set<Event> events = new HashSet<Event>();
    private byte[] picture;

    public Room() {
    }

    public void copyRoom(Room r) {
        this.name = r.getName();
        this.location = r.getLocation();
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

    @Column(name="name", nullable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="location", nullable = true)
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Transient
    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
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
