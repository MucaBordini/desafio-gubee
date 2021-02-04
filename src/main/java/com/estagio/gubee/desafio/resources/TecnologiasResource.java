package com.estagio.gubee.desafio.resources;

import com.estagio.gubee.desafio.dto.TecnologiasDTO;
import com.estagio.gubee.desafio.services.TecnologiasService;
import com.estagio.gubee.desafio.domain.Tecnologias;
import com.estagio.gubee.desafio.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "tecnologias")
public class TecnologiasResource {

    @Autowired
    private TecnologiasService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TecnologiasDTO>> findAll() {
        List<Tecnologias> list = service.findAll();
        List<TecnologiasDTO> listDto = list.stream().map(x -> new TecnologiasDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<Tecnologias>> fullSearch(
            @RequestParam(value = "stack", defaultValue = "") String stack,
            @RequestParam(value = "product", defaultValue = "") String product) {

        stack = URL.decodeParam(stack);
        product = URL.decodeParam(product);

        List<Tecnologias> list = service.fullSearch(stack, product);
        return ResponseEntity.ok().body(list);

    }

}
