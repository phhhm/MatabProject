package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "prescription_entity")
public class PrescriptionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @OneToMany(mappedBy = "prescriptionEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PrescriptionDrugEntity> prescriptionDrugEntityList;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "visit_id", nullable = false)
    private VisitEntity visitEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PrescriptionDrugEntity> getPrescriptionDrugEntityList() {
        return prescriptionDrugEntityList;
    }

    public void setPrescriptionDrugEntityList(List<PrescriptionDrugEntity> prescriptionDrugEntityList) {
        this.prescriptionDrugEntityList = prescriptionDrugEntityList;
    }

    public VisitEntity getVisitEntity() {
        return visitEntity;
    }

    public void setVisitEntity(VisitEntity visitEntity) {
        this.visitEntity = visitEntity;
    }
}
