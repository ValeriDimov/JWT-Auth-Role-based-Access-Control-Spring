package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Event;
import jakarta.persistence.*;

@Entity
@Table(name = "inbet_sheets")
public class InbetSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Event.class)
    private Event event;

    @Column(unique = true, nullable = false)
    private String identifier;

    private String oneXTwo;

    private String bothTeamsToScore;

    private String overUnder;

    public Long getId() {
        return id;
    }

    public InbetSheet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public InbetSheet setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public InbetSheet setEvent(Event event) {
        this.event = event;
        return this;
    }

    public String getOneXTwo() {
        return oneXTwo;
    }

    public InbetSheet setOneXTwo(String oneXTwo) {
        this.oneXTwo = oneXTwo;
        return this;
    }

    public String getBothTeamsToScore() {
        return bothTeamsToScore;
    }

    public InbetSheet setBothTeamsToScore(String bothTeamsToScore) {
        this.bothTeamsToScore = bothTeamsToScore;
        return this;
    }

    public String getOverUnder() {
        return overUnder;
    }

    public InbetSheet setOverUnder(String overUnder) {
        this.overUnder = overUnder;
        return this;
    }
}
