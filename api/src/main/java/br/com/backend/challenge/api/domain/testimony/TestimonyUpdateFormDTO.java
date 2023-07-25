package br.com.backend.challenge.api.domain.testimony;

public record TestimonyUpdateFormDTO(

    Long id,
    String picture,
    String testimony,
    String name
    
) {
    
}