package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "transaction_entity")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Min(100000)
    private Long date;

    @Column(nullable = false)
    @NotNull
    @Min(100)
    private Long mablagh;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 20)
    private String type;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Long transactionSourceId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentEntity paymentEntity;

    @OneToOne(mappedBy = "transactionEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private DrugDeliveryEntity drugDeliveryEntity;

    @OneToOne(mappedBy = "transactionEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FileEntity fileEntity;

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

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public DrugDeliveryEntity getDrugDeliveryEntity() {
        return drugDeliveryEntity;
    }

    public void setDrugDeliveryEntity(DrugDeliveryEntity drugDeliveryEntity) {
        this.drugDeliveryEntity = drugDeliveryEntity;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }

    public Long getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(Long transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }
}
