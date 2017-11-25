package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "payment_entity")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false )
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Min(10000)
    private Long mainPayment;

    @Column(nullable = true)
    @Min(10000)
    private Long bime;

    @Column(nullable = true)
    @Min(1000)
    private Long kasri;

    @Column(nullable = true)
    @Min(1000)
    private Long sanavat;

    @Column(nullable = true)
    @Min(1000)
    private Integer maliat;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "paymentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TransactionEntity> transactionEntityList;

    @OneToOne(mappedBy = "paymentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private GiftEntity giftEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(Long mainPayment) {
        this.mainPayment = mainPayment;
    }

    public Long getBime() {
        return bime;
    }

    public void setBime(Long bime) {
        this.bime = bime;
    }

    public Long getKasri() {
        return kasri;
    }

    public void setKasri(Long kasri) {
        this.kasri = kasri;
    }

    public Long getSanavat() {
        return sanavat;
    }

    public void setSanavat(Long sanavat) {
        this.sanavat = sanavat;
    }

    public Integer getMaliat() {
        return maliat;
    }

    public void setMaliat(Integer maliat) {
        this.maliat = maliat;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public List<TransactionEntity> getTransactionEntityList() {
        return transactionEntityList;
    }

    public void setTransactionEntityList(List<TransactionEntity> transactionEntityList) {
        this.transactionEntityList = transactionEntityList;
    }

    public GiftEntity getGiftEntity() {
        return giftEntity;
    }

    public void setGiftEntity(GiftEntity giftEntity) {
        this.giftEntity = giftEntity;
    }
}
