package bg.bestsurebet.server.model.dto;

public class MarketBothTeamsToScoreDTO {

    private double coefficientYes;

    private BookmakerDTO coefficientYesBookmaker;

    private double coefficientNo;

    private BookmakerDTO coefficientNoBookmaker;

    private EventDTO event;

    private double margin;

    public double getCoefficientYes() {
        return coefficientYes;
    }

    public MarketBothTeamsToScoreDTO setCoefficientYes(double coefficientYes) {
        this.coefficientYes = coefficientYes;
        return this;
    }

    public BookmakerDTO getCoefficientYesBookmaker() {
        return coefficientYesBookmaker;
    }

    public MarketBothTeamsToScoreDTO setCoefficientYesBookmaker(BookmakerDTO coefficientYesBookmaker) {
        this.coefficientYesBookmaker = coefficientYesBookmaker;
        return this;
    }

    public double getCoefficientNo() {
        return coefficientNo;
    }

    public MarketBothTeamsToScoreDTO setCoefficientNo(double coefficientNo) {
        this.coefficientNo = coefficientNo;
        return this;
    }

    public BookmakerDTO getCoefficientNoBookmaker() {
        return coefficientNoBookmaker;
    }

    public MarketBothTeamsToScoreDTO setCoefficientNoBookmaker(BookmakerDTO coefficientNoBookmaker) {
        this.coefficientNoBookmaker = coefficientNoBookmaker;
        return this;
    }

    public EventDTO getEvent() {
        return event;
    }

    public MarketBothTeamsToScoreDTO setEvent(EventDTO event) {
        this.event = event;
        return this;
    }

    public double getMargin() {
        return margin;
    }

    public MarketBothTeamsToScoreDTO setMargin(double margin) {
        this.margin = margin;
        return this;
    }
}

