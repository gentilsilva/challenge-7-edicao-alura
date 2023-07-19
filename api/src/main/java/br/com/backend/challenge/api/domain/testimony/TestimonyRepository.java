package br.com.backend.challenge.api.domain.testimony;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {

    List<Testimony> findAllByActiveTrue();

    Testimony getReferenceByIdAndActiveTrue(Long id);
    
}
