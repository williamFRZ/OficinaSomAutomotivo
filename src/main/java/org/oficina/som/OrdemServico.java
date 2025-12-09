package org.oficina.som;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String status;

    @ManyToOne
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @OneToMany(mappedBy = "ordemServico", cascade = CascadeType.ALL)
    private List<OrdemServicoComponente> componentes = new ArrayList<>();

    public OrdemServico() {}

    public OrdemServico(String descricao, Veiculo veiculo) {
        this.descricao = descricao;
        this.veiculo = veiculo;
    }

    public Long getId() { return id; }

    public String getDescricao() { return descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Veiculo getVeiculo() { return veiculo; }

    public List<OrdemServicoComponente> getComponentes() { return componentes; }
}
