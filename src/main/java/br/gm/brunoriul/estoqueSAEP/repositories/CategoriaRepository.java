/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.repositories;

import br.gm.brunoriul.estoqueSAEP.domain.projections.CategoriaValorTotalProjection;
import br.gm.brunoriul.estoqueSAEP.entities.Categoria;
import java.util.List;
//  import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
@Query(value = """
            SELECT c.categoria AS categoria, SUM(p.saldo * p.valor_unitario) AS valor_total  
            FROM categoria c
            INNER JOIN produto p ON p.id_categoria = c.id
            GROUP BY c.id, c.categoria
        """,
        nativeQuery = true)
    List<CategoriaValorTotalProjection> calcularValorTotalPorCategoriaViaSqlNativo();
    
}
