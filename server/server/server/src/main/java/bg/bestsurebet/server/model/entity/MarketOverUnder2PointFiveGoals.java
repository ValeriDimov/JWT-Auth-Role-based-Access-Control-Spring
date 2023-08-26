package bg.bestsurebet.server.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "markets_over_under_2_point_5_goals")
public class MarketOverUnder2PointFiveGoals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coefficient_over")
    private double coefficientOver;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientOverBookmaker;

    @Column(name = "coefficient_under")
    private double coefficientUnder;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientUnderBookmaker;

    @ManyToOne(targetEntity = Event.class, optional = false)
    private Event event;

    private double margin;

    public Long getId() {
        return id;
    }

    public MarketOverUnder2PointFiveGoals setId(Long id) {
        this.id = id;
        return this;
    }

    public double getCoefficientOver() {
        return coefficientOver;
    }

    public MarketOverUnder2PointFiveGoals setCoefficientOver(double coefficientOver) {
        this.coefficientOver = coefficientOver;
        return this;
    }

    public Bookmaker getCoefficientOverBookmaker() {
        return coefficientOverBookmaker;
    }

    public MarketOverUnder2PointFiveGoals setCoefficientOverBookmaker(Bookmaker coefficientOverBookmaker) {
        this.coefficientOverBookmaker = coefficientOverBookmaker;
        return this;
    }

    public double getCoefficientUnder() {
        return coefficientUnder;
    }

    public MarketOverUnder2PointFiveGoals setCoefficientUnder(double coefficientUnder) {
        this.coefficientUnder = coefficientUnder;
        return this;
    }

    public Bookmaker getCoefficientUnderBookmaker() {
        return coefficientUnderBookmaker;
    }

    public MarketOverUnder2PointFiveGoals setCoefficientUnderBookmaker(Bookmaker coefficientUnderBookmaker) {
        this.coefficientUnderBookmaker = coefficientUnderBookmaker;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public MarketOverUnder2PointFiveGoals setEvent(Event event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketOverUnder2PointFiveGoals setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}
