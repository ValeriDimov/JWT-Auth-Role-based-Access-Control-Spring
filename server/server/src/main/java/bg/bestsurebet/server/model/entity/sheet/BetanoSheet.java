package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.Market1x2;
import bg.bestsurebet.server.model.entity.MarketGoalNoGoal;
import bg.bestsurebet.server.model.entity.MarketOverUnder2PointFiveGoals;
import jakarta.persistence.*;

@Entity
@Table(name = "betano_sheets")
public class BetanoSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Event.class)
    private Event event;

    @Column(unique = true, nullable = false)
    private String identifier;

    private String oneXTwo;

    private String goalNoGoal;

    private String overUnder;

//    @ManyToOne(targetEntity = Market1x2.class)
//    private Market1x2 market1x2;
//
//    @ManyToOne(targetEntity = MarketGoalNoGoal.class)
//    private MarketGoalNoGoal marketGoalNoGoal;
//
//    @ManyToOne(targetEntity = MarketOverUnder2PointFiveGoals.class)
//    private MarketOverUnder2PointFiveGoals marketOverUnder2PointFiveGoals;

    public Long getId() {
        return id;
    }

    public BetanoSheet setId(Long id) {
        this.id = id;
        return this;
    }

//    public Market1x2 getMarket1x2() {
//        return market1x2;
//    }
//
//    public BetanoSheet setMarket1x2(Market1x2 market1x2) {
//        this.market1x2 = market1x2;
//        return this;
//    }

//    public MarketGoalNoGoal getMarketGoalNoGoal() {
//        return marketGoalNoGoal;
//    }
//
//    public BetanoSheet setMarketGoalNoGoal(MarketGoalNoGoal marketGoalNoGoal) {
//        this.marketGoalNoGoal = marketGoalNoGoal;
//        return this;
//    }
//
//    public MarketOverUnder2PointFiveGoals getMarketOverUnder2PointFiveGoals() {
//        return marketOverUnder2PointFiveGoals;
//    }
//
//    public BetanoSheet setMarketOverUnder2PointFiveGoals(MarketOverUnder2PointFiveGoals marketOverUnder2PointFiveGoals) {
//        this.marketOverUnder2PointFiveGoals = marketOverUnder2PointFiveGoals;
//        return this;
//    }

    public String getIdentifier() {
        return identifier;
    }

    public BetanoSheet setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public BetanoSheet setEvent(Event event) {
        this.event = event;
        return this;
    }

    public String getOneXTwo() {
        return oneXTwo;
    }

    public BetanoSheet setOneXTwo(String oneXTwo) {
        this.oneXTwo = oneXTwo;
        return this;
    }

    public String getGoalNoGoal() {
        return goalNoGoal;
    }

    public BetanoSheet setGoalNoGoal(String goalNoGoal) {
        this.goalNoGoal = goalNoGoal;
        return this;
    }

    public String getOverUnder() {
        return overUnder;
    }

    public BetanoSheet setOverUnder(String overUnder) {
        this.overUnder = overUnder;
        return this;
    }
}
