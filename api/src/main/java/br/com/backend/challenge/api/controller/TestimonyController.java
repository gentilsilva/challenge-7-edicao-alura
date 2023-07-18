package br.com.backend.challenge.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.backend.challenge.api.domain.testimony.TestimonyDTO;
import br.com.backend.challenge.api.domain.testimony.TestimonyService;

@RestController
@RequestMapping("/depoimentos")
public class TestimonyController {
    
    @Autowired
    private TestimonyService testimonyService;

    @GetMapping
    public ResponseEntity<List<TestimonyDTO>> readAllTestimonys() {
        return ResponseEntity.ok(testimonyService.getTestimonys());
    }

}
