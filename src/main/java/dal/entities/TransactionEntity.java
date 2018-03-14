package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "transaction_entity")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "date")
    @NotNull
    @Size(min= 5, max= 20)
    private String date;

    @Column(name = "mablagh")
    @NotNull
    @Size(min= 5, max= 20)
    private String mablagh;

    @Column(name = "type")
    @NotNull
    @Size(min= 3, max= 20)
    private String type;

    @Column(name = "transaction_source_id")
    @NotNull
    private String transactionSourceId;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMablagh() {
        return mablagh;
    }

    public void setMablagh(String mablagh) {
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

    public String getTransactionSourceId() {
        return transactionSourceId;
    }

    public void setTransactionSourceId(String transactionSourceId) {
        this.transactionSourceId = transactionSourceId;
    }
}
