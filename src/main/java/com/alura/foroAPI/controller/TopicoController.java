package com.alura.foroAPI.controller;


import com.alura.foroAPI.modelos.topico.DatosDetalleTopico;
import com.alura.foroAPI.modelos.topico.DatosTopico;
import com.alura.foroAPI.modelos.topico.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
@RequestMapping("/topico")
public class TopicoController {
    @Autowired
    private TopicoService topicoService;
    @PostMapping
    public ResponseEntity<DatosDetalleTopico> registrarMedico(@RequestBody @Valid DatosTopico datos){
        var respuesta=topicoService.agendar(datos);

        return ResponseEntity.ok(respuesta);
    }
}
