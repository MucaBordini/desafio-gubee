package com.estagio.gubee.desafio.domain.technologies.port.spi;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;

import java.util.List;

public interface TechnologiesRepository {

    List<Technologies> fullSearch (String stack, String product);

    List<Technologies> findAll();

}
