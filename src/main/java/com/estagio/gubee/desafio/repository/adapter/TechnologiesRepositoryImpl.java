package com.estagio.gubee.desafio.repository.adapter;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologiesRepositoryImpl implements TechnologiesRepository {

    private final MongoTechnologiesRepository mongoTechnologiesRepository;

    @Override
    public List<Technologies> fullSearch(String stack, String product) {
        return mongoTechnologiesRepository.fullSearch(stack, product);
    }

    @Override
    public List<Technologies> findAll() {
        return mongoTechnologiesRepository.findAll();
    }

}
