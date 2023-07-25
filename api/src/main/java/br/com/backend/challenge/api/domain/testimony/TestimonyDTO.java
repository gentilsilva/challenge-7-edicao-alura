package br.com.backend.challenge.api.domain.testimony;

public record TestimonyDTO(
    Long id,
    String userPicture,
    String userTestimony,
    String userName
) {
    public TestimonyDTO(Testimony testimony) {
        this(testimony.getId(), testimony.getPicture(), testimony.getTestimony(), testimony.getName());
    }
}
