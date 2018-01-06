package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "contract_entity")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    @NotNull
    @Min(100000)
    private Long mablagh;

    @Column
    @NotNull
    @Min(100000)
    private Long startContractTime;

    @Column
    @NotNull
    @Min(100000)
    private Long endContractTime;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

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

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
