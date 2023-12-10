package bg.bestsurebet.server.model.dto;

public class Market1x2DTO {

    private double coefficient1;

    private BookmakerDTO coef1Bookmaker;

    private double coefficientX;

    private BookmakerDTO coefXBookmaker;

    private double coefficient2;

    private BookmakerDTO coef2Bookmaker;

    private double margin;

    private EventDTO event;

    public double getCoefficient1() {
        return coefficient1;
    }

    public Market1x2DTO setCoefficient1(double coefficient1) {
        this.coefficient1 = coefficient1;
        return this;
    }

    public BookmakerDTO getCoef1Bookmaker() {
        return coef1Bookmaker;
    }

    public Market1x2DTO setCoef1Bookmaker(BookmakerDTO coef1Bookmaker) {
        this.coef1Bookmaker = coef1Bookmaker;
        return this;
    }

    public double getCoefficientX() {
        return coefficientX;
    }

    public Market1x2DTO setCoefficientX(double coefficientX) {
        this.coefficientX = coefficientX;
        return this;
    }

    public BookmakerDTO getCoefXBookmaker() {
        return coefXBookmaker;
    }

    public Market1x2DTO setCoefXBookmaker(BookmakerDTO coefXBookmaker) {
        this.coefXBookmaker = coefXBookmaker;
        return this;
    }

    public double getCoefficient2() {
        return coefficient2;
    }

    public Market1x2DTO setCoefficient2(double coefficient2) {
        this.coefficient2 = coefficient2;
        return this;
    }

    public BookmakerDTO getCoef2Bookmaker() {
        return coef2Bookmaker;
    }

    public Market1x2DTO setCoef2Bookmaker(BookmakerDTO coef2Bookmaker) {
        this.coef2Bookmaker = coef2Bookmaker;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public Market1x2DTO setMargin(double margin) {
        this.margin = margin;
        return this;
    }

    public EventDTO getEvent() {
        return event;
    }

    public Market1x2DTO setEvent(EventDTO event) {
        this.event = event;
        return this;
    }
}
