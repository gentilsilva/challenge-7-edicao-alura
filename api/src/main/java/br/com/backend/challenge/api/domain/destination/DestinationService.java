package br.com.backend.challenge.api.domain.destination;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<DestinationDTO> readAllByIsActiveTrue() {
        return destinationRepository.findAllByIsActiveTrue().stream().map(DestinationDTO::new).toList();
    }

}
