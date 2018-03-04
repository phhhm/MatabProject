package dal.entities;

        import javax.persistence.*;
        import javax.validation.constraints.Min;
        import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cost_entity")
public class CostEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(nullable = false, name = "id")
        private Long id;

        @Column(name = "sell")
        @NotNull
        private String sell;

        @Column(name = "buy")
        @NotNull
        private String buy;

        @Column(name = "date")
        @NotNull
        private String date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drug_id", nullable = false)
    private DrugEntity drugEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DrugEntity getDrugEntity() {
        return drugEntity;
    }

    public void setDrugEntity(DrugEntity drugEntity) {
        this.drugEntity = drugEntity;
    }
}
