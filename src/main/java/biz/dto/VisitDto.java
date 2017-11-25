package biz.dto;

public class VisitDto {

    private Long id;
    private Long visitDate;
    private Long nextVisitDate;
    private Long employeeId;
    private Long fileId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Long visitDate) {
        this.visitDate = visitDate;
    }

    public Long getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(Long nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }
}
