package com.estagio.gubee.desafio.domain.technologies.port.api;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface ListTechnologiesWithFilters {

    List<Technologies> fullSearch (String stack, String product);

}
