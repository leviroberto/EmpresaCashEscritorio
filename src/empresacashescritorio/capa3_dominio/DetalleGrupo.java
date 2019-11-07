/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa3_dominio;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author l9531
 */
public class DetalleGrupo {

    private int id;
    private Date fechaCreacion;
    private Cliente cliente;
    private Grupo grupo;
    private String estadoAccion;
    private String estado;

    public static final String ESTADO_CREAR = "Crear";
    public static final String ESTADO_ACTUALIZAR = "Actualizar";
    public static final String ESTADO_ELIMINAR = "Eliminar";

    public static final String ESTADO_ACTIVO = "Activo";
    public static final String ESTADO_INACTIVO = "Inactivo";

    public DetalleGrupo() {
        this.fechaCreacion = Date.valueOf(LocalDate.now());
    }

    public DetalleGrupo(Cliente cliente, Grupo grupo) {
        this.cliente = cliente;
        this.grupo = grupo;
         this.fechaCreacion = Date.valueOf(LocalDate.now());
    }

    public String getEstadoAccion() {
        return estadoAccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
    public void setEstadoAccion(String estadoAccion) {
        this.estadoAccion = estadoAccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

}
