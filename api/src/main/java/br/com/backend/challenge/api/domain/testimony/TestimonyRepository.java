package br.com.backend.challenge.api.domain.testimony;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {
    
}
