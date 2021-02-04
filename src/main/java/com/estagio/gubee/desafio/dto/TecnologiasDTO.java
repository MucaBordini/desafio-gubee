package com.estagio.gubee.desafio.dto;

import com.estagio.gubee.desafio.domain.Tecnologias;

import java.util.ArrayList;
import java.util.List;

public class TecnologiasDTO {

    private String id;
    private String productName;
    private String description;
    private List<String> targetMarket = new ArrayList<>();
    private List<String> stack = new ArrayList<>();

    public TecnologiasDTO(Tecnologias obj) {
        this.id = obj.getId();
        this.productName = obj.getProductName();
        this.description = obj.getDescription();
        this.targetMarket = obj.getTargetMarket();
        this.stack = obj.getStack();
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
