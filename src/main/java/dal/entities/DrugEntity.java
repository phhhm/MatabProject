package dal.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drug_entity")
public class DrugEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String unitType;

    @Column(nullable = false)
    private String totalInventory;

    @OneToMany(mappedBy = "drugEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CostEntity> costEntityList;

    @OneToMany(mappedBy = "drugEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<MainStorageEntity> mainStorageEntityList;

    @OneToMany(mappedBy = "drugEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PartialStorageEntity> partialStorageEntityList;

    @OneToMany(mappedBy = "drugEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PrescriptionDrugEntity> prescriptionDrugEntityList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getTotalInventory() {
        return totalInventory;
    }

    public void setTotalInventory(String totalInventory) {
        this.totalInventory = totalInventory;
    }

    public List<CostEntity> getCostEntityList() {
        return costEntityList;
    }

    public void setCostEntityList(List<CostEntity> costEntityList) {
        this.costEntityList = costEntityList;
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

    public List<PrescriptionDrugEntity> getPrescriptionDrugEntityList() {
        return prescriptionDrugEntityList;
    }

    public void setPrescriptionDrugEntityList(List<PrescriptionDrugEntity> prescriptionDrugEntityList) {
        this.prescriptionDrugEntityList = prescriptionDrugEntityList;
    }
}
