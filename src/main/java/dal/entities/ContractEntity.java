package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "contract_entity")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "mablagh")
    @NotNull
    @Size(min = 4, max = 10)
    private String mablagh;

    @Column(name = "start_contract_time")
    @NotNull
    @Size(min = 6, max = 20)
    private String startContractTime;

    @Column(name = "end_contract_time")
    @NotNull
    @Size(min = 6, max = 20)
    private String endContractTime;

    @OneToOne(fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMablagh() {
        return mablagh;
    }

    public void setMablagh(String mablagh) {
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

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
