package biz.dto;

/**
 * Created by parham on 10/28/2017.
 */
public class FileDto {
    private Long id;
    private Long fileCode;
    private String consumableDrugs;
    private String prescription;
    private String consumableDose;
    private String description;
    private Long patientId;
    private Long transactionId;

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileCode() {
        return fileCode;
    }

    public void setFileCode(Long fileCode) {
        this.fileCode = fileCode;
    }

    public String getConsumableDrugs() {
        return consumableDrugs;
    }

    public void setConsumableDrugs(String consumableDrugs) {
        this.consumableDrugs = consumableDrugs;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getConsumableDose() {
        return consumableDose;
    }

    public void setConsumableDose(String consumableDose) {
        this.consumableDose = consumableDose;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
