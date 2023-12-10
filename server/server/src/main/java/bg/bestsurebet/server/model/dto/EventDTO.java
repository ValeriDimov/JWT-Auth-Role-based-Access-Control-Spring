package bg.bestsurebet.server.model.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventDTO {

    private LocalDate date;

    private LocalTime time;

    private TeamDTO teamOne;

    private TeamDTO teamTwo;

    private ChampionshipDTO championship;

    public LocalDate getDate() {
        return date;
    }

    public EventDTO setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LocalTime getTime() {
        return time;
    }

    public EventDTO setTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public TeamDTO getTeamOne() {
        return teamOne;
    }

    public EventDTO setTeamOne(TeamDTO teamOne) {
        this.teamOne = teamOne;
        return this;
    }

    public TeamDTO getTeamTwo() {
        return teamTwo;
    }

    public EventDTO setTeamTwo(TeamDTO teamTwo) {
        this.teamTwo = teamTwo;
        return this;
    }

    public ChampionshipDTO getChampionship() {
        return championship;
    }

    public EventDTO setChampionship(ChampionshipDTO championship) {
        this.championship = championship;
        return this;
    }
}
