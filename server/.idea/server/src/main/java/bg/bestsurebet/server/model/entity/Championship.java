package bg.bestsurebet.server.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "championships")
public class Championship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "country_or_tournament")
    private String countryOrTournament;

    @ManyToOne(targetEntity = Sport.class)
    private Sport sport;

    public Long getId() {
        return id;
    }

    public Championship setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Championship setName(String name) {
        this.name = name;
        return this;
    }

    public String getCountryOrTournament() {
        return countryOrTournament;
    }

    public Championship setCountryOrTournament(String countryOrTournament) {
        this.countryOrTournament = countryOrTournament;
        return this;
    }

    public Sport getSport() {
        return sport;
    }

    public Championship setSport(Sport sport) {
        this.sport = sport;
        return this;
    }
}
