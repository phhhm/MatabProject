package dal.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "visit_entity")
public class VisitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column
    @NotNull
    @Min(100000)
    private Long visitDate;

    @Column
    @NotNull
    @Min(100000)
    private Long nextVisitDate;

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
