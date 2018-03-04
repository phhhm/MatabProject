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
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min= 3,max= 15)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min= 4, max= 20)
    private String lastName;

    @Column(name = "certificate_code")
    @NotNull
    @Size(min = 1, max = 15)
    private String certificateCode;

    @Column(name = "national_code")
    @NotNull
    @Size(min = 7, max = 15)
    private String nationalCode;

    @Column(name = "father_name")
    @NotNull
    @Size(min= 3, max= 15)
    private String fatherName;

    @Column(name = "home_address")
    @NotNull
    @Size(min= 10, max= 40)
    private String homeAddress;

    @Column(name = "phone_number")
    @NotNull
    @Size(min = 6, max = 15)
    private String phoneNumber;

    @Column(name = "sex")
    @NotNull
    @Size(min = 2, max = 3)
    private String sex;

    @Column(name = "image_url", nullable = true)
    @Size(min = 5)
    private String imageUrl;

    @Column(name = "certificete_image_url", nullable = true)
    @Size(min = 5)
    private String certificateImageUrl;

    @Column(name = "national_card_image_url", nullable = true)
    @Size(min = 5)
    private String nationalCardImageUrl;

    @Column(name = "start_date")
    @NotNull
    @Size(min = 5, max = 20)
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

    public String getCertificateCode() {
        return certificateCode;
    }

    public void setCertificateCode(String certificateCode) {
        this.certificateCode = certificateCode;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
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
