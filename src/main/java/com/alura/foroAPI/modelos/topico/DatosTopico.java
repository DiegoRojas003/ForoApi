package com.alura.foroAPI.modelos.topico;

import jakarta.validation.constraints.NotNull;

public class DatosTopico{
    @NotNull
    Long id_autor;
    @NotNull
    Long id_curso;
    @NotNull
    String titulo;
    @NotNull
    String mensaje;

    public Long getId_autor() {
        return id_autor;
    }

    public void setId_autor(Long id_autor) {
        this.id_autor = id_autor;
    }

    public Long getId_curso() {
        return id_curso;
    }

    public void setId_curso(Long id_curso) {
        this.id_curso = id_curso;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
