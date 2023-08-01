package br.com.backend.challenge.api.domain.destination;

import jakarta.validation.constraints.NotBlank;


public record DestinationFormDTO(
        @NotBlank
        String firstPicture,
        @NotBlank
        String secondPicture,
        @NotBlank
        String name,
        @NotBlank
        String meta,
        String descritiveText

) {
}
