package br.com.backend.challenge.api.domain.destination;


public record DestinationUpdateFormDTO(
        Long id,
        String firstPicture,
        String secondPicture,
        String name,
        String meta,
        String descritiveText
) {
}
