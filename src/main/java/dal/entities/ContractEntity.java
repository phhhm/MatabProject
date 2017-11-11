package dal.entities;

import javax.persistence.*;


@Entity
@Table(name = "contract_entity")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long mablagh;

    @Column(nullable = false)
    private String startContractTime;

    @Column(nullable = false)
    private String endContractTime;

    @OneToOne(fetch = FetchType.LAZY)
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
