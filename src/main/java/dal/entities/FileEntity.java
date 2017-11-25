package dal.entities;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Max(1)
    private Long fileCode;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 20)
    private String consumableDrugs;

    @Column(nullable = true)
    @Min(10000)
    private Long endDate;

    @Column(nullable = false)
    @NotNull
    @Min(10000)
    private Long startDate;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 5, integer = 50)
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

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
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
