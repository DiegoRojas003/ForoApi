package com.alura.foroAPI.controller;

import com.alura.foroAPI.modelos.autor.Autor;
import com.alura.foroAPI.modelos.autor.AutorRepository;
import com.alura.foroAPI.modelos.autor.DatosAutor;
import com.alura.foroAPI.modelos.autor.DatosDetalleAutor;
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
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorRepository autorRepository;
    @PostMapping
    public ResponseEntity<DatosDetalleAutor> registarAutor(@RequestBody @Valid DatosAutor datosAutor, UriComponentsBuilder uriComponentsBuilder) {
        Autor autor = autorRepository.save(new Autor(datosAutor));
        DatosDetalleAutor datosDetalleAutor = new DatosDetalleAutor(autor.getId(), autor.getNombre(), autor.getDocumento(), autor.getTelefono());
        URI url = uriComponentsBuilder.path("/autor/{id}").buildAndExpand(autor.getId()).toUri();
        return ResponseEntity.created(url).body(datosDetalleAutor);
    }
}