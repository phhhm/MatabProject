package dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "partial_storage_entity")
public class PartialStorageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private float drugAmountInUnit;

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

    public float getDrugAmountInUnit() {
        return drugAmountInUnit;
    }

    public void setDrugAmountInUnit(float drugAmountInUnit) {
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
