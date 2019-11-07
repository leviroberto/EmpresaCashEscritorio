/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa3_dominio.DescripcionPrestamo;
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
public class DescripcionPrestamoDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public DescripcionPrestamoDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(DescripcionPrestamo descripcionPrestamo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DescripcionPrestamo_Agregar_sp(?,?,?,?,?,?)");
            prcProcedimientoAlmacenado.setString(1, descripcionPrestamo.getEstado());
            prcProcedimientoAlmacenado.setDouble(2, descripcionPrestamo.getComision());
            prcProcedimientoAlmacenado.setDouble(3, descripcionPrestamo.getMonto());
            prcProcedimientoAlmacenado.setDouble(4, descripcionPrestamo.getMora());
            prcProcedimientoAlmacenado.setInt(5, descripcionPrestamo.getPuntos());
            prcProcedimientoAlmacenado.setString(6, descripcionPrestamo.getDescripcion());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'DP_Descripcion'")) {
                throw new SQLException("La descripcion del prestamo ya existe");
            } else {
                throw new SQLException("No se pudo registrar la descripcion de prestamo.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }
        }
    }

    public int modificar(DescripcionPrestamo descripcionPrestamo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DescripcionPrestamo_Modificar_sp(?,?,?,?,?,?,?)");

            prcProcedimientoAlmacenado.setDouble(1, descripcionPrestamo.getComision());
            prcProcedimientoAlmacenado.setDouble(2, descripcionPrestamo.getMonto());
            prcProcedimientoAlmacenado.setDouble(3, descripcionPrestamo.getMora());
            prcProcedimientoAlmacenado.setInt(4, descripcionPrestamo.getPuntos());
            prcProcedimientoAlmacenado.setString(5, descripcionPrestamo.getDescripcion());
            prcProcedimientoAlmacenado.setString(6, descripcionPrestamo.getEstado());

            prcProcedimientoAlmacenado.setInt(7, descripcionPrestamo.getId());
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'DP_Descripcion'")) {
                throw new SQLException("La descripcion del prestamo ya existe");
            } else {
                throw new SQLException("No se pudo registrar la descripcion de prestamo.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }
        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DescripcionPrestamo_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el descripcionPrestamo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public List<DescripcionPrestamo> mostrar() throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        List<DescripcionPrestamo> listDescripcionPrestamo = new ArrayList<>();
        DescripcionPrestamo descripcionPrestamo;
        descripcionPrestamo = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DescripcionPrestamo_mostrar_sp()");

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                descripcionPrestamo = new DescripcionPrestamo();
                descripcionPrestamo.setId(resultado.getInt("DP_Id"));
                descripcionPrestamo.setMonto(resultado.getDouble("DP_Monto"));
                descripcionPrestamo.setMora(resultado.getDouble("DP_Mora"));
                descripcionPrestamo.setPuntos(resultado.getInt("DP_Puntos"));
                descripcionPrestamo.setComision(resultado.getDouble("DP_Comision"));
                descripcionPrestamo.setEstado(resultado.getString("DP_Estado"));
                descripcionPrestamo.setDescripcion(resultado.getString("DP_Descripcion"));

                listDescripcionPrestamo.add(descripcionPrestamo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listDescripcionPrestamo;

    }

    public DescripcionPrestamo buscar(int codigo) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        DescripcionPrestamo descripcionPrestamo = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("DescripcionPrestamo_buscar_sp(?)");
            prcProcedimientoAlmacenado.setInt("codigo", codigo);

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                descripcionPrestamo = new DescripcionPrestamo();
                descripcionPrestamo.setEstado(resultado.getString("TC_Descripcion"));
                descripcionPrestamo.setEstado(resultado.getString("TC_Estado"));

                descripcionPrestamo.setId(resultado.getInt("TC_Id"));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return descripcionPrestamo;

    }

}
