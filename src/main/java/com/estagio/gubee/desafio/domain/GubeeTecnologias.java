package com.estagio.gubee.desafio.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class GubeeTecnologias {

    @Id
    private String id;
    private String productName;
    private String description;
    private List<String> targetMarket;
    private List<String> stack;

    public GubeeTecnologias(String productName, String description, List<String> targetMarket, List<String> stack) {
        this.productName = productName;
        this.description = description;
        this.targetMarket = targetMarket;
        this.stack = stack;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    public List<String> getStack() {
        return stack;
    }

}
