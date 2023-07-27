package br.com.backend.challenge.api.domain.destination;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findAllByIsActiveTrue();

    Destination getReferenceByIdAndIsActiveTrue(Long id);

    @Query(value = "SELECT * FROM tb_destination d WHERE d.is_active = TRUE AND LOWER(d.name) = ?1", nativeQuery = true)
    List<Destination> findAllByIsActiveTrueAndName(String name);
}
