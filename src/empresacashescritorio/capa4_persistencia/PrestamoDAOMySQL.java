/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.Prestamo;
import empresacashescritorio.capa5_excepciones.ExcepcionSQLConsulta;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Fila;

/**
 *
 * @author FiveCod Software
 */
public class PrestamoDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public PrestamoDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(Prestamo prestamo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_Agregar_sp(?,?,?,?,?)");
            prcProcedimientoAlmacenado.setInt(1, prestamo.getCliente().getId());
            prcProcedimientoAlmacenado.setDate(2, prestamo.getFechaInicio());
            prcProcedimientoAlmacenado.setDate(3, prestamo.getFechaFin());

            prcProcedimientoAlmacenado.setString(4, prestamo.getEstado());
            prcProcedimientoAlmacenado.setDouble(5, prestamo.getMonto());
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el prestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

    public int modificar(Prestamo prestamo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_Modificar_sp(?,?,?,?,?,?)");

            prcProcedimientoAlmacenado.setInt(1, prestamo.getCliente().getId());
            prcProcedimientoAlmacenado.setDate(2, prestamo.getFechaInicio());
            prcProcedimientoAlmacenado.setDate(3, prestamo.getFechaFin());

            prcProcedimientoAlmacenado.setString(4, prestamo.getEstado());
            prcProcedimientoAlmacenado.setDouble(5, prestamo.getMonto());
            prcProcedimientoAlmacenado.setInt(6, prestamo.getId());
            int resultado = prcProcedimientoAlmacenado.executeUpdate();

            return 1;
        } catch (Exception e) {
            throw new SQLException("No se pudo registrar el prestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el prestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public int pagar(Prestamo prestamo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_pagar_sp(?,?,?)");
            prcProcedimientoAlmacenado.setString(1, prestamo.getEstado());
            prcProcedimientoAlmacenado.setDate(2, prestamo.getFechaPago());
            prcProcedimientoAlmacenado.setInt(3, prestamo.getId());
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo procesar el pago del prestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
    }

    public List<Prestamo> mostrar() throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        Prestamo prestamo = null;
        List<Prestamo> listaPrestamos = new ArrayList<>();
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_mostrar_sp()");

            ClienteDAOMySQL clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                prestamo = new Prestamo();
                prestamo.setId(resultado.getInt("P_Id"));
                prestamo.setCliente(clienteDAOMySQL.buscar(resultado.getInt("C_ID")));
                prestamo.setFechaInicio(resultado.getDate("P_FechaInicio"));
                prestamo.setFechaFin(resultado.getDate("P_FechaFin"));
                prestamo.setFechaPago(resultado.getDate("P_FechaPago"));
                prestamo.setMonto(resultado.getDouble("P_Monto"));
                prestamo.setEstado(resultado.getString("P_Estado"));
                prestamo.setListaPrestamo(buscarPrestamoRangoFecha(prestamo));
                listaPrestamos.add(prestamo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return listaPrestamos;

    }

    public List<Prestamo> buscarPrestamoRangoFecha(Prestamo prestamoAux) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        Prestamo prestamo = null;
        List<Prestamo> listaPrestamos = new ArrayList<>();
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_buscarPrestamoRangoFecha_sp(?)");
            prcProcedimientoAlmacenado.setDate(1, prestamoAux.getFechaInicio());

            ClienteDAOMySQL clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                prestamo = new Prestamo();
                prestamo.setId(resultado.getInt("P_Id"));
                prestamo.setCliente(clienteDAOMySQL.buscar(resultado.getInt("C_ID")));
                prestamo.setFechaInicio(resultado.getDate("P_FechaInicio"));
                prestamo.setFechaFin(resultado.getDate("P_FechaFin"));
                prestamo.setFechaPago(resultado.getDate("P_FechaPago"));
                prestamo.setMonto(resultado.getDouble("P_Monto"));
                prestamo.setEstado(resultado.getString("P_Estado"));
                listaPrestamos.add(prestamo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return listaPrestamos;

    }

    public List<Prestamo> verificarSiTienePrestamoActivo(Cliente clienteSeleccionado) throws SQLException {
        ResultSet resultado;
        Prestamo prestamo = null;
        List<Prestamo> listaPrestamos = new ArrayList<>();
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_verificarSiTienePrestamoActivo_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, clienteSeleccionado.getId());

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                prestamo = new Prestamo();
                prestamo.setId(resultado.getInt("P_Id"));
                prestamo.setCliente(clienteSeleccionado);
                prestamo.setFechaInicio(resultado.getDate("P_FechaInicio"));
                prestamo.setFechaFin(resultado.getDate("P_FechaFin"));
                prestamo.setFechaPago(resultado.getDate("P_FechaPago"));
                prestamo.setMonto(resultado.getDouble("P_Monto"));
                prestamo.setEstado(resultado.getString("P_Estado"));

                listaPrestamos.add(prestamo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return listaPrestamos;
    }

    public List<Prestamo> buscarPorLike(String dni) throws SQLException {
        ResultSet resultado;
        Prestamo prestamo = null;
        List<Prestamo> listaPrestamos = new ArrayList<>();
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Prestamo_buscarPorLike_sp(?)");
            prcProcedimientoAlmacenado.setString(1, dni);

            ClienteDAOMySQL clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);
            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                prestamo = new Prestamo();
                prestamo.setId(resultado.getInt("P_Id"));
                prestamo.setCliente(clienteDAOMySQL.buscar(resultado.getInt("C_ID")));
                prestamo.setFechaInicio(resultado.getDate("P_FechaInicio"));
                prestamo.setFechaFin(resultado.getDate("P_FechaFin"));
                prestamo.setFechaPago(resultado.getDate("P_FechaPago"));
                prestamo.setMonto(resultado.getDouble("P_Monto"));
                prestamo.setEstado(resultado.getString("P_Estado"));
                prestamo.setListaPrestamo(buscarPrestamoRangoFecha(prestamo));
                listaPrestamos.add(prestamo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return listaPrestamos;
    }

}
