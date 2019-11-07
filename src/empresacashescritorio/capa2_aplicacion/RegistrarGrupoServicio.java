/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.Grupo;
import empresacashescritorio.capa4_persistencia.ClienteDAOMySQL;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.GrupoDAOMySQL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class RegistrarGrupoServicio {

    private final GestorJDBC gestorJDBC;

    private final GrupoDAOMySQL grupoDAOMySQL;
    private ClienteDAOMySQL clienteDAOMySQL;

    public RegistrarGrupoServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        grupoDAOMySQL = new GrupoDAOMySQL(gestorJDBC);
        clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
    }

    public int guardar(Grupo grupo) throws Exception {
        int numerosAfecatdos = 0;

        gestorJDBC.abrirConexion();
        numerosAfecatdos = grupoDAOMySQL.agregar(grupo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(Grupo grupo) throws Exception {
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = grupoDAOMySQL.modificar(grupo);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public List<Grupo> mostrar() throws Exception {
        List<Grupo> listaGrupo = null;
        gestorJDBC.abrirConexion();
        listaGrupo = grupoDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listaGrupo;
    }

    public Grupo buscar(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Grupo grupo = grupoDAOMySQL.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return grupo;
    }

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = grupoDAOMySQL.eliminar(codigo);
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

    public Grupo obtenerUltimoRegistro() throws Exception {
        gestorJDBC.abrirConexion();
        Grupo grupo = grupoDAOMySQL.obtenerUltimoRegistro();
        gestorJDBC.cerrarConexion();
        if (grupo == null) {
            grupo = new Grupo();
            grupo.setNombre("GRUPO N° 1");
            grupo.setDescripcion("PARA PRESTAMOS");
        }
        return grupo;

    }

    public List<Grupo> buscarClienteLike(String dni)throws Exception {
         List<Grupo> listaGrupo = null;
        gestorJDBC.abrirConexion();
        listaGrupo = grupoDAOMySQL.buscarClienteLike(dni);
        gestorJDBC.cerrarConexion();
        return listaGrupo;
    }

}
