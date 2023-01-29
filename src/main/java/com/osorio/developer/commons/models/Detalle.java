package com.osorio.developer.commons.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "DETALLES")
public class Detalle implements Serializable {

    @Id
    @Column(name = "ID_DETALLE")
    @SequenceGenerator(name = "generator_id_detalle", sequenceName = "DETALLES_SEQ",
            initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator_id_detalle")
    private Integer idDetalle;

    @Column(name = "MONTO")
    private Double monto;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "CARACTERISTICA")
    private String caracteristica;

    @Column(name = "FECHA_GENERACION")
    private LocalDate fechaGeneracion;

    @JoinColumn(name = "USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @JoinColumn(name = "CATEGORIA")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @JoinColumn(name = "FUENTE")
    @ManyToOne(fetch = FetchType.EAGER)

    private Fuente fuente;


    public Detalle() {
    }


    public Detalle(Integer idDetalle, Double monto, String comentario, String caracteristica, LocalDate fechaGeneracion, Usuario usuario, Categoria categoria, Fuente fuente) {
        this.idDetalle = idDetalle;
        this.monto = monto;
        this.comentario = comentario;
        this.caracteristica = caracteristica;
        this.fechaGeneracion = fechaGeneracion;
        this.usuario = usuario;
        this.categoria = categoria;
        this.fuente = fuente;
    }
}

