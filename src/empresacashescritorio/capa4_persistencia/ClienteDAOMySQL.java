/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa5_excepciones.ExcepcionSQLConsulta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FiveCod Software
 */
public class ClienteDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public ClienteDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(Cliente cliente) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_Agregar_sp(?,?,?,?,?,?,?,?,?,?,?)");
            prcProcedimientoAlmacenado.setString(1, cliente.getNombre());
            prcProcedimientoAlmacenado.setString(2, cliente.getApellidos());
            prcProcedimientoAlmacenado.setString(3, cliente.getCorreoElectronico());
            prcProcedimientoAlmacenado.setString(4, cliente.getDni());
            prcProcedimientoAlmacenado.setDate(5, cliente.getFechaNacimiento());
            prcProcedimientoAlmacenado.setString(6, cliente.getGenero());
            prcProcedimientoAlmacenado.setInt(7, cliente.getCelular());
            prcProcedimientoAlmacenado.setString(8, cliente.getUniversidad());
            prcProcedimientoAlmacenado.setString(9, cliente.getCarrera());
            prcProcedimientoAlmacenado.setString(10, cliente.getEstado());
            prcProcedimientoAlmacenado.setInt(11, cliente.getTipoCliente().getId());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'C_Dni'")) {
                throw new SQLException("El dni ingresado ya se encuntra registrado");
            } else if (arreglo[5].equals("'C_CorreoElectronico'")) {
                throw new SQLException("El email ya se encuentra registrado");
            } else {
                throw new SQLException("No se pudo registrar Al cliente.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }

        }
    }

    public int modificar(Cliente cliente) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_Modificar_sp(?,?,?,?,?,?,?,?,?,?,?,?)");

            prcProcedimientoAlmacenado.setString(1, cliente.getNombre());
            prcProcedimientoAlmacenado.setString(2, cliente.getApellidos());
            prcProcedimientoAlmacenado.setString(3, cliente.getCorreoElectronico());
            prcProcedimientoAlmacenado.setString(4, cliente.getDni());
            prcProcedimientoAlmacenado.setDate(5, cliente.getFechaNacimiento());
            prcProcedimientoAlmacenado.setString(6, cliente.getGenero());
            prcProcedimientoAlmacenado.setInt(7, cliente.getCelular());
            prcProcedimientoAlmacenado.setString(8, cliente.getUniversidad());
            prcProcedimientoAlmacenado.setString(9, cliente.getCarrera());
            prcProcedimientoAlmacenado.setString(10, cliente.getEstado());
            prcProcedimientoAlmacenado.setInt(11, cliente.getTipoCliente().getId());
            prcProcedimientoAlmacenado.setInt(12, cliente.getId());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'C_Dni'")) {
                throw new SQLException("El dni ingresado ya se encuntra registrado");
            } else if (arreglo[5].equals("'C_CorreoElectronico'")) {
                throw new SQLException("El email ya se encuentra registrado");
            } else {
                throw new SQLException("No se pudo actualizar Al cliente.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }

        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el cliente.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public List<Cliente> mostrar() throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        List<Cliente> listCliente = new ArrayList<>();
        Cliente cliente;
        cliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_mostrar_sp()");

            resultado = prcProcedimientoAlmacenado.executeQuery();

            TipoClienteDAOMySQL tipoClienteDAOMySQL = new TipoClienteDAOMySQL(gestorJDBC);

            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("C_Id"));
                cliente.setNombre(resultado.getString("C_Nombre"));
                cliente.setApellidos(resultado.getString("C_Apellidos"));
                cliente.setCorreoElectronico(resultado.getString("C_CorreoElectronico"));
                cliente.setDni(resultado.getString("C_Dni"));
                cliente.setFechaNacimiento(resultado.getDate("C_FechaNacimiento"));
                cliente.setGenero(resultado.getString("C_Genero"));
                cliente.setCelular(resultado.getInt("C_Celular"));
                cliente.setUniversidad(resultado.getString("C_Universidad"));
                cliente.setCarrera(resultado.getString("C_Carrrera"));
                cliente.setEstado(resultado.getString("C_Estado"));
                cliente.setTipoCliente(tipoClienteDAOMySQL.buscar(resultado.getInt("TC_Id")));
                listCliente.add(cliente);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listCliente;

    }

    public Cliente buscar(int codigo) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        Cliente cliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_buscar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                cliente = new Cliente();
                cliente = new Cliente();
                cliente.setId(resultado.getInt("C_Id"));
                cliente.setNombre(resultado.getString("C_Nombre"));
                cliente.setApellidos(resultado.getString("C_Apellidos"));
                cliente.setCorreoElectronico(resultado.getString("C_CorreoElectronico"));
                cliente.setDni(resultado.getString("C_Dni"));
                cliente.setFechaNacimiento(resultado.getDate("C_FechaNacimiento"));
                cliente.setGenero(resultado.getString("C_Genero"));
                cliente.setCelular(resultado.getInt("C_Celular"));
                cliente.setUniversidad(resultado.getString("C_Universidad"));
                cliente.setCarrera(resultado.getString("C_Carrrera"));
                cliente.setEstado(resultado.getString("C_Estado"));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return cliente;

    }

    public Cliente buscarDNI(String dni) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        Cliente cliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_buscarDni_sp(?)");
            prcProcedimientoAlmacenado.setString(1, dni);

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                cliente = new Cliente();
                cliente = new Cliente();
                cliente.setId(resultado.getInt("C_Id"));
                cliente.setNombre(resultado.getString("C_Nombre"));
                cliente.setApellidos(resultado.getString("C_Apellidos"));
                cliente.setCorreoElectronico(resultado.getString("C_CorreoElectronico"));
                cliente.setDni(resultado.getString("C_Dni"));
                cliente.setFechaNacimiento(resultado.getDate("C_FechaNacimiento"));
                cliente.setGenero(resultado.getString("C_Genero"));
                cliente.setCelular(resultado.getInt("C_Celular"));
                cliente.setUniversidad(resultado.getString("C_Universidad"));
                cliente.setCarrera(resultado.getString("C_Carrrera"));
                cliente.setEstado(resultado.getString("C_Estado"));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return cliente;

    }

    public List<Cliente> buscarCliente(String dni) throws SQLException {
        ResultSet resultado;
        List<Cliente> listCliente = new ArrayList<>();
        Cliente cliente;
        cliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Cliente_buscarClientes_sp(?)");
            prcProcedimientoAlmacenado.setString(1, dni);
            resultado = prcProcedimientoAlmacenado.executeQuery();

            TipoClienteDAOMySQL tipoClienteDAOMySQL = new TipoClienteDAOMySQL(gestorJDBC);

            while (resultado.next()) {
                cliente = new Cliente();
                cliente.setId(resultado.getInt("C_Id"));
                cliente.setNombre(resultado.getString("C_Nombre"));
                cliente.setApellidos(resultado.getString("C_Apellidos"));
                cliente.setCorreoElectronico(resultado.getString("C_CorreoElectronico"));
                cliente.setDni(resultado.getString("C_Dni"));
                cliente.setFechaNacimiento(resultado.getDate("C_FechaNacimiento"));
                cliente.setGenero(resultado.getString("C_Genero"));
                cliente.setCelular(resultado.getInt("C_Celular"));
                cliente.setUniversidad(resultado.getString("C_Universidad"));
                cliente.setCarrera(resultado.getString("C_Carrrera"));
                cliente.setEstado(resultado.getString("C_Estado"));
                cliente.setTipoCliente(tipoClienteDAOMySQL.buscar(resultado.getInt("TC_Id")));
                listCliente.add(cliente);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listCliente;
    }

}
