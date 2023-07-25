package br.com.backend.challenge.api.domain.destination;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Transactional(readOnly = true)
    public List<DestinationDTO> readAllByIsActiveTrue() {
        return destinationRepository.findAllByIsActiveTrue().stream().map(DestinationDTO::new).toList();
    }

    @Transactional
    public DestinationDTO createDestination(DestinationFormDTO destinationFormDTO) {
        Destination destination = new Destination(destinationFormDTO);
        destinationRepository.save(destination);
        return new DestinationDTO(destination);
    }
}
