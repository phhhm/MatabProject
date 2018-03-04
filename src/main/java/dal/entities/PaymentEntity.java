package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "payment_entity")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "main_payment")
    @NotNull
    @Size(min = 4, max = 15)
    private String mainPayment;

    @Column(name = "bime", nullable = true)
    @Size(min = 4, max = 15)
    private String bime;

    @Column(name = "kasri", nullable = true)
    @Size(min = 4, max = 15)
    private String kasri;

    @Column(name = "sanavat", nullable = true)
    @Size(min = 4, max = 15)
    private String sanavat;

    @Column(name = "maliat", nullable = true)
    @Size(min = 4, max = 15)
    private String maliat;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "paymentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<TransactionEntity> transactionEntityList;

    @OneToOne(mappedBy = "paymentEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private GiftEntity giftEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(String mainPayment) {
        this.mainPayment = mainPayment;
    }

    public String getBime() {
        return bime;
    }

    public void setBime(String bime) {
        this.bime = bime;
    }

    public String getKasri() {
        return kasri;
    }

    public void setKasri(String kasri) {
        this.kasri = kasri;
    }

    public String getSanavat() {
        return sanavat;
    }

    public void setSanavat(String sanavat) {
        this.sanavat = sanavat;
    }

    public String getMaliat() {
        return maliat;
    }

    public void setMaliat(String maliat) {
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
