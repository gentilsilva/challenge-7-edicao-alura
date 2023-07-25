package br.com.backend.challenge.api.domain.testimony;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;


@RestController
public class TestimonyController {

    private final TestimonyService testimonyService;
    
    public TestimonyController(TestimonyService testimonyService) {
        this.testimonyService = testimonyService;
    }

    @PostMapping("depoimentos")
    public ResponseEntity<TestimonyDTO> createTestimony(@RequestBody @Valid TestimonyFormDTO testimonyFormDto, UriComponentsBuilder uriBuilder) {
        TestimonyDTO testimonyDTO = testimonyService.postTestimony(testimonyFormDto);
        URI uri = uriBuilder.path("depoimentos/{id}").buildAndExpand(testimonyDTO.id()).toUri();
        return ResponseEntity.created(uri).body(testimonyDTO);
    }

    @GetMapping("depoimentos")
    public ResponseEntity<List<TestimonyDTO>> getTestimonys() {
        return ResponseEntity.ok(testimonyService.readAllTestimonys());
    }

    @GetMapping("depoimentos/{id}")
    public ResponseEntity<TestimonyDTO> getTestimonyById(@PathVariable Long id) {
        return ResponseEntity.ok(testimonyService.readTestimonyById(id));
    }

    @GetMapping("depoimentos-home")
    public ResponseEntity<List<TestimonyDTO>> getRandomTestimonys() {
        return ResponseEntity.ok(testimonyService.readRandomTestimonys());
    }

    @PutMapping("depoimentos")
    public ResponseEntity<TestimonyDTO> putTestimonyById(@RequestBody @Valid TestimonyUpdateFormDTO testimonyUpdateFormDTO) {
        TestimonyDTO testimonyDTO = testimonyService.updateTestimony(testimonyUpdateFormDTO);
        if (testimonyDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testimonyService.updateTestimony(testimonyUpdateFormDTO));
    }

    @DeleteMapping("depoimentos/{id}")
    public ResponseEntity<TestimonyDTO> deleteTestimonyById(@PathVariable Long id) {
        Boolean deleted = testimonyService.removeTestimonyById(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
