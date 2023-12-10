package bg.bestsurebet.server.model.dto;

public class ChampionshipDTO {

    private String name;

    private String countryOrTournament;

    private SportDTO sport;

    public String getName() {
        return name;
    }

    public ChampionshipDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOrTournament() {
        return countryOrTournament;
    }

    public ChampionshipDTO setCountryOrTournament(String countryOrTournament) {
        this.countryOrTournament = countryOrTournament;
        return this;
    }

    public SportDTO getSportDTO() {
        return sport;
    }

    public ChampionshipDTO setSportDTO(SportDTO sport) {
        this.sport = sport;
        return this;
    }
}
