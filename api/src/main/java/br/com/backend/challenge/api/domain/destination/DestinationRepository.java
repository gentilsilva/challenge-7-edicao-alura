package br.com.backend.challenge.api.domain.destination;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findAllByIsActiveTrue();
}
