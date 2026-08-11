/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.api.controller;

import br.gm.brunoriul.estoqueSAEP.entities.Movimento;
import br.gm.brunoriul.estoqueSAEP.service.MovimentoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author digma
 */

@RestController
@RequestMapping("/movimento")
public class MovimentoController {
    
    @Autowired
    private MovimentoService movimentoService;
    
    @GetMapping
    public List<Movimento> findAll() {
        List<Movimento> result = movimentoService.findAll();
        return result;
    }
}
