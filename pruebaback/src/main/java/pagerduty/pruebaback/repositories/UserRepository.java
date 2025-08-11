package pagerduty.pruebaback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pagerduty.pruebaback.entities.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}