package br.com.backend.challenge.api.domain.testimony;

public record TestimonyDTO(
    Long id,
    String picture,
    String testimony,
    String name
) {
    public TestimonyDTO(Testimony testimony) {
        this(testimony.getId(), testimony.getPicture(), testimony.getTestimony(), testimony.getName());
    }
}
