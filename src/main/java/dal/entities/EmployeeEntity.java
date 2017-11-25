package dal.entities;

import org.jboss.resteasy.spi.touri.URITemplate;

import javax.enterprise.inject.Default;
import javax.persistence.*;
import javax.validation.constraints.*;
import javax.ws.rs.DefaultValue;
import java.util.List;

/**
 * Created by parham on 26/10/2017.
 */
@Entity
@Table(name = "employee_entity")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 15)
    private String firstName;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 20)
    private String lastName;

    @Column
    @NotNull
    private Long uid;

    @Column
    @NotNull
    private Long ucode;

    @Column(nullable = false)
    @NotNull
    @Min(7)
    @Max(20)
    private Long phoneNumber;

    @Column(nullable = false)
    @NotNull
    private Long employeeCode;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 10, integer = 40)
    private String homeAddress;

    @Column
    @NotNull
    @Digits(fraction = 3, integer = 20)
    private String degree;

    @Column
    @NotNull
    @Digits(fraction = 5, integer = 30)
    private String ability;

    @Column(nullable = false)
    @NotNull
    private String employeeType;

    @Column(nullable = false)
    @NotNull
    private Integer remainMorekhasi;

    @Column
    @NotNull
    @Pattern(regexp = "[a-z]+www+.+[a-z]+.+", message = "invalid url")
    private String imageUrl;

    @OneToMany( mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PresentTimeEntity> presentTimeEntityList;

    @OneToOne(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PaymentEntity paymentEntity;

    @OneToOne(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ContractEntity contractEntity;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DismissEntity> dismissEntityList;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DrugDeliveryEntity> drugDeliveryEntityList;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VisitEntity> visitEntiyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getUcode() {
        return ucode;
    }

    public void setUcode(Long ucode) {
        this.ucode = ucode;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(Long employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public Integer getRemainMorekhasi() {
        return remainMorekhasi;
    }

    public void setRemainMorekhasi(Integer remainMorekhasi) {
        this.remainMorekhasi = remainMorekhasi;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<PresentTimeEntity> getPresentTimeEntityList() {
        return presentTimeEntityList;
    }

    public void setPresentTimeEntityList(List<PresentTimeEntity> presentTimeEntityList) {
        this.presentTimeEntityList = presentTimeEntityList;
    }

    public PaymentEntity getPaymentEntity() {
        return paymentEntity;
    }

    public void setPaymentEntity(PaymentEntity paymentEntity) {
        this.paymentEntity = paymentEntity;
    }

    public ContractEntity getContractEntity() {
        return contractEntity;
    }

    public void setContractEntity(ContractEntity contractEntity) {
        this.contractEntity = contractEntity;
    }

    public List<DismissEntity> getDismissEntityList() {
        return dismissEntityList;
    }

    public void setDismissEntityList(List<DismissEntity> dismissEntityList) {
        this.dismissEntityList = dismissEntityList;
    }

    public List<DrugDeliveryEntity> getDrugDeliveryEntityList() {
        return drugDeliveryEntityList;
    }

    public void setDrugDeliveryEntityList(List<DrugDeliveryEntity> drugDeliveryEntityList) {
        this.drugDeliveryEntityList = drugDeliveryEntityList;
    }

    public List<VisitEntity> getVisitEntiyList() {
        return visitEntiyList;
    }

    public void setVisitEntiyList(List<VisitEntity> visitEntiyList) {
        this.visitEntiyList = visitEntiyList;
    }
}
