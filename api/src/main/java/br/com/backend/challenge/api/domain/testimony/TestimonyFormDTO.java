package br.com.backend.challenge.api.domain.testimony;

import jakarta.validation.constraints.NotNull;

public record TestimonyFormDTO(

    @NotNull
    String userPicture,

    @NotNull
    String userTestimony,
    
    @NotNull
    String userName
    
) {
    
}
