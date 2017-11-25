package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @NotNull
    private Long id;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 15)
    private String firstName;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 4, integer = 20)
    private String lastName;

    @Column(nullable = false)
    @NotNull
    @Min(1)
    private Long certificateCode;

    @Column(nullable = false)
    @NotNull
    @Min(10000)
    private Long nationalCode;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 3, integer = 15)
    private String fatherName;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 10, integer = 40)
    private String homeAddress;

    @Column(nullable = false)
    @NotNull
    @Digits(fraction = 6, integer = 15)
    private Long phoneNumber;

    @Column(nullable = false)
    @NotNull
    private String sex;

    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "[a-z]+www+.+[a-z]+.+", message = "invalid url")
    private String imageUrl;

    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "[a-z]+www+.+[a-z]+.+", message = "invalid url")
    private String certificateImageUrl;

    @Column(nullable = false)
    @NotNull
    @Pattern(regexp = "[a-z]+www+.+[a-z]+.+", message = "invalid url")
    private String nationalCardImageUrl;

    @Column(nullable = false)
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
