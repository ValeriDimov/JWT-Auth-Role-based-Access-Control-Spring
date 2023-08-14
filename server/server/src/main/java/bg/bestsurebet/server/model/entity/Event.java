package bg.bestsurebet.server.model.entity;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String identifier;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalTime time;

    @ManyToOne(targetEntity = Team.class, optional = false)
    private Team teamOne;

    @ManyToOne(targetEntity = Team.class, optional = false)
    private Team teamTwo;

    @ManyToOne(targetEntity = Championship.class)
    private Championship championship;

    public Long getId() {
        return id;
    }

    public Event setId(Long id) {
        this.id = id;
        return this;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Event setIdentifier(String identifier) {
        this.identifier = identifier;
        return this;
    }

    public LocalDate getDate() {
        return date;
    }

    public Event setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public Event setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Event setTeamOne(Team teamOne) {
        this.teamOne = teamOne;
        return this;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public Event setTeamTwo(Team teamTwo) {
        this.teamTwo = teamTwo;
        return this;
    }

    public Championship getChampionship() {
        return championship;
    }

    public Event setChampionship(Championship championship) {
        this.championship = championship;
        return this;
    }
}
