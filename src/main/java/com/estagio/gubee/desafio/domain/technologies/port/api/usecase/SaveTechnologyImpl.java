package com.estagio.gubee.desafio.domain.technologies.port.api.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.SaveTechnology;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SaveTechnologyImpl implements SaveTechnology {

    private final TechnologiesRepository tec;

    @Override
    public Technologies save(Technologies technology) {
        return tec.save(technology);
    }
}
