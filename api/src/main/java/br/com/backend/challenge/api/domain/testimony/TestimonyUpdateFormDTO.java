package br.com.backend.challenge.api.domain.testimony;

public record TestimonyUpdateFormDTO(
    Long id,
    String userPicture,
    String userTestimony,
    String userName
) {
    
}