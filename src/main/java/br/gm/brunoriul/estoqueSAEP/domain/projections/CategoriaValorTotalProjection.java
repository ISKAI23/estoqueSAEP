/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.domain.projections;

import java.math.BigDecimal;

/**
 *
 * @author digma
 */
public interface CategoriaValorTotalProjection {
    String getCategoria();
    BigDecimal getValorTotal();
}
