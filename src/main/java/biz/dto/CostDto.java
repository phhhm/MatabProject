package biz.dto;

public class CostDto {
    private Long id;
    private String sell;
    private String buy;
    private String date;
    private Long drugId;

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

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
