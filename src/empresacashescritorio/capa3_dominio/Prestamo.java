/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa3_dominio;

import empresacashescritorio.capa1_presentacion.util.Verificador;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author l9531
 */
public class Prestamo {

    private int id;
    private Cliente cliente;

    private Date fechaInicio;
    private Date fechaFin;
    private Date fechaPago;

    private Double monto;
    private String estado;

    private List<Prestamo> listaPrestamo;

    public static final String ESTADO_ACTIVO = "Activo";
    public static final String ESTADO_PAGADO = "Pagado";

    public Prestamo() {
        this.fechaInicio = Date.valueOf(LocalDate.now());
        listaPrestamo = new ArrayList<>();
    }

    public List<Prestamo> getListaPrestamo() {
        return listaPrestamo;
    }

    public void setListaPrestamo(List<Prestamo> listaPrestamo) {
        this.listaPrestamo = listaPrestamo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //reglas de negocio 
    public boolean esCorrectoFechaInicio() {
        return fechaInicio.before(fechaFin);
    }

    public boolean esCorrectoFechaFin() {
        int totalDias = Verificador.obtenerDiasEntreFechas(fechaInicio, fechaFin);
        return totalDias >= 0 && totalDias <= 7;
    }

    public boolean estaVigentePrestamo() {
        java.util.Date fechaActual = new java.util.Date();
        int operador = fechaFin.compareTo(fechaActual);
        boolean estadoAux = false;

        if (operador >= 0) {
            if (estado.equals(Prestamo.ESTADO_ACTIVO)) {
                estadoAux = true;
            }
        }
        return estadoAux;
    }

    public double obtenerMontoDe() {
        double monto = 20.0;
        return monto;
    }

    public double obtenerMontoHasta() {
        double monto = 20.0;
        int puntosAcumulados = calcularPuntosAcumulados();
        if (listaPrestamo.size() > 0) {
            if (puntosAcumulados >= 0 && puntosAcumulados <= 5) {
                monto = 20.0;
            } else if (puntosAcumulados >= 6 && puntosAcumulados <= 10) {
                monto = 30.0;
            } else if (puntosAcumulados >= 11 && puntosAcumulados <= 15) {
                monto = 40.0;
            } else if (puntosAcumulados >= 16 && puntosAcumulados <= 20) {
                monto = 50.0;
            } else if (puntosAcumulados >= 21 && puntosAcumulados <= 25) {
                monto = 60.0;
            } else if (puntosAcumulados >= 26 && puntosAcumulados <= 30) {
                monto = 70.0;
            } else if (puntosAcumulados >= 31 && puntosAcumulados <= 35) {
                monto = 80.0;
            }
        }
        return monto;
    }

    public int calcularPuntosAcumulados() {
        int puntos = 0;
        for (Prestamo prestamo : listaPrestamo) {
            puntos++;
        }
        return puntos;

    }

    public boolean estaPagado() {
        return estado.equals(ESTADO_PAGADO);
    }

    public double calcularComision() {
        return monto * 0.10;
    }

    public double calcularTotal() {
        double mora = calcularMora();
        double comision = calcularComision();
        return monto + comision + mora;
    }

    public double generarMontoMora() {
        double mora = 0.0;
        if (monto >= 20.0 && monto <= 30.0) {
            mora = 0.10;
        } else if (monto >= 31.0 && monto <= 40.0) {
            mora = 0.20;
        } else if (monto >= 41.0 && monto <= 50.0) {
            mora = 0.30;
        } else if (monto >= 51.0 && monto <= 60.0) {
            mora = 0.40;
        } else if (monto >= 61.0 && monto <= 70.0) {
            mora = 0.50;
        } else if (monto >= 71.0 && monto <= 80.0) {
            mora = 0.60;
        }
        return mora;
    }

    public boolean esMontoCorrecto() {
        double monto_de = obtenerMontoDe();
        double monto_hasta = obtenerMontoHasta();
        return monto >= monto_de && monto <= monto_hasta;
    }

    public int calcularTotalDiasAtrazados() {
        int totalDias = 0;
        totalDias = Verificador.obtenerDiasEntreFechas(fechaFin, new java.util.Date());
        return totalDias;
    }

    public String calcularEstado() {
        String estadoAux = "";
        int totalDias = calcularTotalDiasAtrazados();
        if (totalDias == 0) {
            estadoAux = "A tiempo";
        } else {
            estadoAux = "Atrazado";
        }
        return estadoAux;
    }

    public double calcularMora() {
        double moraPorDiasAtrazados = generarMontoMora();
        double mora = 0.0;
        int totalDiasAtrazados = calcularTotalDiasAtrazados();
        if (totalDiasAtrazados == 0 ||totalDiasAtrazados<0) {
            mora = 0.0;
        } else {
            mora = totalDiasAtrazados * moraPorDiasAtrazados;
        }
        return mora;
    }

}
