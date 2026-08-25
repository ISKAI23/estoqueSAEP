/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.domain.dto;

import java.math.BigDecimal;

/**
 *
 * @author digma
 */
public class RelatorioDTO {
    
    private Long produtoId;
    private String nomeProduto;
    private BigDecimal valorUnitario;
    private Double totalEntradas;
    private Double totalSaidas;

    public RelatorioDTO() {
    }

    public RelatorioDTO(Long produtoId, String nomeProduto, BigDecimal valorUnitario, Double totalEntradas, Double totalSaidas) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.totalEntradas = totalEntradas;
        this.totalSaidas = totalSaidas;
    }
    
    
    
}
