/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.gm.brunoriul.estoqueSAEP.repositories;

import br.gm.brunoriul.estoqueSAEP.entities.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author digma
 */
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {
}
