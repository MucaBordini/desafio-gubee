package com.estagio.gubee.desafio.domain.usecase;

import com.estagio.gubee.desafio.domain.technologies.model.Technologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologies;
import com.estagio.gubee.desafio.domain.technologies.port.api.ListTechnologiesWithFilters;
import com.estagio.gubee.desafio.domain.technologies.port.api.usecase.ListTechnologiesImpl;
import com.estagio.gubee.desafio.domain.technologies.port.api.usecase.ListTechnologiesWithFiltersImpl;
import com.estagio.gubee.desafio.domain.technologies.port.spi.TechnologiesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListTechnologiesWithFiltersTest {

    @Mock
    private TechnologiesRepository listRepo;

    private ListTechnologiesWithFilters listTech;

    @BeforeEach
    void setUp() {
        listTech = new ListTechnologiesWithFiltersImpl(listRepo);
    }

    @Test
    void deveListarAsTecnologiasComFiltros() {
        List<Technologies> listTec= new ArrayList<Technologies>();

        List<String> tgtMkt1 = new ArrayList<String>();
        List<String> stk1 = new ArrayList<String>();
        tgtMkt1.add("Mercado1");
        tgtMkt1.add("Mercado2");
        stk1.add("Stack1");
        stk1.add("Stack2");
        Technologies tec1 = new Technologies("1", "Teste", "Teste", tgtMkt1, stk1);

        List<String> tgtMkt2 = new ArrayList<String>();
        List<String> stk2 = new ArrayList<String>();
        tgtMkt2.add("Mercado2");
        stk2.add("Stack1");
        Technologies tec2 = new Technologies("2", "Teste2", "Teste2", tgtMkt2, stk2);

        List<String> tgtMkt3 = new ArrayList<String>();
        List<String> stk3 = new ArrayList<String>();
        tgtMkt3.add("Mercado2");
        stk3.add("Stack2");
        stk3.add("Stack1");
        Technologies tec3 = new Technologies("3", "Teste3", "Teste3", tgtMkt3, stk3);

        listTec.add(tec1);
        listTec.add(tec2);
        listTec.add(tec3);

        Mockito.when(listTech.fullSearch("2", "")).thenReturn((listTec));

        var list = listTech.fullSearch("2", "");


        assertEquals(listTec, list);

    }

}
