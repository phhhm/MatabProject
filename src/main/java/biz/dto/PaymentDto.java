package biz.dto;

/**
 * Created by parham on 27/10/2017.
 */
public class PaymentDto {
    private Long id;
    private Long mainPayment;
    private Long bime;
    private Long kasri;
    private Long sanavat;
    private Integer maliat;
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(Long mainPayment) {
        this.mainPayment = mainPayment;
    }

    public Long getBime() {
        return bime;
    }

    public void setBime(Long bime) {
        this.bime = bime;
    }

    public Long getKasri() {
        return kasri;
    }

    public void setKasri(Long kasri) {
        this.kasri = kasri;
    }

    public Long getSanavat() {
        return sanavat;
    }

    public void setSanavat(Long sanavat) {
        this.sanavat = sanavat;
    }

    public Integer getMaliat() {
        return maliat;
    }

    public void setMaliat(Integer maliat) {
        this.maliat = maliat;
    }
}
