package br.gm.brunoriul.estoqueSAEP.repositories;

import br.gm.brunoriul.estoqueSAEP.domain.dto.RelatorioDTO;
import br.gm.brunoriul.estoqueSAEP.entities.Movimento;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author digma
 */

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
    
    @Query("""
           SELECT new br.gm.brunoriul.estoqueSAEP.domain.dto.RelatorioDTO
           (p.id, p.nome, p.valor_unitario,
           SUM(CASE WHEN m.qtd > 0 THEN m.qtd ELSE 0.0 END),
           SUM(CASE WHEN m.qtd < 0 THEN -m.qtd ELSE 0.0 END))
           FROM Movimento m JOIN m.produto p
           WHERE (:dataInicio IS NULL OR m.data_movto >= :dataInicio)
           AND (:dataFim IS NULL OR m.data_movto <= :dataFim)
           GROUP BY p.id
           ORDER BY p.nome
           """
    )
    List<RelatorioDTO> findRelatoriosEstoqueViaJPQL(@Param("dataInicio") LocalDateTime dataInicio, @Param("dataFim") LocalDateTime dataFim);
    
}
