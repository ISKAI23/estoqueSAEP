package br.gm.brunoriul.estoqueSAEP.domain.dto;

import jakarta.validation.constraints.NotNull;

/**
 *
 * @author digma
 */

public record MovimentoDTO (
        
       @NotNull(message = "ID do produto não pode ser vazio!")
       Long id_produto,

       @NotNull(message = "Quantidade do movimento não pode ser vazia!")
       Double quantidade  
) {}
