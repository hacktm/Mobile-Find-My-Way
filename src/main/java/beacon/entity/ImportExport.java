package beacon.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ETK_IMPORT_EXPORT_DETAILS"
)
public class ImportExport  implements java.io.Serializable {


    private BigDecimal importExportDetailsId;
    private String jobId;
    private String jobType;
    private String jobStatus;
    private Date startTime;
    private Date endTime;
    private String userName;
    private String source;
    private String destination;
    private BigDecimal fileSize;
    private String message;
    private String metaData;
    private byte[] content;

    public ImportExport() {
    }


    public ImportExport(String jobId, String jobType, String jobStatus, Date startTime, String userName) {
        this.jobId = jobId;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.startTime = startTime;
        this.userName = userName;
    }
    public ImportExport(String jobId, String jobType, String jobStatus, Date startTime, Date endTime, String userName, String source, String destination, BigDecimal fileSize, String message, String metaData, byte[] content) {
        this.jobId = jobId;
        this.jobType = jobType;
        this.jobStatus = jobStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.userName = userName;
        this.source = source;
        this.destination = destination;
        this.fileSize = fileSize;
        this.message = message;
        this.metaData = metaData;
        this.content = content;
    }

    @Id
    @GeneratedValue


    @Column(name="IMPORT_EXPORT_DETAILS_ID", unique=true, nullable=false, scale=0)
    public BigDecimal getImportExportDetailsId() {
        return this.importExportDetailsId;
    }

    public void setImportExportDetailsId(BigDecimal importExportDetailsId) {
        this.importExportDetailsId = importExportDetailsId;
    }


    @Column(name="JOB_ID", nullable=false, length=30)
    public String getJobId() {
        return this.jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }


    @Column(name="JOB_TYPE", nullable=false, length=10)
    public String getJobType() {
        return this.jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }


    @Column(name="JOB_STATUS", nullable=false, length=20)
    public String getJobStatus() {
        return this.jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="START_TIME", nullable=false)
    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="END_TIME")
    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }


    @Column(name="USER_NAME", nullable=false)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    @Column(name="SOURCE")
    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Column(name="DESTINATION")
    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


    @Column(name="FILE_SIZE", scale=0)
    public BigDecimal getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(BigDecimal fileSize) {
        this.fileSize = fileSize;
    }


    @Column(name="MESSAGE", length=2000)
    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    @Column(name="META_DATA")
    public String getMetaData() {
        return this.metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Lob
    @Column(name="CONTENT")
    public byte[] getContent() {
        return this.content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }




}
