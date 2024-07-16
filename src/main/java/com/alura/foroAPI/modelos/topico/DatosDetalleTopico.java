package com.alura.foroAPI.modelos.topico;

public record DatosDetalleTopico(
        Long id, Long id_autor,Long id_curso,String titulo,String mensaje
) {
    public DatosDetalleTopico(Topico topico) {
        this(topico.getId(),topico.getAutor().getId(),topico.getCurso().getId(),topico.getTitulo(),topico.getMensaje());
    }
}
