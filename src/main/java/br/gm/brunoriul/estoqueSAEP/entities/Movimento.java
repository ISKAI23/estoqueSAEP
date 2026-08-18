package br.gm.brunoriul.estoqueSAEP.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author digma
 */
@Entity
@Table(name="movimento")
public class Movimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_produto", nullable = false)
    private Produto produto;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal qtd;
    
    @Column(name="data_movto")
    private LocalDateTime data_movto;

    public Movimento() {
        this.data_movto = LocalDateTime.now();
    }

    public Movimento(Produto produto, BigDecimal qtd) {
        this.produto = produto;
        this.qtd = qtd;
        this.data_movto = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQtd() {
        return qtd;
    }

    public void setQtd(BigDecimal qtd) {
        this.qtd = qtd;
    }

    public LocalDateTime getData_movto() {
        return data_movto;
    }

    public void setData_movto(LocalDateTime data_movto) {
        this.data_movto = data_movto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movimento other = (Movimento) obj;
        return Objects.equals(this.id, other.id);
    }
}
