package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "visit_entity")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(name = "visit_date")
    @NotNull
    @Size(min = 5,max = 20)
    private String visitDate;

    @Column(name = "next_visit_date")
    @NotNull
    @Size(min = 5,max = 20)
    private String nextVisitDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", nullable = false)
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "file_id", nullable = false)
    private FileEntity fileEntity;

    @OneToOne(mappedBy = "visitEntity", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private PrescriptionEntity prescriptionEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getNextVisitDate() {
        return nextVisitDate;
    }

    public void setNextVisitDate(String nextVisitDate) {
        this.nextVisitDate = nextVisitDate;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public FileEntity getFileEntity() {
        return fileEntity;
    }

    public void setFileEntity(FileEntity fileEntity) {
        this.fileEntity = fileEntity;
    }

    public PrescriptionEntity getPrescriptionEntity() {
        return prescriptionEntity;
    }

    public void setPrescriptionEntity(PrescriptionEntity prescriptionEntity) {
        this.prescriptionEntity = prescriptionEntity;
    }
}
