package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "main_storage_entity")
public class MainStorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    private Integer drugAmountInUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_delivery_id", nullable = false)
    private DrugDeliveryEntity drugDeliveryEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugEntity drugEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDrugAmountInUnit() {
        return drugAmountInUnit;
    }

    public void setDrugAmountInUnit(Integer drugAmountInUnit) {
        this.drugAmountInUnit = drugAmountInUnit;
    }

    public DrugDeliveryEntity getDrugDeliveryEntity() {
        return drugDeliveryEntity;
    }

    public void setDrugDeliveryEntity(DrugDeliveryEntity drugDeliveryEntity) {
        this.drugDeliveryEntity = drugDeliveryEntity;
    }

    public DrugEntity getDrugEntity() {
        return drugEntity;
    }

    public void setDrugEntity(DrugEntity drugEntity) {
        this.drugEntity = drugEntity;
    }
}
