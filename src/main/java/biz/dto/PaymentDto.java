package biz.dto;

/**
 * Created by parham on 27/10/2017.
 */
public class PaymentDto {
    private String id;
    private String mainPayment;
    private String bime;
    private String kasri;
    private String sanavat;
    private String maliat;
    private Long employeeId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainPayment() {
        return mainPayment;
    }

    public void setMainPayment(String mainPayment) {
        this.mainPayment = mainPayment;
    }

    public String getBime() {
        return bime;
    }

    public void setBime(String bime) {
        this.bime = bime;
    }

    public String getKasri() {
        return kasri;
    }

    public void setKasri(String kasri) {
        this.kasri = kasri;
    }

    public String getSanavat() {
        return sanavat;
    }

    public void setSanavat(String sanavat) {
        this.sanavat = sanavat;
    }

    public String getMaliat() {
        return maliat;
    }

    public void setMaliat(String maliat) {
        this.maliat = maliat;
    }
}
