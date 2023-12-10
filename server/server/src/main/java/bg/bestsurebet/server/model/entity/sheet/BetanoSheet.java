package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Event;
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

    public Long getId() {
        return id;
    }

    public BetanoSheet setId(Long id) {
        this.id = id;
        return this;
    }

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
