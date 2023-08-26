package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Championship;
import bg.bestsurebet.server.model.entity.Sport;
import bg.bestsurebet.server.model.entity.Team;
import bg.bestsurebet.server.model.entity.TeamNomenclature;
import bg.bestsurebet.server.repository.TeamNomenclatureRepository;
import bg.bestsurebet.server.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final TeamNomenclatureRepository teamNomenclatureRepository;

    public TeamService(TeamRepository teamRepository, TeamNomenclatureRepository teamNomenclatureRepository) {
        this.teamRepository = teamRepository;
        this.teamNomenclatureRepository = teamNomenclatureRepository;
    }

    public Team findTeamByName(String name, String bookmakerName) {
        String teamName = findTeamNameFromNomenclature(name, bookmakerName);

        Optional<Team> optionalTeam = this.teamRepository.findByName(teamName);

        return optionalTeam.isPresent() ? optionalTeam.get() : this.teamRepository.save(new Team().setName(teamName));

    }

    //TODO: Championship logic enhancement is required for non-national club tournaments;
    public  Championship findTeamsChampionship(String teamNameOne, String teamNameTwo, String bookmakerName) {

        return championshipFinder(teamNameOne, teamNameTwo, bookmakerName);
    }

    public Team save(Team newTeam) {
        return this.teamRepository.save(newTeam);
    }

    private String findTeamNameFromNomenclature(String name, String bookmakerName) {
        String teamName = "";

        switch (bookmakerName) {
            case "www.betano.bg":
                Optional<TeamNomenclature> nameBetano = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameBetano(name);
                teamName = nameBetano.isPresent() ? nameBetano.get().getTeamNameMain() : name;
                break;

            case "www.efbet.com":
                Optional<TeamNomenclature> nameEfbet = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameEfbet(name);
                teamName = nameEfbet.isPresent() ? nameEfbet.get().getTeamNameMain() : name;
                break;

            default:
                teamName = name;
                break;
        }

        return teamName;
    }

    private Championship championshipFinder(String teamNameOne, String teamNameTwo, String bookmakerName) {
        Championship championship = null;

        switch (bookmakerName) {
            case "www.betano.bg":
                Optional<TeamNomenclature> teamChampionshipBetano1 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameBetano(teamNameOne);
                Championship championshipBetano1 = teamChampionshipBetano1.isPresent() ? teamChampionshipBetano1.get().getChampionship() :
                        new Championship().setName("Unknown1").setCountryOrTournament("Unknown tournament1").setSport(new Sport().setType("Football"));

                Optional<TeamNomenclature> teamChampionshipBetano2 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameBetano(teamNameTwo);
                Championship championshipBetano2 = teamChampionshipBetano2.isPresent() ? teamChampionshipBetano2.get().getChampionship() :
                        new Championship().setName("Unknown2").setCountryOrTournament("Unknown tournament1").setSport(new Sport().setType("Football"));

                if (championshipBetano1.equals(championshipBetano2)) {
                    championship = championshipBetano1;
                }
                break;

            case "www.efbet.com":
                Optional<TeamNomenclature> teamChampionshipEfbet1 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameEfbet(teamNameOne);
                Championship championshipEfbet1 = teamChampionshipEfbet1.isPresent() ? teamChampionshipEfbet1.get().getChampionship() :
                        new Championship().setName("Unknown1").setCountryOrTournament("Unknown tournament1").setSport(new Sport().setType("Football"));

                Optional<TeamNomenclature> teamChampionshipEfbet2 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameEfbet(teamNameTwo);
                Championship championshipEfbet2 = teamChampionshipEfbet2.isPresent() ? teamChampionshipEfbet2.get().getChampionship() :
                        new Championship().setName("Unknown2").setCountryOrTournament("Unknown tournament1").setSport(new Sport().setType("Football"));

                if (championshipEfbet1.equals(championshipEfbet2)) {
                    championship = championshipEfbet1;
                }
                break;

            default:
                championship = new Championship().setName("Unknown").setCountryOrTournament("Unknown tournament").setSport(new Sport().setType("Football"));
                break;
        }

        return championship;
    }
}
