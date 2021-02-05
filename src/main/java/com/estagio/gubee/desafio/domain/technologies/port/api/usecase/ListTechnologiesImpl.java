package com.estagio.gubee.desafio.domain.technologies.port.api.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListTechnologiesImpl implements ListTechnologies {

    private final TechnologiesRepository tec;

    @Override
    public List<Technologies> findAll() {
        return tec.findAll();
    }
}
