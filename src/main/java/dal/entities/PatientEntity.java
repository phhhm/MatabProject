package dal.entities;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;

/**
 * Created by parham on 10/28/2017.
 */
@Entity
@Table(name = "patient_entity")
public class PatientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long certificateCode;

    @Column(nullable = false)
    private Long nationalCode;

    @Column(nullable = false)
    private String fatherName;

    @Column(nullable = false)
    private String homeAddress;

    @Column(nullable = false)
    private Long phoneNumber;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private String certificateImageUrl;

    @Column(nullable = false)
    private String nationalCardImageUrl;

    @Column(nullable = false)
    private String startDate;

    @OneToOne(mappedBy = "patientEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private FileEntity fileEntity;

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

    public Long getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(Long certificateCode) {
        this.certificateCode = certificateCode;
    }

    public Long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Long nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCertificateImageUrl() {
        return certificateImageUrl;
    }

    public void setCertificateImageUrl(String certificateImageUrl) {
        this.certificateImageUrl = certificateImageUrl;
    }

    public String getNationalCardImageUrl() {
        return nationalCardImageUrl;
    }

    public void setNationalCardImageUrl(String nationalCardImageUrl) {
        this.nationalCardImageUrl = nationalCardImageUrl;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }
}
