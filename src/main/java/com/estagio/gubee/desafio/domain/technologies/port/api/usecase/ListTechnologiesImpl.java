package com.estagio.gubee.desafio.domain.technologies.port.api.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class ListTechnologiesImpl implements ListTechnologies {

    @Autowired
    private TechnologiesRepository tec;

    @Override
    public List<Technologies> findAll() {
        return tec.findAll();
    }
}
