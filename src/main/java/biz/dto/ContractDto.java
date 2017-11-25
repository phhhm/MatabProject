package biz.dto;

import java.util.Date;

/**
 * Created by parham on 27/10/2017.
 */
public class ContractDto {
    private Long id;
    private Long mablagh;
    private Long startContractTime;
    private Long endContractTime;
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

    public Long getStartContractTime() {
        return startContractTime;
    }

    public void setStartContractTime(Long startContractTime) {
        this.startContractTime = startContractTime;
    }

    public Long getEndContractTime() {
        return endContractTime;
    }

    public void setEndContractTime(Long endContractTime) {
        this.endContractTime = endContractTime;
    }
}
