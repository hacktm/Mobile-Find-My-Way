package beacon.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.codec.binary.Base64;

import javax.persistence.*;

@Entity
@Table(name="beacons"
)
public class Beacon implements java.io.Serializable {


    private Long id;
    private String beaconID;
    private String type;
    private Long profileID;
    private String description;
    private Long major;
    private Long minor;


    public Beacon() {
    }

    public void copyBeacon(Beacon b) {
        this.beaconID = b.getBeaconID();
        this.type = b.getType();
        this.profileID = b.getProfileID();
        this.description = b.getDescription();
        this.major = b.getMajor();
        this.minor = b.getMinor();
    }

    public Beacon(String beaconID, String type, String description, Long major, Long minor) {
        this.beaconID = beaconID;
        this.type = type;
        this.description = description;
        this.major = major;
        this.minor = minor;
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

    @Column(name="beaconid", nullable=false)
    public String getBeaconID() {
        return beaconID;
    }

    public void setBeaconID(String beaconID) {
        this.beaconID = beaconID;
    }

    @Column(name="type", nullable=false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="profileid", nullable=false)
    public Long getProfileID() {
        return profileID;
    }

    public void setProfileID(Long profileID) {
        this.profileID = profileID;
    }

    @Column(name="description", nullable=false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="major", nullable=false)
    public Long getMajor() {
        return major;
    }

    public void setMajor(Long major) {
        this.major = major;
    }

    @Column(name="minor", nullable=false)
    public Long getMinor() {
        return minor;
    }

    public void setMinor(Long minor) {
        this.minor = minor;
    }
}
