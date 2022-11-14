package br.com.matheus.devdojo.springboot.request.processor;

import lombok.Data;

@Data
public class ProcessorPostRequestBody {
    private String name;
    private Integer cores;
    private Double price;
    private Double baseClock;
}
