package bg.bestsurebet.server.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "markets_1x2")
public class Market1x2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "coefficient_1")
    private double coefficient1;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coef1Bookmaker;

    @Column(name = "coefficient_x")
    private double coefficientX;

    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coefXBookmaker;

    @Column(name = "coefficient_2")
    private double coefficient2;


    @ManyToOne(targetEntity = Bookmaker.class)
    private Bookmaker coef2Bookmaker;

    private double margin;

    @ManyToOne(targetEntity = Event.class, optional = false)
    private Event event;

    public Long getId() {
        return id;
    }

    public Market1x2 setId(Long id) {
        this.id = id;
        return this;
    }

    public double getCoefficient1() {
        return coefficient1;
    }

    public Market1x2 setCoefficient1(double coefficient1) {
        this.coefficient1 = coefficient1;
        return this;
    }

    public Bookmaker getCoef1Bookmaker() {
        return coef1Bookmaker;
    }

    public Market1x2 setCoef1Bookmaker(Bookmaker coef1Bookmaker) {
        this.coef1Bookmaker = coef1Bookmaker;
        return this;
    }

    public double getCoefficientX() {
        return coefficientX;
    }

    public Market1x2 setCoefficientX(double coefficientX) {
        this.coefficientX = coefficientX;
        return this;
    }

    public Bookmaker getCoefXBookmaker() {
        return coefXBookmaker;
    }

    public Market1x2 setCoefXBookmaker(Bookmaker coefXBookmaker) {
        this.coefXBookmaker = coefXBookmaker;
        return this;
    }

    public double getCoefficient2() {
        return coefficient2;
    }

    public Market1x2 setCoefficient2(double coefficient2) {
        this.coefficient2 = coefficient2;
        return this;
    }

    public Bookmaker getCoef2Bookmaker() {
        return coef2Bookmaker;
    }

    public Market1x2 setCoef2Bookmaker(Bookmaker coef2Bookmaker) {
        this.coef2Bookmaker = coef2Bookmaker;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public Market1x2 setEvent(Event event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public Market1x2 setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}
