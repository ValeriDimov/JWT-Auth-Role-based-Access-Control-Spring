package bg.bestsurebet.server.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "markets_goal_no_goal")
public class MarketGoalNoGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coefficient_goal")
    private double coefficientGoal;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientGoalBookmaker;

    @Column(name = "coefficient_no_goal")
    private double coefficientNoGoal;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefficientNoGoalBookmaker;

    @ManyToOne(targetEntity = Event.class, optional = false)
    private Event event;

    private double margin;

    public Long getId() {
        return id;
    }

    public MarketGoalNoGoal setId(Long id) {
        this.id = id;
        return this;
    }

    public double getCoefficientGoal() {
        return coefficientGoal;
    }

    public MarketGoalNoGoal setCoefficientGoal(double coefficientGoal) {
        this.coefficientGoal = coefficientGoal;
        return this;
    }

    public Bookmaker getCoefficientGoalBookmaker() {
        return coefficientGoalBookmaker;
    }

    public MarketGoalNoGoal setCoefficientGoalBookmaker(Bookmaker coefficientGoalBookmaker) {
        this.coefficientGoalBookmaker = coefficientGoalBookmaker;
        return this;
    }

    public double getCoefficientNoGoal() {
        return coefficientNoGoal;
    }

    public MarketGoalNoGoal setCoefficientNoGoal(double coefficientNoGoal) {
        this.coefficientNoGoal = coefficientNoGoal;
        return this;
    }

    public Bookmaker getCoefficientNoGoalBookmaker() {
        return coefficientNoGoalBookmaker;
    }

    public MarketGoalNoGoal setCoefficientNoGoalBookmaker(Bookmaker coefficientNoGoalBookmaker) {
        this.coefficientNoGoalBookmaker = coefficientNoGoalBookmaker;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public MarketGoalNoGoal setEvent(Event event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketGoalNoGoal setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}

