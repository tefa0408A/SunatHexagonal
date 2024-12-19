package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name="empresa")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class EmpresaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String razonSocial;
    private String tipoDocumento;
    private String numeroDocumento;
    private String estado;
    private String condicion;
    private String direccion;
    private String ubigeo;
    private String viaTipo;
    private String viaNombre;
    private String zonaCodigo;
    private String zonaTipo;
    private String numero;
    private String interior;
    private String lote;
    private String dpto;
    private String manzana;
    private String kilometro;
    private String distrito;
    private String provincia;
    private String departamento;
    private boolean esAgenteRetencion;
    private String tipo;
    private String actividadEconomica;
    private String numeroTrabajadores;
    private String tipoFacturacion;
    private String tipoContabilidad;
    private String comercioExterior;
    private String usua_crea;
    private Timestamp date_crea;
}
