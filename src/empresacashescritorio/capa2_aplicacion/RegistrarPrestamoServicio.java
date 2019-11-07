/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.Prestamo;
import empresacashescritorio.capa4_persistencia.ClienteDAOMySQL;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.PrestamoDAOMySQL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class RegistrarPrestamoServicio {

    private final GestorJDBC gestorJDBC;

    private final PrestamoDAOMySQL prestamoDAOMySQL;
    private ClienteDAOMySQL clienteDAOMySQL;

    public RegistrarPrestamoServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        prestamoDAOMySQL = new PrestamoDAOMySQL(gestorJDBC);
        clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
    }

    public int guardar(Prestamo prestamo) throws Exception {
        int numerosAfecatdos = 0;
        if (!prestamo.esCorrectoFechaFin()) {
            throw new SQLException("La fecha fin es incorrecto");
        }

        gestorJDBC.abrirConexion();
        numerosAfecatdos = prestamoDAOMySQL.agregar(prestamo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(Prestamo prestamo) throws Exception {
        int numerosAfecatdos = 0;
        if (!prestamo.esCorrectoFechaFin()) {
            throw new SQLException("La fecha fin es incorrecto");
        }
        gestorJDBC.abrirConexion();
        numerosAfecatdos = prestamoDAOMySQL.modificar(prestamo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int pagar(Prestamo prestamo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        prestamo.setEstado(Prestamo.ESTADO_PAGADO);
        numerosAfecatdos = prestamoDAOMySQL.pagar(prestamo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public List<Prestamo> mostrar() throws Exception {
        List<Prestamo> listaPrestamo = null;
        gestorJDBC.abrirConexion();
        listaPrestamo = prestamoDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listaPrestamo;
    }

   

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = prestamoDAOMySQL.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return numeroAfectados;
    }

    public Cliente verificarDniCliente(String dni) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAOMySQL.buscarDNI(dni);
        gestorJDBC.cerrarConexion();
        if (cliente == null) {
            throw new SQLException("El cliente no esta registrado");
        }
        return cliente;
    }

    public void verificarSiTienePrestamoActivo(Cliente clienteSeleccionado) throws Exception {

        gestorJDBC.abrirConexion();
        List<Prestamo> listPrestamo = prestamoDAOMySQL.verificarSiTienePrestamoActivo(clienteSeleccionado);
        gestorJDBC.cerrarConexion();

        for (Prestamo prestamo : listPrestamo) {
            if (prestamo.estaVigentePrestamo()) {
                throw new SQLException("El cliente tiene prestamos pendiente por cancelar");
            }
        }

    }

    public List<Prestamo> buscarPrestamoRangoFecha(Prestamo prestamo) throws Exception {

        gestorJDBC.abrirConexion();
        List<Prestamo> listPrestamo = prestamoDAOMySQL.buscarPrestamoRangoFecha(prestamo);
        gestorJDBC.cerrarConexion();
        return listPrestamo;

    }

    public void verificarParaCalcular(Prestamo prestamo, List<Prestamo> listPrestamo) throws Exception {
        if (!prestamo.esCorrectoFechaFin()) {
            throw new SQLException("La fecha fin es incorrecto");
        }
        if (!prestamo.esMontoCorrecto()) {
            throw new SQLException("El monto ingresado es correcto");
        }
    }

    public void sePuedeModificar(Prestamo prestamo) throws Exception {
        if (prestamo.estaPagado()) {
            throw new SQLException("El prestamo ya se encuntra pagado ");
        }
    }

    public void sePuedeEliminar(Prestamo prestamo) throws Exception {
        if (prestamo.estaPagado()) {
            throw new SQLException("El prestamo no se puede eliminar porque  ya esta esta procezado");
        }
    }

    public List<Prestamo> buscarPorLike(String dni)throws Exception  {
           gestorJDBC.abrirConexion();
        List<Prestamo> listPrestamo = prestamoDAOMySQL.buscarPorLike(dni);
        gestorJDBC.cerrarConexion();
        return listPrestamo;
    }

}
