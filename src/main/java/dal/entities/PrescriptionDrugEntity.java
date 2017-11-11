package dal.entities;

import javax.persistence.*;

@Entity
@Table(name = "prescription_drug_entity")
public class PrescriptionDrugEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String consumableDose;

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

    public String getConsumableDose() {
        return consumableDose;
    }

    public void setConsumableDose(String consumableDose) {
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
