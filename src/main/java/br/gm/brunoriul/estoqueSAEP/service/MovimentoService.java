package br.gm.brunoriul.estoqueSAEP.service;

import br.gm.brunoriul.estoqueSAEP.entities.Movimento;
import br.gm.brunoriul.estoqueSAEP.entities.Produto;
import br.gm.brunoriul.estoqueSAEP.repositories.MovimentoRepository;
import br.gm.brunoriul.estoqueSAEP.repositories.ProdutoRepository;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
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
    ProdutoRepository produtoRepository;
    
    @Autowired
    private MovimentoRepository movimentoRepository;
    
    public List<Movimento> findAll() {   
        List<Movimento> result = movimentoRepository.findAll();
        return result;
    }
    
    @Transactional
    public Movimento atualizaSaldo(long id_produto, Double qtd){
        
        Produto p = produtoRepository.findById(id_produto).orElseThrow( () -> new RuntimeException("Produto não encontrado com ID:" + id_produto));
        
        Movimento movto = new Movimento(p, BigDecimal.valueOf(qtd));
        
        movimentoRepository.save(movto);
        
        p.atualizaSaldo(qtd);
//        produtoRepository.save(p);

        System.out.println("Saldo atualizado: " + p.getSaldo());
        
        return movto;
        
         
    }
}
