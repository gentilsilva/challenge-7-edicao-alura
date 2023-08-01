package br.com.backend.challenge.api.domain.destination;


public record DestinationDTO(
        Long id,
        String firstPicture,
        String secondPicture,
        String name,
        String meta,
        String descritiveText
) {

    public DestinationDTO(Destination destination) {
        this(destination.getId(), destination.getFirstPicture(), destination.getSecondPicture(),
                destination.getName(), destination.getMeta(), destination.getDescritiveText());
    }

}
