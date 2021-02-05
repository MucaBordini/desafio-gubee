package com.estagio.gubee.desafio.domain.technologies.port.api;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;

import java.util.List;

public interface ListTechnologies {

    List<Technologies> findAll();

}
