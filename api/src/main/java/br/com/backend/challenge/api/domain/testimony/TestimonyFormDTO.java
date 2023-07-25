package br.com.backend.challenge.api.domain.testimony;

import jakarta.validation.constraints.NotNull;

public record TestimonyFormDTO(

    @NotNull
    String picture,

    @NotNull
    String testimony,
    
    @NotNull
    String name
    
) {
    
}
