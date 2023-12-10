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

    private final ChampionshipService championshipService;

    public TeamService(TeamRepository teamRepository, TeamNomenclatureRepository teamNomenclatureRepository, ChampionshipService championshipService) {
        this.teamRepository = teamRepository;
        this.teamNomenclatureRepository = teamNomenclatureRepository;
        this.championshipService = championshipService;
    }

    public Team findTeamByName(String name, String bookmakerName) {
        String teamName = findTeamNameFromNomenclature(name, bookmakerName);

        Optional<Team> optionalTeam = this.teamRepository.findByName(teamName);

        return optionalTeam.isPresent() ? optionalTeam.get() : this.teamRepository.save(new Team().setName(teamName));

    }

    //TODO: Championship logic enhancement is required for non-national club tournaments;
    public  Championship findTeamsChampionship(String teamNameOne, String teamNameTwo) {

        return championshipFinder(teamNameOne, teamNameTwo);
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

            case "www.inbet.com":
                Optional<TeamNomenclature> nameInbet = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameInbet(name);
                teamName = nameInbet.isPresent() ? nameInbet.get().getTeamNameMain() : name;
                break;

            case "www.winbet.bg":
                Optional<TeamNomenclature> nameWinbet = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameWinbet(name);
                teamName = nameWinbet.isPresent() ? nameWinbet.get().getTeamNameMain() : name;
                break;

            default:
                teamName = name;
                break;
        }

        return teamName;
    }

    private Championship championshipFinder(String teamNameOne, String teamNameTwo) {
        Championship championship;
        Championship championship1;
        Championship championship2;

        Optional<TeamNomenclature> teamChampionship1 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameMain(teamNameOne);
        Optional<Championship> optionalChampionshipUnknown = this.championshipService.findChampionshipByName("Unknown");
        Optional<Championship> optionalChampionshipInternational = this.championshipService.findChampionshipByName("International championship");

        if (teamChampionship1.isPresent()) {
            championship1 = teamChampionship1.get().getChampionship();

        } else {
            championship1 = optionalChampionshipUnknown.get();
        }

        Optional<TeamNomenclature> teamChampionship2 = this.teamNomenclatureRepository.findTeamNomenclatureByTeamNameMain(teamNameTwo);

        if (teamChampionship2.isPresent()) {
            championship2 = teamChampionship2.get().getChampionship();

        } else {
            championship2 = optionalChampionshipUnknown.get();
        }

        if (championship1.getName().equals(championship2.getName())) {
            championship = championship1;

        } else {
            championship = optionalChampionshipInternational.get();
        }

        this.championshipService.save(championship);

        return championship;
    }
}
