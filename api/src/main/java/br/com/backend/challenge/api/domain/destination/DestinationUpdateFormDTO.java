package br.com.backend.challenge.api.domain.destination;

import java.math.BigDecimal;

public record DestinationUpdateFormDTO(
        Long id,
        String picture,
        String name,
        BigDecimal price
) {
}
