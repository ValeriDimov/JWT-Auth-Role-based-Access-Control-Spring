package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Market1x2;
import jakarta.persistence.*;

@Entity
@Table(name = "efbet_sheets")
public class EfbetSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String identifier;

    @ManyToOne(targetEntity = Market1x2.class)
    private Market1x2 market1x2;

    public Long getId() {
        return id;
    }

    public EfbetSheet setId(Long id) {
        this.id = id;
        return this;
    }

    public Market1x2 getMarket1x2() {
        return market1x2;
    }

    public EfbetSheet setMarket1x2(Market1x2 market1x2) {
        this.market1x2 = market1x2;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public EfbetSheet setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }
}
