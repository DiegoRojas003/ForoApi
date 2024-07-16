package com.alura.foroAPI.modelos.curso;

import jakarta.validation.constraints.NotNull;

public record DatosCurso(
        @NotNull
        String titulo,
        @NotNull
        Area area
) {
}
