package biz.dto;

import java.awt.*;

/**
 * Created by parham on 26/10/2017.
 */
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String uid;
    private String ucode;
    private String phoneNumber;
    private String employeeCode;
    private String homeAddress;
    private String degree;
    private String ability;
    private String employeeType;
    private Integer remainMorekhasi;
    private String imageUrl;

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

    public String getImage() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
