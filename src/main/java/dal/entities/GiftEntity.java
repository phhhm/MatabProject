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
@Table(name = "gift_entity")
public class GiftEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "cause")
    @NotNull
    @Size(min= 3,max= 20)
    private String cause;

    @Column(name = "mablagh")
    @NotNull
    @Size(min= 4,max= 15)
    private String mablagh;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentEntity paymentEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getMablagh() {
        return mablagh;
    }

    public void setMablagh(String mablagh) {
        this.mablagh = mablagh;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }
}
