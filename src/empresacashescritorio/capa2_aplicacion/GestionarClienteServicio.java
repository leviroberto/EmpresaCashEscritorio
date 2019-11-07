/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa2_aplicacion;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.TipoCliente;
import empresacashescritorio.capa4_persistencia.GestorJDBC;
import empresacashescritorio.capa4_persistencia.GestorJDBCMySQL;
import empresacashescritorio.capa4_persistencia.ClienteDAOMySQL;
import empresacashescritorio.capa4_persistencia.TipoClienteDAOMySQL;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author hjaim
 */
public class GestionarClienteServicio {

    private final GestorJDBC gestorJDBC;

    private final ClienteDAOMySQL clienteDAOMySQL;
    private final TipoClienteDAOMySQL tipoClienteDAOMySQL;

    public GestionarClienteServicio() {
        gestorJDBC = new GestorJDBCMySQL();
        clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
        tipoClienteDAOMySQL = new TipoClienteDAOMySQL(gestorJDBC);
    }

    public int guardar(Cliente cliente) throws Exception {

        //verificamos las reglas de negocio 
        if (!cliente.esCorrectoFechaNacimiento()) {
            throw new SQLException("El cliente debe ser mayor de edad");
        }

        if (!cliente.esCorrectoCorreoElectronico()) {
            throw new SQLException("El correo electronico es incorrecto");
        }
        if (!cliente.esCorrectoCelular()) {
            throw new SQLException("El N° Celular es incorrecto");
        }

        
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = clienteDAOMySQL.agregar(cliente);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public int modificar(Cliente cliente) throws Exception {
        if (!cliente.esCorrectoFechaNacimiento()) {
            throw new SQLException("El cliente debe ser mayor de edad");
        }

        if (!cliente.esCorrectoCorreoElectronico()) {
            throw new SQLException("El correo electronico es incorrecto");
        }
        if (!cliente.esCorrectoCelular()) {
            throw new SQLException("El N° Celular es incorrecto");
        }
        int numerosAfecatdos = 0;
        gestorJDBC.abrirConexion();
        numerosAfecatdos = clienteDAOMySQL.modificar(cliente);
        gestorJDBC.cerrarConexion();
        return numerosAfecatdos;
    }

    public List<Cliente> mostrar() throws Exception {
        List<Cliente> listaCliente = null;
        gestorJDBC.abrirConexion();
        listaCliente = clienteDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listaCliente;
    }

    public Cliente buscarClientePorCodigo(int codigo) throws Exception {
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAOMySQL.buscar(codigo);
        gestorJDBC.cerrarConexion();
        return cliente;
    }

    public int buscarDni(String dni) throws Exception {
        int resultado = 1;
        gestorJDBC.abrirConexion();
        Cliente cliente = clienteDAOMySQL.buscarDNI(dni);
        gestorJDBC.cerrarConexion();
        // validamos la existencia del dni
        if (cliente != null) {
            if (cliente.getDni().equals(dni)) {
                resultado = 0;
                throw new SQLException("El Dni ingresado ya se encuentra registrado");
            }
        } else {
            resultado = 1;
        }
        return resultado;
    }

    public int eliminar(int codigo) throws Exception {
        int numeroAfectados = 0;
        gestorJDBC.abrirConexion();
        numeroAfectados = clienteDAOMySQL.eliminar(codigo);
        gestorJDBC.cerrarConexion();
        return numeroAfectados;
    }

    public List<TipoCliente> mostrarTipoCliente() throws Exception {
        List<TipoCliente> listatipoCliente = null;
        gestorJDBC.abrirConexion();
        listatipoCliente = tipoClienteDAOMySQL.mostrar();
        gestorJDBC.cerrarConexion();
        return listatipoCliente;
    }

    public List<Cliente> buscarCliente(String dni) throws Exception {
        List<Cliente> listaCliente = null;
        gestorJDBC.abrirConexion();
        listaCliente = clienteDAOMySQL.buscarCliente(dni);
        gestorJDBC.cerrarConexion();
        return listaCliente;
    }

}
