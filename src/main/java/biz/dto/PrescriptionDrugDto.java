package biz.dto;

public class PrescriptionDrugDto {
    private Integer consumableDose;
    private Long id;
    private Long prescriptionId;
    private Long drugId;

    public Long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getDrugId() {
        return drugId;
    }

    public void setDrugId(Long drugId) {
        this.drugId = drugId;
    }

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
}
