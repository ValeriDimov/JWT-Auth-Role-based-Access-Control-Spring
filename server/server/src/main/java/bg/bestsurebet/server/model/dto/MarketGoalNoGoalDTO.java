package bg.bestsurebet.server.model.dto;

public class MarketGoalNoGoalDTO {

    private double coefficientGoal;

    private BookmakerDTO coefficientGoalBookmaker;

    private double coefficientNoGoal;

    private BookmakerDTO coefficientNoGoalBookmaker;

    private EventDTO event;

    private double margin;

    public double getCoefficientGoal() {
        return coefficientGoal;
    }

    public MarketGoalNoGoalDTO setCoefficientGoal(double coefficientGoal) {
        this.coefficientGoal = coefficientGoal;
        return this;
    }

    public BookmakerDTO getCoefficientGoalBookmaker() {
        return coefficientGoalBookmaker;
    }

    public MarketGoalNoGoalDTO setCoefficientGoalBookmaker(BookmakerDTO coefficientGoalBookmaker) {
        this.coefficientGoalBookmaker = coefficientGoalBookmaker;
        return this;
    }

    public double getCoefficientNoGoal() {
        return coefficientNoGoal;
    }

    public MarketGoalNoGoalDTO setCoefficientNoGoal(double coefficientNoGoal) {
        this.coefficientNoGoal = coefficientNoGoal;
        return this;
    }

    public BookmakerDTO getCoefficientNoGoalBookmaker() {
        return coefficientNoGoalBookmaker;
    }

    public MarketGoalNoGoalDTO setCoefficientNoGoalBookmaker(BookmakerDTO coefficientNoGoalBookmaker) {
        this.coefficientNoGoalBookmaker = coefficientNoGoalBookmaker;
        return this;
    }

    public EventDTO getEvent() {
        return event;
    }

    public MarketGoalNoGoalDTO setEvent(EventDTO event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketGoalNoGoalDTO setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}

