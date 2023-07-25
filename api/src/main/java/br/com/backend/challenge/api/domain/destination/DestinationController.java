package br.com.backend.challenge.api.domain.destination;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("destinos")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @PostMapping
    public ResponseEntity<DestinationDTO> PostDestination(@RequestBody @Valid DestinationFormDTO destinationFormDTO, UriComponentsBuilder uriBuilder) {
        DestinationDTO destinationDTO = destinationService.createDestination(destinationFormDTO);
        URI uri = uriBuilder.path("destinos/{id}").buildAndExpand(destinationDTO.id()).toUri();
        return ResponseEntity.created(uri).body(destinationDTO);
    }

    @GetMapping
    public ResponseEntity<List<DestinationDTO>> getDestinations() {
        return ResponseEntity.ok(destinationService.readAllByIsActiveTrue());
    }

}
