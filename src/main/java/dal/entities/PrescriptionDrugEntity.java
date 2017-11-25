package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "prescription_drug_entity")
public class PrescriptionDrugEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Integer consumableDose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugEntity drugEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prescription_id", nullable = false)
    private PrescriptionEntity prescriptionEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getConsumableDose() {
        return consumableDose;
    }

    public void setConsumableDose(Integer consumableDose) {
        this.consumableDose = consumableDose;
    }

    public DrugEntity getDrugEntity() {
        return drugEntity;
    }

    public void setDrugEntity(DrugEntity drugEntity) {
        this.drugEntity = drugEntity;
    }

    public PrescriptionEntity getPrescriptionEntity() {
        return prescriptionEntity;
    }

    public void setPrescriptionEntity(PrescriptionEntity prescriptionEntity) {
        this.prescriptionEntity = prescriptionEntity;
    }
}
