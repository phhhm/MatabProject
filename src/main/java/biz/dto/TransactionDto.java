package biz.dto;

import java.util.Date;

/**
 * Created by parham on 27/10/2017.
 */
public class TransactionDto {

    private Long id;
    private Long date;
    private Long mablagh;
    private String type;
    private Long paymentId;
    private Long transactionSourceId;

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }

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

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public Long getMablagh() {
        return mablagh;
    }

    public void setMablagh(Long mablagh) {
        this.mablagh = mablagh;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
