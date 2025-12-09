package org.oficina.som;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Componente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private int quantidadeEstoque;

    @OneToMany(mappedBy = "componente", cascade = CascadeType.ALL)
    private List<OrdemServicoComponente> ordemServicoComponentes = new ArrayList<>();

    public Componente() {}

    public Componente(String nome, String descricao, int quantidadeEstoque) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getDescricao() { return descricao; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }

    public List<OrdemServicoComponente> getOrdemServicoComponentes() {
        return ordemServicoComponentes;
    }
}
