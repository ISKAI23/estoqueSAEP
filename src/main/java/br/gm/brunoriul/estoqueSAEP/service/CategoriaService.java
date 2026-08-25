/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.service;

import br.gm.brunoriul.estoqueSAEP.domain.dto.CategoriaValorTotalDTO;
import br.gm.brunoriul.estoqueSAEP.domain.projections.CategoriaValorTotalProjection;
import br.gm.brunoriul.estoqueSAEP.entities.Categoria;
import br.gm.brunoriul.estoqueSAEP.repositories.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> findAll() {
        
        List<Categoria> result = categoriaRepository.findAll();
        return result;
    }
    
    public Optional<Categoria> findById(Long id_produto){
        Optional<Categoria> result = categoriaRepository.findById(id_produto);
        
        return result;
    }
    
    
    public List<CategoriaValorTotalDTO> valorTotalPorCategoriaViaSqlNativo(){
        
        List<CategoriaValorTotalProjection> resultados = categoriaRepository.calcularValorTotalPorCategoriaViaSqlNativo();
        
        return resultados.stream().map(proj -> new CategoriaValorTotalDTO(proj.getCategoria(), proj.getValorTotal())).toList();
        
    }
}
