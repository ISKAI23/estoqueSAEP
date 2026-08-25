/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.api.controller;

import br.gm.brunoriul.estoqueSAEP.domain.dto.CategoriaValorTotalDTO;
import br.gm.brunoriul.estoqueSAEP.entities.Categoria;
import br.gm.brunoriul.estoqueSAEP.repositories.CategoriaRepository;
import br.gm.brunoriul.estoqueSAEP.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> result = categoriaService.findAll();
        return result;  
    }
    
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> buscar(@PathVariable Long id) {
        
        Optional<Categoria> categoria = categoriaService.findById(id);
        
        if (categoria.isPresent()){
            return ResponseEntity.ok(categoria.get());
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @GetMapping("/resumo")
    public List<CategoriaValorTotalDTO> resumoCategoria(){
        
        return categoriaService.valorTotalPorCategoriaViaSqlNativo();
        
    }
    
    @PostMapping("/adicionar")
    public Categoria adicionar(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
