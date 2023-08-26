package bg.bestsurebet.server.model.dto;

public class EventAndMarketsDTO {

    private String date;

    private String time;

    private String teamOne;

    private String teamTwo;

    private String championshipName;

    private double market1x2Coefficient1;

    private double market1x2CoefficientX;

    private double market1x2Coefficient2;

    private double market1x2Margin;

    private double marketGoalNoGoalCoefficientGoal;

    private double marketGoalNoGoalCoefficientNoGoal;

    private double marketGoalNoGoalMargin;

    private double marketOverUnder2PointFiveGoalsCoefficientOver;

    private double marketOverUnder2PointFiveGoalsCoefficientUnder;

    private double marketOverUnder2PointFiveGoalsMargin;

    public String getDate() {
        return date;
    }

    public EventAndMarketsDTO setDate(String date) {
        this.date = date;
        return this;
    }

    public String getTime() {
        return time;
    }

    public EventAndMarketsDTO setTime(String time) {
        this.time = time;
        return this;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public EventAndMarketsDTO setTeamOne(String teamOne) {
        this.teamOne = teamOne;
        return this;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public EventAndMarketsDTO setTeamTwo(String teamTwo) {
        this.teamTwo = teamTwo;
        return this;
    }

    public String getChampionshipName() {
        return championshipName;
    }

    public EventAndMarketsDTO setChampionshipName(String championshipName) {
        this.championshipName = championshipName;
        return this;
    }

    public double getMarket1x2Coefficient1() {
        return market1x2Coefficient1;
    }

    public EventAndMarketsDTO setMarket1x2Coefficient1(double market1x2Coefficient1) {
        this.market1x2Coefficient1 = market1x2Coefficient1;
        return this;
    }

    public double getMarket1x2CoefficientX() {
        return market1x2CoefficientX;
    }

    public EventAndMarketsDTO setMarket1x2CoefficientX(double market1x2CoefficientX) {
        this.market1x2CoefficientX = market1x2CoefficientX;
        return this;
    }

    public double getMarket1x2Coefficient2() {
        return market1x2Coefficient2;
    }

    public EventAndMarketsDTO setMarket1x2Coefficient2(double market1x2Coefficient2) {
        this.market1x2Coefficient2 = market1x2Coefficient2;
        return this;
    }

    public double getMarketGoalNoGoalCoefficientGoal() {
        return marketGoalNoGoalCoefficientGoal;
    }

    public EventAndMarketsDTO setMarketGoalNoGoalCoefficientGoal(double marketGoalNoGoalCoefficientGoal) {
        this.marketGoalNoGoalCoefficientGoal = marketGoalNoGoalCoefficientGoal;
        return this;
    }

    public double getMarketGoalNoGoalCoefficientNoGoal() {
        return marketGoalNoGoalCoefficientNoGoal;
    }

    public EventAndMarketsDTO setMarketGoalNoGoalCoefficientNoGoal(double marketGoalNoGoalCoefficientNoGoal) {
        this.marketGoalNoGoalCoefficientNoGoal = marketGoalNoGoalCoefficientNoGoal;
        return this;
    }

    public double getMarketOverUnder2PointFiveGoalsCoefficientOver() {
        return marketOverUnder2PointFiveGoalsCoefficientOver;
    }

    public EventAndMarketsDTO setMarketOverUnder2PointFiveGoalsCoefficientOver(double marketOverUnder2PointFiveGoalsCoefficientOver) {
        this.marketOverUnder2PointFiveGoalsCoefficientOver = marketOverUnder2PointFiveGoalsCoefficientOver;
        return this;
    }

    public double getMarketOverUnder2PointFiveGoalsCoefficientUnder() {
        return marketOverUnder2PointFiveGoalsCoefficientUnder;
    }

    public EventAndMarketsDTO setMarketOverUnder2PointFiveGoalsCoefficientUnder(double marketOverUnder2PointFiveGoalsCoefficientUnder) {
        this.marketOverUnder2PointFiveGoalsCoefficientUnder = marketOverUnder2PointFiveGoalsCoefficientUnder;
        return this;
    }

    public double getMarket1x2Margin() {
        return market1x2Margin;
    }

    public EventAndMarketsDTO setMarket1x2Margin(double market1x2Margin) {
        this.market1x2Margin = market1x2Margin;
        return this;
    }

    public double getMarketGoalNoGoalMargin() {
        return marketGoalNoGoalMargin;
    }

    public EventAndMarketsDTO setMarketGoalNoGoalMargin(double marketGoalNoGoalMargin) {
        this.marketGoalNoGoalMargin = marketGoalNoGoalMargin;
        return this;
    }

    public double getMarketOverUnder2PointFiveGoalsMargin() {
        return marketOverUnder2PointFiveGoalsMargin;
    }

    public EventAndMarketsDTO setMarketOverUnder2PointFiveGoalsMargin(double marketOverUnder2PointFiveGoalsMargin) {
        this.marketOverUnder2PointFiveGoalsMargin = marketOverUnder2PointFiveGoalsMargin;
        return this;
    }
}
