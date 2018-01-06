package dal.entities;

        import javax.persistence.*;
        import javax.validation.constraints.Min;
        import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cost_entity")
public class CostEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false)
        private Long id;

        @Column
        @NotNull
        @Min(100)
        private Long sell;

        @Column
        @NotNull
        @Min(100)
        private Long buy;

        @Column
        @NotNull
        @Min(100000)
        private Long date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugEntity drugEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSell() {
        return sell;
    }

    public void setSell(Long sell) {
        this.sell = sell;
    }

    public Long getBuy() {
        return buy;
    }

    public void setBuy(Long buy) {
        this.buy = buy;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public DrugEntity getDrugEntity() {
        return drugEntity;
    }

    public void setDrugEntity(DrugEntity drugEntity) {
        this.drugEntity = drugEntity;
    }
}
