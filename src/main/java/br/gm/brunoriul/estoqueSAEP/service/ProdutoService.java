/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.service;

import br.gm.brunoriul.estoqueSAEP.domain.dto.RelatorioDTO;
import br.gm.brunoriul.estoqueSAEP.entities.Produto;
import br.gm.brunoriul.estoqueSAEP.repositories.MovimentoRepository;
import br.gm.brunoriul.estoqueSAEP.repositories.ProdutoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    public List<Produto> findAll() {
        
        List<Produto> result = produtoRepository.findAll();
        return result;
    }
    
    public Optional<Produto> findById(Long id_produto){
        Optional<Produto> result = produtoRepository.findById(id_produto);
        
        return result;
    }
    
    public List<RelatorioDTO> gerarRelatorio(LocalDateTime dataInicio, LocalDateTime dataFim) {
        
        return movimentoRepository.findRelatoriosEstoqueViaJPQL(dataInicio, dataFim);
        
    }    
}
