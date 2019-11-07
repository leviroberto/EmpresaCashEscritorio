/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa3_dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l9531
 */
public class Grupo {

    private int id;
    private String nombre;
    private String descripcion;
    private List<DetalleGrupo> listaDetalleGrupo;
    private String estado;
    private Date fechaCreacion;
    public static final String ESTADO_ACTIVO = "Activo";
    public static final String ESTADO_INACTIVO = "Inactivo";

    public Grupo() {
        this.listaDetalleGrupo = new ArrayList<DetalleGrupo>();
        this.fechaCreacion = Date.valueOf(LocalDate.now());
        this.estado = ESTADO_ACTIVO;
    }

    public boolean agregarDetalleGrupo(Cliente cliente, Grupo grupo) {
        DetalleGrupo detalleGrupo = new DetalleGrupo(cliente, grupo);
        detalleGrupo.setEstadoAccion(DetalleGrupo.ESTADO_CREAR);
        detalleGrupo.setEstado(DetalleGrupo.ESTADO_ACTIVO);
        detalleGrupo.setId(listaDetalleGrupo.size() + 1);
        if (cliente.getEstado().equals(Cliente.ESTADO_ACTIVO)) {
            if (!estaRegistradoCliente(cliente)) {
                this.listaDetalleGrupo.add(detalleGrupo);
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    public boolean estaRegistradoCliente(Cliente cliente) {
        for (DetalleGrupo detalleGrupo : listaDetalleGrupo) {
            if (cliente.getId() == detalleGrupo.getCliente().getId()) {
                return true;
            }
        }
        return false;
    }

    public boolean eliminarDetalleGrupo(int codigo) {
        int contador = 0;
        for (DetalleGrupo detalleGrupo : listaDetalleGrupo) {
            if (detalleGrupo.getId() == codigo) {

                listaDetalleGrupo.remove(contador);

                return true;
            }
            contador++;

        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<DetalleGrupo> getListaDetalleGrupo() {
        return listaDetalleGrupo;
    }

    public void setListaDetalleGrupo(List<DetalleGrupo> listaDetalleGrupo) {
        this.listaDetalleGrupo = listaDetalleGrupo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //reglas de negocio
    public boolean esCorrectoFechaRegistro() {
        java.util.Date fechaActual = new java.util.Date();
        return fechaActual.equals(fechaCreacion);
    }

    public Object generaNombreIntegrantes() {

        String nombreIntegrante = "";
        for (DetalleGrupo detalleGrupo : listaDetalleGrupo) {
            if (detalleGrupo.getCliente() != null) {
                nombreIntegrante = nombreIntegrante + "\n" + detalleGrupo.getCliente().generaNombre();
            }

        }
        return nombreIntegrante;
    }

    public Object generaDNIIntegrantes() {
        String nombreIntegrante = "";
        for (DetalleGrupo detalleGrupo : listaDetalleGrupo) {
            if (detalleGrupo.getCliente() != null) {
                nombreIntegrante = nombreIntegrante + "\n" + detalleGrupo.getCliente().getDni();
            }

        }
        return nombreIntegrante;
    }

}
