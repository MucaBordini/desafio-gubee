package com.estagio.gubee.desafio.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Tecnologias {

    @Id
    private String id;
    private String productName;
    private String description;

    private List<String> targetMarket = new ArrayList<>();

    private List<String> stack = new ArrayList<>();

    public Tecnologias(String id, String productName, String description, List<String> targetMarket, List<String> stack) {
        this.id = id;
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

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(List<String> targetMarket) {
        this.targetMarket = targetMarket;
    }

    public List<String> getStack() {
        return stack;
    }

    public void setStack(List<String> stack) {
        this.stack = stack;
    }
}
