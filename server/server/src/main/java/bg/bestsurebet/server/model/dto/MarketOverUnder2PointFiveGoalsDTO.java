package bg.bestsurebet.server.model.dto;

public class MarketOverUnder2PointFiveGoalsDTO {

    private double coefficientOver;

    private BookmakerDTO coefficientOverBookmaker;

    private double coefficientUnder;

    private BookmakerDTO coefficientUnderBookmaker;

    private EventDTO event;

    private double margin;

    public double getCoefficientOver() {
        return coefficientOver;
    }

    public MarketOverUnder2PointFiveGoalsDTO setCoefficientOver(double coefficientOver) {
        this.coefficientOver = coefficientOver;
        return this;
    }

    public BookmakerDTO getCoefficientOverBookmaker() {
        return coefficientOverBookmaker;
    }

    public MarketOverUnder2PointFiveGoalsDTO setCoefficientOverBookmaker(BookmakerDTO coefficientOverBookmaker) {
        this.coefficientOverBookmaker = coefficientOverBookmaker;
        return this;
    }

    public double getCoefficientUnder() {
        return coefficientUnder;
    }

    public MarketOverUnder2PointFiveGoalsDTO setCoefficientUnder(double coefficientUnder) {
        this.coefficientUnder = coefficientUnder;
        return this;
    }

    public BookmakerDTO getCoefficientUnderBookmaker() {
        return coefficientUnderBookmaker;
    }

    public MarketOverUnder2PointFiveGoalsDTO setCoefficientUnderBookmaker(BookmakerDTO coefficientUnderBookmaker) {
        this.coefficientUnderBookmaker = coefficientUnderBookmaker;
        return this;
    }

    public EventDTO getEvent() {
        return event;
    }

    public MarketOverUnder2PointFiveGoalsDTO setEvent(EventDTO event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketOverUnder2PointFiveGoalsDTO setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}
