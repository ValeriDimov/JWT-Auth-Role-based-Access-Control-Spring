package bg.bestsurebet.server.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teams_nomenclature")
public class TeamNomenclature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Championship.class)
    private Championship championship;

    @Column(name = "team_name_main", nullable = false, unique = true)
    private String teamNameMain;

    @Column(name = "team_name_betano", nullable = false, unique = true)
    private String teamNameBetano;

    @Column(name = "team_name_efbet", nullable = false, unique = true)
    private String teamNameEfbet;

    public Long getId() {
        return id;
    }

    public TeamNomenclature setId(Long id) {
        this.id = id;
        return this;
    }

    public Championship getChampionship() {
        return championship;
    }

    public TeamNomenclature setChampionship(Championship championship) {
        this.championship = championship;
        return this;
    }

    public String getTeamNameMain() {
        return teamNameMain;
    }

    public TeamNomenclature setTeamNameMain(String teamNameMain) {
        this.teamNameMain = teamNameMain;
        return this;
    }

    public String getTeamNameBetano() {
        return teamNameBetano;
    }

    public TeamNomenclature setTeamNameBetano(String teamNameBetano) {
        this.teamNameBetano = teamNameBetano;
        return this;
    }

    public String getTeamNameEfbet() {
        return teamNameEfbet;
    }

    public TeamNomenclature setTeamNameEfbet(String teamNameEfbet) {
        this.teamNameEfbet = teamNameEfbet;
        return this;
    }
}
