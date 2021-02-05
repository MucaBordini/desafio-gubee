package com.estagio.gubee.desafio.domain.technologies.port.api.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologiesWithFilters;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RequiredArgsConstructor
public class ListTechnologiesWithFiltersImpl implements ListTechnologiesWithFilters {

    @Autowired
    private TechnologiesRepository tec;

    @Override
    public List<Technologies> fullSearch(String stack, String product) {
        return tec.fullSearch(stack, product);
    }

}
