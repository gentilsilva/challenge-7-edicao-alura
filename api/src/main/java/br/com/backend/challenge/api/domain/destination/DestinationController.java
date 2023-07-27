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
    public ResponseEntity<List<DestinationDTO>> getDestinations(@RequestParam(value = "name", required = false, defaultValue = "") String name) {
        if (!name.isBlank()) {
            List<DestinationDTO> destinationDTOList = destinationService.readDestinationsByName(name);
            if (!destinationDTOList.isEmpty()) {
                return ResponseEntity.ok(destinationDTOList);
            }
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destinationService.readAllDestinations());
    }

    @GetMapping("{id}")
    public ResponseEntity<DestinationDTO> getDestinationById(@PathVariable Long id) {
        return ResponseEntity.ok(destinationService.readDestinationById(id));
    }

    @PutMapping
    public ResponseEntity<DestinationDTO> putDestinationById(@RequestBody DestinationUpdateFormDTO destinationUpdateFormDTO) {
        DestinationDTO destinationDTO = destinationService.updateDestination(destinationUpdateFormDTO);
        if (destinationDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(destinationDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<DestinationDTO> deleteDestination(@PathVariable Long id) {
        Boolean deleted = destinationService.removeDestination(id);
        if (!deleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
