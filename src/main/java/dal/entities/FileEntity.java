package dal.entities;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by parham on 10/28/2017.
 */
@Entity
@Table(name = "file_entity")
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "file_code")
    @NotNull
    private String fileCode;

    @Column(name = "consum_able_drugs")
    @NotNull
    @Size(min= 3, max= 20)
    private String consumableDrugs;

    @Column(name = "end_date")
    @Size(min= 5, max= 20)
    private String endDate;

    @Column(name = "start_date")
    @NotNull
    @Size(min= 5, max= 20)
    private String startDate;

    @Column(name = "description")
    @NotNull
    @Size(min= 5, max= 50)
    private String description;

    @OneToMany(mappedBy = "fileEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VisitEntity> visitEntiyList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patientEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id", nullable = false)
    private TransactionEntity transactionEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
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
