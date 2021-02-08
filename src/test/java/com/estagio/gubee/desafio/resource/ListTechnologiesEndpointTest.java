package com.estagio.gubee.desafio.resource;

import com.estagio.gubee.desafio.resources.TechnologiesResource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

@WebMvcTest
public class ListTechnologiesEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TechnologiesResource techRes;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(techRes).build();
    }

    @Test
    public void deveRetornarStatus200DoGetTecnologias() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/technologies")).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
