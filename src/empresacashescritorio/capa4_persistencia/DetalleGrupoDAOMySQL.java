/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.DetalleGrupo;
import empresacashescritorio.capa3_dominio.Grupo;
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
public class DetalleGrupoDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public DetalleGrupoDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(DetalleGrupo detalleGrupo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DetalleGrupo_Agregar_sp(?,?,?,?)");
            prcProcedimientoAlmacenado.setInt(1, detalleGrupo.getCliente().getId());
            prcProcedimientoAlmacenado.setInt(2, detalleGrupo.getGrupo().getId());
            prcProcedimientoAlmacenado.setDate(3, detalleGrupo.getFechaCreacion());
            prcProcedimientoAlmacenado.setString(4, detalleGrupo.getEstado());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            if (e.getMessage().split(" ")[0].equals("Duplicate")) {
                throw new SQLException("El nombre del tipo de cliente ya se encuentra registrado");
            } else {
                throw new SQLException("No se pudo registrar Al detalleGrupo.\n"
                        + "Intente de nuevo o consulte con el Administrador.");
            }

        }
    }

    public int modificar(DetalleGrupo detalleGrupo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DetalleGrupo_Modificar_sp(?,?,?,?,?)");

            prcProcedimientoAlmacenado.setInt(1, detalleGrupo.getCliente().getId());
            prcProcedimientoAlmacenado.setInt(2, detalleGrupo.getGrupo().getId());
            prcProcedimientoAlmacenado.setDate(3, detalleGrupo.getFechaCreacion());
            prcProcedimientoAlmacenado.setString(4, detalleGrupo.getEstado());
            prcProcedimientoAlmacenado.setInt(5, detalleGrupo.getId());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo modificar al detalleGrupo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DetalleGrupo_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el detalleGrupo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public List<DetalleGrupo> buscarGrupo(Grupo grupo) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        DetalleGrupo detalleGrupo = null;
        List<DetalleGrupo> listaDetalleGrupo = new ArrayList<DetalleGrupo>();
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DetalleGrupo_buscarGrupo_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, grupo.getId());

            resultado = prcProcedimientoAlmacenado.executeQuery();
            ClienteDAOMySQL clienteDAOMySQL = new ClienteDAOMySQL(gestorJDBC);

            while (resultado.next()) {
                detalleGrupo = new DetalleGrupo();
                detalleGrupo.setCliente(clienteDAOMySQL.buscar(resultado.getInt("C_Id")));
                detalleGrupo.setGrupo(grupo);
                detalleGrupo.setFechaCreacion(resultado.getDate("C_FechaCreacion"));
                detalleGrupo.setId(resultado.getInt("DG_Id"));
                detalleGrupo.setEstado(resultado.getString("DG_Estado"));
                detalleGrupo.setEstadoAccion(DetalleGrupo.ESTADO_ACTUALIZAR);
                listaDetalleGrupo.add(detalleGrupo);
            }
            resultado.close();
        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return listaDetalleGrupo;

    }

    public DetalleGrupo verificarSiTienePrestamoActivo(Cliente clienteSeleccionado) throws ExcepcionSQLConsulta, SQLException {

        ResultSet resultado;
        DetalleGrupo detalleGrupo = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DetalleGrupo_verificarSiTienePrestamoActivo_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, clienteSeleccionado.getId());

            resultado = prcProcedimientoAlmacenado.executeQuery();
            GrupoDAOMySQL grupoDAOMySQL = new GrupoDAOMySQL(gestorJDBC);

            while (resultado.next()) {
                detalleGrupo = new DetalleGrupo();
                detalleGrupo.setCliente(clienteSeleccionado);
                detalleGrupo.setGrupo(grupoDAOMySQL.buscar(resultado.getInt("G_Id")));
                detalleGrupo.setFechaCreacion(resultado.getDate("C_FechaCreacion"));
                detalleGrupo.setId(resultado.getInt("DG_Id"));
                detalleGrupo.setEstado(resultado.getString("DG_Estado"));
                detalleGrupo.setEstadoAccion(DetalleGrupo.ESTADO_ACTUALIZAR);
            }
            resultado.close();
        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return detalleGrupo;
    }

}
