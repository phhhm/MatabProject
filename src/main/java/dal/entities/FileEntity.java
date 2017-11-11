package dal.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@Entity
@Table(name = "file_entity")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long fileCode;

    @Column(nullable = false)
    private String consumableDrugs;

    @Column(nullable = true)
    private String endDate;

    @Column(nullable = false)
    private String startDate;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "fileEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VisitEntity> visitEntiyList;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patientEntity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private TransactionEntity transactionEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileCode() {
        return fileCode;
    }

    public void setFileCode(Long fileCode) {
        this.fileCode = fileCode;
    }

    public String getConsumableDrugs() {
        return consumableDrugs;
    }

    public void setConsumableDrugs(String consumableDrugs) {
        this.consumableDrugs = consumableDrugs;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<VisitEntity> getVisitEntiyList() {
        return visitEntiyList;
    }

    public void setVisitEntiyList(List<VisitEntity> visitEntiyList) {
        this.visitEntiyList = visitEntiyList;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    public TransactionEntity getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(TransactionEntity transactionEntity) {
        this.transactionEntity = transactionEntity;
    }
}
