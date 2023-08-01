package br.com.backend.challenge.api.domain.testimony;

import jakarta.validation.constraints.NotBlank;

public record TestimonyFormDTO(

    @NotBlank
    String picture,
    @NotBlank
    String testimony,
    @NotBlank
    String name
    
) {
    
}
