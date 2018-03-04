package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

/**
 * Created by parham on 26/10/2017.
 */
@Entity
@Table(name = "employee_entity")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min= 3, max= 15)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min= 3, max= 20)
    private String lastName;

    @Column(name = "uid")
    @NotNull
    private String uid;

    @Column(name = "ucode")
    @NotNull
    private String ucode;

    @Column(name = "phone_number")
    @NotNull
    private String phoneNumber;

    @Column(name = "employee_code")
    @NotNull
    private String employeeCode;

    @Column(name = "home_address")
    @NotNull
    @Size(min= 10, max= 40)
    private String homeAddress;

    @Column(name = "degree")
    @NotNull
    @Size(min= 3, max= 20)
    private String degree;

    @Column(name = "ability")
    @NotNull
    @Size(min= 5, max= 30)
    private String ability;

    @Column(name = "employee_type")
    @NotNull
    private String employeeType;

    @Column(name = "remain_morekhasi")
    @NotNull
    private Integer remainMorekhasi;

    @Column(name = "image_url")
    private String imageUrl;

    @OneToMany( mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PresentTimeEntity> presentTimeEntityList;

    @OneToOne(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private PaymentEntity paymentEntity;

    @OneToOne(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ContractEntity contractEntity;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DismissEntity> dismissEntityList;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DrugDeliveryEntity> drugDeliveryEntityList;

    @OneToMany(mappedBy = "employeeEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
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

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUcode() {
        return ucode;
    }

    public void setUcode(String ucode) {
        this.ucode = ucode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
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
