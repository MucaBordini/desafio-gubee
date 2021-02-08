package com.estagio.gubee.desafio.resources;

import com.estagio.gubee.desafio.api.dto.TechnologiesDTO;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologiesWithFilters;
import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.shared.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "technologies")
@RequiredArgsConstructor
public class TechnologiesResource {

    private final ListTechnologies listTechnologies;

    private final ListTechnologiesWithFilters listTechnologiesWithFilters;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TechnologiesDTO>> findAll() {
        List<Technologies> list = listTechnologies.findAll();
        List<TechnologiesDTO> listDto = list.stream().map(TechnologiesDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<TechnologiesDTO>> fullSearch(
            @RequestParam(value = "stack", defaultValue = "") String stack,
            @RequestParam(value = "product", defaultValue = "") String product) {

        stack = URL.decodeParam(stack);
        product = URL.decodeParam(product);

        List<Technologies> list = listTechnologiesWithFilters.fullSearch(stack, product);
        if (list.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        List<TechnologiesDTO> listDto = list.stream().map(TechnologiesDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);

    }

}
