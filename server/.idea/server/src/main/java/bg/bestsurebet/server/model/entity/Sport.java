package bg.bestsurebet.server.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sports")
public class Sport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    public Long getId() {
        return id;
    }

    public Sport setId(Long id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public Sport setType(String type) {
        this.type = type;
        return this;
    }
}
