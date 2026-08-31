/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.api.controller;

import br.gm.brunoriul.estoqueSAEP.domain.dto.RelatorioDTO;
import br.gm.brunoriul.estoqueSAEP.entities.Produto;
import br.gm.brunoriul.estoqueSAEP.repositories.ProdutoRepository;
import br.gm.brunoriul.estoqueSAEP.service.ProdutoService;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @GetMapping
    public List<Produto> findAll() {
        List<Produto> result = produtoService.findAll();
        return result;
    }
    
    @GetMapping("/{id_produto}")
    public ResponseEntity<Object> buscar(@PathVariable Long id_produto) {
        
        Optional<Produto> produto = produtoService.findById(id_produto);
        
        if (produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/relatorio/estoque")
    public ResponseEntity<List<RelatorioDTO>> relatorio(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dataInicio,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate dataFim) 
    
    {
                
        LocalDateTime inicio = (dataInicio != null) ? dataInicio.atStartOfDay() : null;
        LocalDateTime fim = (dataFim != null) ? dataFim.atTime(23, 59, 59) : null;
        
        List<RelatorioDTO> relatorio = produtoService.gerarRelatorio(inicio, fim);
        
        return ResponseEntity.ok(relatorio);    

    }
    
    @PostMapping("/adicionar")
    public Produto adicionar(@RequestBody @Valid Produto produto){
        return produtoRepository.save(produto);
    }   
    
}
