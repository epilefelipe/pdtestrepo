package pagerduty.pruebaback.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String firstname;

    String lastname;

    String email;

    @JsonIgnore
    String password;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;

    boolean active;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}