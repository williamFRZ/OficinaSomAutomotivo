package org.oficina.som;

import jakarta.persistence.*;

@Entity
public class OrdemServicoComponente {

    @EmbeddedId
    private OrdemServicoComponenteId id;

    @ManyToOne
    @MapsId("componenteId")
    private Componente componente;

    @ManyToOne
    @MapsId("ordemServicoId")
    private OrdemServico ordemServico;

    private int quantidade;

    public OrdemServicoComponente() {}

    public OrdemServicoComponente(Componente componente, OrdemServico ordemServico, int quantidade) {
        this.componente = componente;
        this.ordemServico = ordemServico;
        this.quantidade = quantidade;
        this.id = new OrdemServicoComponenteId(componente.getId(), ordemServico.getId());
    }

    public OrdemServicoComponenteId getId() { return id; }
    public int getQuantidade() { return quantidade; }
}
