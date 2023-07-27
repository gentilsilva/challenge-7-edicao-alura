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
    public List<DestinationDTO> readAllDestinations() {
        return destinationRepository.findAllByIsActiveTrue().stream().map(DestinationDTO::new).toList();
    }

    @Transactional
    public DestinationDTO createDestination(DestinationFormDTO destinationFormDTO) {
        Destination destination = new Destination(destinationFormDTO);
        destinationRepository.save(destination);
        return new DestinationDTO(destination);
    }

    @Transactional(readOnly = true)
    public DestinationDTO readDestinationById(Long id) {
        return new DestinationDTO(destinationRepository.getReferenceByIdAndIsActiveTrue(id));
    }

    @Transactional(readOnly = true)
    public List<DestinationDTO> readDestinationsByName(String name) {
        return destinationRepository.findAllByIsActiveTrueAndName(name).stream().map(DestinationDTO::new).toList();
    }

    @Transactional
    public DestinationDTO updateDestination(DestinationUpdateFormDTO destinationUpdateFormDTO) {
        Destination destination = destinationRepository.getReferenceByIdAndIsActiveTrue(destinationUpdateFormDTO.id());
        if (destination == null) {
            return null;
        }
        destination.update(destinationUpdateFormDTO);
        return new DestinationDTO(destination);
    }

    @Transactional
    public Boolean removeDestination(Long id) {
        Destination destination = destinationRepository.getReferenceByIdAndIsActiveTrue(id);
        if (destination == null) {
            return false;
        }
        destination.inactive();
        return true;
    }

}
