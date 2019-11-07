/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa3_dominio.TipoCliente;
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
public class TipoClienteDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public TipoClienteDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(TipoCliente tipoCliente) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("TipoCliente_Agregar_sp(?,?)");
            prcProcedimientoAlmacenado.setString(1, tipoCliente.getDescripcion());
            prcProcedimientoAlmacenado.setString(2, tipoCliente.getEstado());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            if (e.getMessage().split(" ")[0].equals("Duplicate")) {
                throw new SQLException("El nombre del tipo de cliente ya se encuentra registrado");
            } else {
                throw new SQLException("No se pudo registrar Al tipoCliente.\n"
                        + "Intente de nuevo o consulte con el Administrador.");
            }

        }
    }

    public int modificar(TipoCliente tipoCliente) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("TipoCliente_Modificar_sp(?,?,?)");

            prcProcedimientoAlmacenado.setString(1, tipoCliente.getDescripcion());
            prcProcedimientoAlmacenado.setString(2, tipoCliente.getEstado());
            prcProcedimientoAlmacenado.setInt(3, tipoCliente.getId());
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo modificar al tipoCliente.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("TipoCliente_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el tipoCliente.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public List<TipoCliente> mostrar() throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        List<TipoCliente> listTipoCliente = new ArrayList<>();
        TipoCliente tipoCliente;
        tipoCliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("TipoCliente_mostrar_sp()");

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                tipoCliente = new TipoCliente();
                tipoCliente.setId(resultado.getInt("TC_Id"));
                tipoCliente.setDescripcion(resultado.getString("TC_Descripcion"));
                tipoCliente.setEstado(resultado.getString("TC_Estado"));

                listTipoCliente.add(tipoCliente);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listTipoCliente;

    }

    public TipoCliente buscar(int codigo) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        TipoCliente tipoCliente = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("TipoCliente_buscar_sp(?)");
            prcProcedimientoAlmacenado.setInt("codigo", codigo);

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                tipoCliente = new TipoCliente();
                tipoCliente.setDescripcion(resultado.getString("TC_Descripcion"));
                tipoCliente.setEstado(resultado.getString("TC_Estado"));

                tipoCliente.setId(resultado.getInt("TC_Id"));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return tipoCliente;

    }

}
