package com.alura.foroAPI.controller;

import com.alura.foroAPI.modelos.autor.Autor;
import com.alura.foroAPI.modelos.autor.AutorRepository;
import com.alura.foroAPI.modelos.autor.DatosAutor;
import com.alura.foroAPI.modelos.autor.DatosDetalleAutor;
import com.alura.foroAPI.modelos.curso.Curso;
import com.alura.foroAPI.modelos.curso.CursoRepository;
import com.alura.foroAPI.modelos.curso.DatosCurso;
import com.alura.foroAPI.modelos.curso.DatosDetalleCurso;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;
    @PostMapping
    public ResponseEntity<DatosDetalleCurso> registarCurso(@RequestBody @Valid DatosCurso datosCurso, UriComponentsBuilder uriComponentsBuilder) {
        Curso curso = cursoRepository.save(new Curso(datosCurso));
        DatosDetalleCurso datosDetalleCurso = new DatosDetalleCurso(curso.getId(), curso.getTitulo(), curso.getArea());
        URI url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(datosDetalleCurso);
    }
}
