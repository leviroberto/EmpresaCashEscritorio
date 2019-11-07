/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.DetalleGrupo;
import empresacashescritorio.capa3_dominio.Grupo;
import empresacashescritorio.capa4_persistencia.ClienteDAOMySQL;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.DetalleGrupoDAOMySQL;
import empresacashescritorio.capa4_persistencia.GrupoDAOMySQL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class GestionarDetalleGrupoServicio {

    private final GestorJDBC gestorJDBC;
    private final GrupoDAOMySQL grupoDAOMySQL;
    private final DetalleGrupoDAOMySQL detalleGrupoDAOMySQL;
    private ClienteDAOMySQL clienteDAOMySQL;

    public GestionarDetalleGrupoServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);
        clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
        grupoDAOMySQL = new GrupoDAOMySQL(gestorJDBC);
    }

    public int guardar(DetalleGrupo detalleGrupo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = detalleGrupoDAOMySQL.agregar(detalleGrupo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(DetalleGrupo detalleGrupo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = detalleGrupoDAOMySQL.modificar(detalleGrupo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = detalleGrupoDAOMySQL.eliminar(codigo);
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

    public boolean verificarSiEstaEnGrupo(Cliente clienteSeleccionado) throws Exception {
        gestorJDBC.abrirConexion();
        Grupo grupo = grupoDAOMySQL.verificarSiEstaEnGrupo(clienteSeleccionado);
        gestorJDBC.cerrarConexion();
        if (grupo != null) {
            throw new SQLException("El cliente ya se encuentra registrato en el " + grupo.getNombre());
        }
        return true;
    }
}
