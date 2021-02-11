package com.estagio.gubee.desafio.domain.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.usecase.ListTechnologiesImpl;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTechnologiesTest {

    private TechnologiesRepository listRepo = Mockito.mock(TechnologiesRepository.class);

    private ListTechnologies listTechUseCase;

    @BeforeEach
    void setUp() {
        listTechUseCase = new ListTechnologiesImpl(listRepo);
    }

    @Test
    void deveListarAsTecnologias() {

        List<String> tgtMkt = new ArrayList<String>();
        List<String> stk = new ArrayList<String>();
        tgtMkt.add("Mercado1");
        stk.add("Stack1");
        Technologies tec1 = new Technologies("1", "Teste", "Teste", tgtMkt, stk);
        List<Technologies> listTec= new ArrayList<Technologies>();

        listTec.add(tec1);

        Mockito.when(listRepo.findAll()).thenReturn((listTec));

        var list = listTechUseCase.findAll();

        assertEquals(1, list.size());
    }

}
