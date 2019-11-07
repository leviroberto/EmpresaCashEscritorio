/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa3_dominio;

import empresacashescritorio.capa1_presentacion.util.Verificador;
import java.sql.Date;

/**
 *
 * @author l9531
 */
public class Cliente {

    private int id;
    private String nombre;
    private String apellidos;
    private String correoElectronico;
    private String dni;
    private Date fechaNacimiento;
    private String genero;
    private int celular;
    private String universidad;
    private String carrera;
    private String estado;
    private TipoCliente tipoCliente;
    public static final String ESTADO_ACTIVO = "Activo";
    public static final String ESTADO_INACTIVO = "Inactivo";

    public Cliente() {
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String generaNombre() {
        return apellidos + ", " + nombre;
    }

    //reglas de negoico
    public boolean esCorrectoFechaNacimiento() {
        java.util.Date fechaActual = new java.util.Date();
        int totalDias = Verificador.obtenerDiasEntreFechas(fechaNacimiento, fechaActual);
        if (totalDias == 0) {
            return false;
        } else if (totalDias > 6570) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esCorrectoCorreoElectronico() {
        return Verificador.verificarCorreoElectronico(correoElectronico);
    }

     public boolean esCorrectoCelular() {
         
        return String.valueOf(celular).length()==9;
    }

}
