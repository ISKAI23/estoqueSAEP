/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.service;

import br.gm.brunoriul.estoqueSAEP.entities.Movimento;
import br.gm.brunoriul.estoqueSAEP.repositories.MovimentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author digma
 */
@Service
public class MovimentoService {
    
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    public List<Movimento> findAll() {
        
        List<Movimento> result = movimentoRepository.findAll();
        return result;
    }
}
