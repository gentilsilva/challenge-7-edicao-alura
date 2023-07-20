package br.com.backend.challenge.api.domain.testimony;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestimonyRepository extends JpaRepository<Testimony, Long> {

    List<Testimony> findAllByActiveTrue();

    Testimony getReferenceByIdAndActiveTrue(Long id);

    @Query(value = "SELECT * FROM tb_testimony WHERE tb_testimony.active = TRUE ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Testimony> listRandomTestimonysAndActiveTrue();
    
}
