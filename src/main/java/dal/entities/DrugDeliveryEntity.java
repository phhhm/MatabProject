package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "drug_delivery_entity")
public class DrugDeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    @NotNull
    @Size(min= 3, max= 10)
    private String sourceType;

    @Column
    @NotNull
    @Max(20)
    private Integer useDuration;

    @Column
    @NotNull
    private Long deliveryDate;

    @Column
    @NotNull
    private Long sourceId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "transaction_id", nullable = false)
    private TransactionEntity transactionEntity;

    @OneToMany(mappedBy = "drugDeliveryEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MainStorageEntity> mainStorageEntityList;

    @OneToMany(mappedBy = "drugDeliveryEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PartialStorageEntity> partialStorageEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public Integer getUseDuration() {
        return useDuration;
    }

    public void setUseDuration(Integer useDuration) {
        this.useDuration = useDuration;
    }

    public Long getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Long deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Long getSourceId() {
        return sourceId;
    }

    public void setSourceId(Long sourceId) {
        this.sourceId = sourceId;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public TransactionEntity getTransactionEntity() {
        return transactionEntity;
    }

    public void setTransactionEntity(TransactionEntity transactionEntity) {
        this.transactionEntity = transactionEntity;
    }

    public List<MainStorageEntity> getMainStorageEntityList() {
        return mainStorageEntityList;
    }

    public void setMainStorageEntityList(List<MainStorageEntity> mainStorageEntityList) {
        this.mainStorageEntityList = mainStorageEntityList;
    }

    public List<PartialStorageEntity> getPartialStorageEntityList() {
        return partialStorageEntityList;
    }

    public void setPartialStorageEntityList(List<PartialStorageEntity> partialStorageEntityList) {
        this.partialStorageEntityList = partialStorageEntityList;
    }
}
