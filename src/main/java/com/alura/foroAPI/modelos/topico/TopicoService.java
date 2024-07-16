package com.alura.foroAPI.modelos.topico;

import com.alura.foroAPI.infra.errores.ValidacionDeIntegridad;
import com.alura.foroAPI.modelos.autor.AutorRepository;
import com.alura.foroAPI.modelos.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;
    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CursoRepository cursoRepository;
    public DatosDetalleTopico agendar(DatosTopico datos){
        if(!autorRepository.existsById(datos.id_autor)){
            throw new ValidacionDeIntegridad("No se pudo encontrar el id del autor proporcionado");
        }
        if(!cursoRepository.existsById(datos.id_curso)){
            throw new ValidacionDeIntegridad("No se puedo encontrar el id del curso proporcionado");
        }
        var autor=autorRepository.findById(datos.id_autor).get();
        var curso=cursoRepository.findById(datos.id_curso).get();
        Topico topico=new Topico(datos,autor,curso);
        topicoRepository.save(topico);
        return new DatosDetalleTopico(topico);
    }
}
