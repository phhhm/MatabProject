package biz.dto;

public class MainStorageDto {
    private Long id;
    private Float drugAmountInUnit;
    private Long drugDeliveryId;
    private Long drugId;

    public Long getDrugDeliveryId() {
        return drugDeliveryId;
    }

    public void setDrugDeliveryId(Long drugDeliveryId) {
        this.drugDeliveryId = drugDeliveryId;
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

    public Float getDrugAmountInUnit() {
        return drugAmountInUnit;
    }

    public void setDrugAmountInUnit(Float drugAmountInUnit) {
        this.drugAmountInUnit = drugAmountInUnit;
    }
}
