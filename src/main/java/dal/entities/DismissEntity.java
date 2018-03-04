package dal.entities;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "dismiss_entity")
public class DismissEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "from_date")
    @NotNull
    @Size(max = 20, min = 5)
    private String fromDate;

    @Column(name = "until_date")
    @NotNull
    @Size(max = 20, min = 5)
    private String untilDate;

    @ManyToOne( fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getUntilDate() {
        return untilDate;
    }

    public void setUntilDate(String untilDate) {
        this.untilDate = untilDate;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
