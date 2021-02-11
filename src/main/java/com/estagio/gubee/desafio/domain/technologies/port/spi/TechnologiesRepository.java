package com.estagio.gubee.desafio.domain.technologies.port.spi;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;

import java.util.List;


public interface TechnologiesRepository {

    Technologies save (Technologies technology);

    List<Technologies> fullSearch (String stack, String marketTarget);

    List<Technologies> findAll();

}
