package com.estagio.gubee.desafio.domain.technologies.model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Technologies {

    private String id;
    private String productName;
    private String description;
    private List<String> targetMarket = new ArrayList<>();
    private List<String> stack = new ArrayList<>();

}
