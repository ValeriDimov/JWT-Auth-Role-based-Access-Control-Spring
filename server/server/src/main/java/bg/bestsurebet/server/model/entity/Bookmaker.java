package bg.bestsurebet.server.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "bookmakers")
public class Bookmaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public Bookmaker setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Bookmaker setName(String name) {
        this.name = name;
        return this;
    }
}
