package br.com.backend.challenge.api.domain.destination;

import java.math.BigDecimal;

public record DestinationDTO(
        Long id,
        String picture,
        String name,
        BigDecimal price
) {

    public DestinationDTO(Destination destination) {
        this(destination.getId(), destination.getPicture(), destination.getName(), destination.getPrice());
    }

}
