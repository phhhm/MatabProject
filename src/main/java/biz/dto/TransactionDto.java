package biz.dto;

import java.util.Date;

/**
 * Created by parham on 27/10/2017.
 */
public class TransactionDto {

    private Long id;
    private String date;
    private Float mablagh;
    private String type;
    private Long paymentId;

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getMablagh() {
        return mablagh;
    }

    public void setMablagh(Float mablagh) {
        this.mablagh = mablagh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
