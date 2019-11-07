/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.TipoCliente;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.TipoClienteDAOMySQL;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class GestionarTipoClienteServicio {

    private final GestorJDBC gestorJDBC;
    
    private final TipoClienteDAOMySQL tipoClienteDAOMySQL;

    public GestionarTipoClienteServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        tipoClienteDAOMySQL = new TipoClienteDAOMySQL(gestorJDBC);
    }

    public int guardar(TipoCliente tipoCliente) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = tipoClienteDAOMySQL.agregar(tipoCliente);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(TipoCliente tipoCliente) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = tipoClienteDAOMySQL.modificar(tipoCliente);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public List<TipoCliente> mostrar() throws Exception {
        List<TipoCliente> listaTipoCliente = null;
        gestorJDBC.abrirConexion();
        listaTipoCliente = tipoClienteDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listaTipoCliente;
    }

    public TipoCliente buscarTipoClientePorCodigo(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        TipoCliente tipoCliente = tipoClienteDAOMySQL.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return tipoCliente;
    }

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = tipoClienteDAOMySQL.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return numeroAfectados;
    }

}
