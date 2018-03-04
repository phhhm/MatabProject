package dal.entities;
import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by parham on 27/10/2017.
 */
@Entity
@Table(name = "present_time_entity")
public class PresentTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "start_time")
    @NotNull
    @Size(min= 5, max= 20)
    private String startTime;

    @Column(name = "end_time")
    @NotNull
    @Size(min= 5, max= 20)
    private String endTime;

    @Column(name = "week_day")
    @NotNull
    @Size(min= 4, max= 8)
    private String weekDay;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }
}
