package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Event;
import jakarta.persistence.*;

@Entity
@Table(name = "winbet_sheets")
public class WinbetSheet {

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

    public WinbetSheet setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public WinbetSheet setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public WinbetSheet setEvent(Event event) {
        this.event = event;
        return this;
    }

    public String getOneXTwo() {
        return oneXTwo;
    }

    public WinbetSheet setOneXTwo(String oneXTwo) {
        this.oneXTwo = oneXTwo;
        return this;
    }

    public String getBothTeamsToScore() {
        return bothTeamsToScore;
    }

    public WinbetSheet setBothTeamsToScore(String bothTeamsToScore) {
        this.bothTeamsToScore = bothTeamsToScore;
        return this;
    }

    public String getOverUnder() {
        return overUnder;
    }

    public WinbetSheet setOverUnder(String overUnder) {
        this.overUnder = overUnder;
        return this;
    }
}
