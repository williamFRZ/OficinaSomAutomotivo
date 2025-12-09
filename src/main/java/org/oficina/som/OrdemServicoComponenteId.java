package org.oficina.som;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrdemServicoComponenteId implements Serializable {

    private Long componenteId;
    private Long ordemServicoId;

    public OrdemServicoComponenteId() {}

    public OrdemServicoComponenteId(Long componenteId, Long ordemServicoId) {
        this.componenteId = componenteId;
        this.ordemServicoId = ordemServicoId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(componenteId, ordemServicoId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OrdemServicoComponenteId)) return false;
        OrdemServicoComponenteId other = (OrdemServicoComponenteId) obj;
        return Objects.equals(componenteId, other.componenteId) &&
                Objects.equals(ordemServicoId, other.ordemServicoId);
    }
}
