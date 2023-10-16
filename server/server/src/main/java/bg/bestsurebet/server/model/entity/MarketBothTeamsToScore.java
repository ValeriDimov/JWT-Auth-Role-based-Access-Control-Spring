package bg.bestsurebet.server.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "markets_both_teams_to_score")
public class MarketBothTeamsToScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coefficient_yes")
    private double coefficientYes;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientYesBookmaker;

    @Column(name = "coefficient_no")
    private double coefficientNo;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientNoBookmaker;

    @ManyToOne(targetEntity = Event.class, optional = false)
    private Event event;

    private double margin;

    public Long getId() {
        return id;
    }

    public MarketBothTeamsToScore setId(Long id) {
        this.id = id;
        return this;
    }

    public double getCoefficientYes() {
        return coefficientYes;
    }

    public MarketBothTeamsToScore setCoefficientYes(double coefficientYes) {
        this.coefficientYes = coefficientYes;
        return this;
    }

    public Bookmaker getCoefficientYesBookmaker() {
        return coefficientYesBookmaker;
    }

    public MarketBothTeamsToScore setCoefficientYesBookmaker(Bookmaker coefficientYesBookmaker) {
        this.coefficientYesBookmaker = coefficientYesBookmaker;
        return this;
    }

    public double getCoefficientNo() {
        return coefficientNo;
    }

    public MarketBothTeamsToScore setCoefficientNo(double coefficientNo) {
        this.coefficientNo = coefficientNo;
        return this;
    }

    public Bookmaker getCoefficientNoBookmaker() {
        return coefficientNoBookmaker;
    }

    public MarketBothTeamsToScore setCoefficientNoBookmaker(Bookmaker coefficientNoBookmaker) {
        this.coefficientNoBookmaker = coefficientNoBookmaker;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public MarketBothTeamsToScore setEvent(Event event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketBothTeamsToScore setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}

