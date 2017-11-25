package biz.dto;

public class MainStorageDto {
    private Long id;
    private Integer drugAmountInUnit;
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

    public Integer getDrugAmountInUnit() {
        return drugAmountInUnit;
    }

    public void setDrugAmountInUnit(Integer drugAmountInUnit) {
        this.drugAmountInUnit = drugAmountInUnit;
    }
}
