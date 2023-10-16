package bg.bestsurebet.server.model.entity.sheet;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.Market1x2;
import jakarta.persistence.*;

@Entity
@Table(name = "efbet_sheets")
public class EfbetSheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Event.class)
    private Event event;

    @Column(unique = true, nullable = false)
    private String identifier;

    private String oneXTwo;

    public Long getId() {
        return id;
    }

    public EfbetSheet setId(Long id) {
        this.id = id;
        return this;
    }

    public Event getEvent() {
        return event;
    }

    public EfbetSheet setEvent(Event event) {
        this.event = event;
        return this;
    }

    public String getOneXTwo() {
        return oneXTwo;
    }

    public EfbetSheet setOneXTwo(String oneXTwo) {
        this.oneXTwo = oneXTwo;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public EfbetSheet setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }
}
