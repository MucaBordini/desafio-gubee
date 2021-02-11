package com.estagio.gubee.desafio.resource.adapter;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologiesRepositoryImpl implements TechnologiesRepository {

    private final MongoTechnologiesRepository mongoTechnologiesRepository;

    @Override
    public Technologies save(Technologies technology) {
        return mongoTechnologiesRepository.save(technology);
    }

    @Override
    public List<Technologies> fullSearch(String stack, String targetMarket) {
        return mongoTechnologiesRepository.fullSearch(stack, targetMarket);
    }

    @Override
    public List<Technologies> findAll() {
        return mongoTechnologiesRepository.findAll();
    }

}
