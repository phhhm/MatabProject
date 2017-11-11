package dal.entities;

import javax.persistence.*;
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
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column
    private Long uid;

    @Column
    private Long ucode;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private Long employeeCode;

    @Column(nullable = false)
    private String homeAddress;

    @Column
    private String degree;

    @Column
    private String ability;

    @Column(nullable = false)
    private String employeeType;

    @Column(nullable = false)
    private Integer remainMorekhasi;

    @Column
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
