package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Column
    @NotNull
    @Size(min= 3,max= 15)
    private String firstName;

    @Column
    @NotNull
    @Size(min= 4, max= 20)
    private String lastName;

    @Column
    @NotNull
    @Min(1)
    private Long certificateCode;

    @Column
    @NotNull
    @Min(10000)
    private Long nationalCode;

    @Column
    @NotNull
    @Size(min= 3, max= 15)
    private String fatherName;

    @Column
    @NotNull
    @Size(min= 10, max= 40)
    private String homeAddress;

    @Column
    @NotNull
    @Size(min= 6, max= 15)
    private Long phoneNumber;

    @Column
    @NotNull
    @Size(min = 2, max = 3)
    private String sex;

    @Column
    @NotNull
    private String imageUrl;

    @Column
    @NotNull
    private String certificateImageUrl;

    @Column
    @NotNull
    private String nationalCardImageUrl;

    @Column
    @NotNull
    @Min(100000)
    private Long startDate;

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

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }
}
