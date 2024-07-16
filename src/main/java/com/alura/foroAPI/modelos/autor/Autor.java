package com.alura.foroAPI.modelos.autor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "AUTOR")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String documento;
    private Boolean estado;
    private String telefono;

    public Autor(DatosAutor datosAutor) {
        this.nombre=datosAutor.nombre;
        this.apellido=datosAutor.apellido;
        this.documento=datosAutor.documento;
        this.estado=true;
        this.telefono=datosAutor.telefono;
    }
}
