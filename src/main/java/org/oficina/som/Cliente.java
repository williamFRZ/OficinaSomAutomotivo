package org.oficina.som;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
    private String endereco;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente() {}

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public Long getId() { return id; }

    public String getNome() { return nome; }

    public String getTelefone() { return telefone; }

    public String getEndereco() { return endereco; }

    public List<Veiculo> getVeiculos() { return veiculos; }
}
