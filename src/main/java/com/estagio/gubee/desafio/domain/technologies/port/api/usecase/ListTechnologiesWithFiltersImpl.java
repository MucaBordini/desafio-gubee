package com.estagio.gubee.desafio.domain.technologies.port.api.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologiesWithFilters;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ListTechnologiesWithFiltersImpl implements ListTechnologiesWithFilters {

    private final TechnologiesRepository tec;

    @Override
    public List<Technologies> fullSearch(String stack, String product) {
        return tec.fullSearch(stack, product);
    }

}
