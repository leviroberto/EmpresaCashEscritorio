/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.DescripcionPrestamo;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.DescripcionPrestamoDAOMySQL;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class GestionarDescripcionPrestamoServicio {

    private final GestorJDBC gestorJDBC;
    
    private final DescripcionPrestamoDAOMySQL descripcionPrestamoDAOMySQL;

    public GestionarDescripcionPrestamoServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        descripcionPrestamoDAOMySQL = new DescripcionPrestamoDAOMySQL(gestorJDBC);
    }

    public int guardar(DescripcionPrestamo descripcionPrestamo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = descripcionPrestamoDAOMySQL.agregar(descripcionPrestamo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(DescripcionPrestamo descripcionPrestamo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = descripcionPrestamoDAOMySQL.modificar(descripcionPrestamo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public List<DescripcionPrestamo> mostrar() throws Exception {
        List<DescripcionPrestamo> listaDescripcionPrestamo = null;
        gestorJDBC.abrirConexion();
        listaDescripcionPrestamo = descripcionPrestamoDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listaDescripcionPrestamo;
    }

    public DescripcionPrestamo buscarDescripcionPrestamoPorCodigo(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        DescripcionPrestamo descripcionPrestamo = descripcionPrestamoDAOMySQL.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return descripcionPrestamo;
    }

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = descripcionPrestamoDAOMySQL.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return numeroAfectados;
    }

}
