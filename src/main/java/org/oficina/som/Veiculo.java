package org.oficina.som;

import jakarta.persistence.*;

@Entity
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;

    @Column(nullable = false, unique = true)
    private String placa;

    private int ano;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    public Veiculo() {}

    public Veiculo(String modelo, String placa, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }

    public Long getId() { return id; }

    public String getModelo() { return modelo; }

    public String getPlaca() { return placa; }

    public int getAno() { return ano; }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
