package dal.entities;

import javax.persistence.*;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "transaction_entity")
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String date;

    @Column(nullable = false)
    private float mablagh;

    @Column(nullable = false)
    private String type;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getMablagh() {
        return mablagh;
    }

    public void setMablagh(float mablagh) {
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
}
