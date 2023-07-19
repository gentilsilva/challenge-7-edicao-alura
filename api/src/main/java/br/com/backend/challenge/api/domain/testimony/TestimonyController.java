package br.com.backend.challenge.api.domain.testimony;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/depoimentos")
public class TestimonyController {

    private final TestimonyService testimonyService;
    
    public TestimonyController(TestimonyService testimonyService) {
        this.testimonyService = testimonyService;
    }

    @PostMapping
    public ResponseEntity<TestimonyDTO> createTestimony(@RequestBody @Valid TestimonyFormDTO testimonyFormDto, UriComponentsBuilder uriBuilder) {
        TestimonyDTO testimonyDTO = testimonyService.postTestimony(testimonyFormDto);
        URI uri = uriBuilder.path("depoimentos/{id}").buildAndExpand(testimonyDTO.id()).toUri();
        return ResponseEntity.created(uri).body(testimonyDTO);
    }

    @GetMapping
    public ResponseEntity<List<TestimonyDTO>> getTestimonys() {
        return ResponseEntity.ok(testimonyService.readAllTestimonys());
    }

    @GetMapping("{id}")
    public ResponseEntity<TestimonyDTO> getTestimonyById(@PathVariable Long id) {
        return ResponseEntity.ok(testimonyService.readTestimonyById(id));
    }

    @PutMapping
    public ResponseEntity<TestimonyDTO> putTestimonyById(@RequestBody @Valid TestimonyUpdateFormDTO testimonyUpdateFormDTO) {
        return ResponseEntity.ok(testimonyService.updateTestimony(testimonyUpdateFormDTO));
    }

}
