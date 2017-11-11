package biz.dto;

import java.util.Date;

/**
 * Created by parham on 27/10/2017.
 */
public class ContractDto {
    private Long id;
    private Long mablagh;
    private String startContractTime;
    private String endContractTime;
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

    public Long getMablagh() {
        return mablagh;
    }

    public void setMablagh(Long mablagh) {
        this.mablagh = mablagh;
    }

    public String getStartContractTime() {
        return startContractTime;
    }

    public void setStartContractTime(String startContractTime) {
        this.startContractTime = startContractTime;
    }

    public String getEndContractTime() {
        return endContractTime;
    }

    public void setEndContractTime(String endContractTime) {
        this.endContractTime = endContractTime;
    }
}
