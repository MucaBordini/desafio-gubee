package com.estagio.gubee.desafio.services;

import com.estagio.gubee.desafio.domain.Tecnologias;
import com.estagio.gubee.desafio.repository.TecnologiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiasService {

    @Autowired
    private TecnologiasRepository repository;

    public List<Tecnologias> findAll() {
        return repository.findAll();
    }

    public List<Tecnologias> fullSearch (String stack, String product) {
        return repository.fullSearch(stack, product);
    }

}
