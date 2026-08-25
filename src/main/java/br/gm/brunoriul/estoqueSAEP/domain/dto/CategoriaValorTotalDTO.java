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
public class CategoriaValorTotalDTO {
    
    private String categoria;
    private BigDecimal valorTotal;

    public CategoriaValorTotalDTO() {
    }
    
    public CategoriaValorTotalDTO(String categoria, BigDecimal valorTotal) {
        this.categoria = categoria;
        this.valorTotal = valorTotal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
    
}
