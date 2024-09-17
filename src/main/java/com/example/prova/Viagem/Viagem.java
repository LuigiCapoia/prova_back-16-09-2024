package com.example.prova.Viagem;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
public class Viagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Date dataSaida;
    private Date dataChegada;
    private BigDecimal valor;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    private Destino destino;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Date getdataSaida() {
        return dataSaida;
    }

    public void setdataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public Date getdataChegada() {
        return dataChegada;
    }

    public void setdataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public Destino getDestino() {
        return destino;
    }

    public void setDestino(Destino destino) {
        this.destino = destino;
    }
}
