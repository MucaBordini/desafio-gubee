package com.estagio.gubee.desafio.resources;

import com.estagio.gubee.desafio.api.dto.TechnologiesDTO;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologiesWithFilters;
import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.SaveTechnology;
import com.estagio.gubee.desafio.shared.URL;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "technologies")
@RequiredArgsConstructor
public class TechnologiesResource {

    private final ListTechnologies listTechnologies;

    private final ListTechnologiesWithFilters listTechnologiesWithFilters;

    private final SaveTechnology saveTechnology;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<TechnologiesDTO>> findAll() {
        List<Technologies> list = listTechnologies.findAll();
        List<TechnologiesDTO> listDto = list.stream().map(TechnologiesDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
    public ResponseEntity<List<TechnologiesDTO>> fullSearch(
            @RequestParam(value = "stack", defaultValue = "") String stack,
            @RequestParam(value = "targetMarket", defaultValue = "") String targetMarket) {

        stack = URL.decodeParam(stack);
        targetMarket = URL.decodeParam(targetMarket);

        System.out.println(stack);

        List<Technologies> list = listTechnologiesWithFilters.fullSearch(stack, targetMarket);
        if (list.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        List<TechnologiesDTO> listDto = list.stream().map(TechnologiesDTO::new).collect(Collectors.toList());

        return ResponseEntity.ok().body(listDto);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody Technologies technology) {
        technology = saveTechnology.save(technology);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(technology.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
