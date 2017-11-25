package biz.dto;

/**
 * Created by parham on 10/28/2017.
 */
public class FileDto {
    private Long id;
    private Long fileCode;
    private String consumableDrugs;
    private Long endDate;
    private Long startDate;
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

    public String  getConsumableDrugs() {
        return consumableDrugs;
    }

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public void setConsumableDrugs(String consumableDrugs) {
        this.consumableDrugs = consumableDrugs;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
