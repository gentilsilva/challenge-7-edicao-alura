package br.com.backend.challenge.api.domain.destination;

import java.math.BigDecimal;

public record DestinationFormDTO(
        String picture,
        String name,
        BigDecimal price
) {
}
