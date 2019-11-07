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
public class GrupoDAOMySQL {

    private final GestorJDBC gestorJDBC;

    public GrupoDAOMySQL(GestorJDBC gestorJDBC) {
        this.gestorJDBC = gestorJDBC;
    }

    public int agregar(Grupo grupo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_Agregar_sp(?,?,?,?)");
            prcProcedimientoAlmacenado.setString(1, grupo.getDescripcion());
            prcProcedimientoAlmacenado.setString(2, grupo.getEstado());
            prcProcedimientoAlmacenado.setString(3, grupo.getNombre());
            prcProcedimientoAlmacenado.setDate(4, grupo.getFechaCreacion());

            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'G_Nombre'")) {
                throw new SQLException("El grupo con el nombre " + grupo.getNombre() + " ya existet");
            }
            {
                throw new SQLException("No se pudo registrar el grupo.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }

        }
    }

    public int modificar(Grupo grupo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_Modificar_sp(?,?,?,?,?)");
            DetalleGrupoDAOMySQL detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);

            prcProcedimientoAlmacenado.setString(1, grupo.getDescripcion());
            prcProcedimientoAlmacenado.setString(2, grupo.getEstado());
            prcProcedimientoAlmacenado.setString(3, grupo.getNombre());
            prcProcedimientoAlmacenado.setDate(4, grupo.getFechaCreacion());
            prcProcedimientoAlmacenado.setInt(5, grupo.getId());
            int resultado = prcProcedimientoAlmacenado.executeUpdate();
            for (DetalleGrupo detalleGrupo : grupo.getListaDetalleGrupo()) {
                if (detalleGrupo.getEstadoAccion().equals(DetalleGrupo.ESTADO_CREAR)) {
                    resultado = detalleGrupoDAOMySQL.agregar(detalleGrupo);
                } else if (detalleGrupo.getEstadoAccion().equals(DetalleGrupo.ESTADO_ACTUALIZAR)) {
                    resultado = detalleGrupoDAOMySQL.modificar(detalleGrupo);
                } else if (detalleGrupo.getEstadoAccion().equals(DetalleGrupo.ESTADO_ELIMINAR)) {
                    resultado = detalleGrupoDAOMySQL.eliminar(detalleGrupo.getId());
                }
            }
            return resultado;
        } catch (Exception e) {
            String arreglo[] = e.getMessage().split(" ");
            if (arreglo[5].equals("'G_Nombre'")) {
                throw new SQLException("El grupo con el nombre " + grupo.getNombre() + " ya existet");
            }
            {
                throw new SQLException("No se pudo registrar el grupo.\n"
                        + "Intente de nuevo o consulte con el Administrador." + arreglo[5]);
            }
        }

    }

    public int eliminar(int codigo) throws SQLException {
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_Eliminar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);
            return prcProcedimientoAlmacenado.executeUpdate();
        } catch (Exception e) {
            throw new SQLException("No se pudo eliminar el grupo.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }

    }

    public List<Grupo> mostrar() throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        List<Grupo> listGrupo = new ArrayList<>();
        Grupo grupo;
        grupo = null;
        try {
            DetalleGrupoDAOMySQL detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_mostrar_sp()");

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                grupo = new Grupo();
                grupo.setId(resultado.getInt("G_Id"));
                grupo.setDescripcion(resultado.getString("G_Descripcion"));
                grupo.setEstado(resultado.getString("G_Estado"));
                grupo.setFechaCreacion(resultado.getDate("G_FechaCreacion"));
                grupo.setNombre(resultado.getString("G_Nombre"));
                grupo.setListaDetalleGrupo(detalleGrupoDAOMySQL.buscarGrupo(grupo));
                listGrupo.add(grupo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listGrupo;

    }

    public Grupo buscar(int codigo) throws ExcepcionSQLConsulta, SQLException {
        ResultSet resultado;
        Grupo grupo = null;
        try {
            DetalleGrupoDAOMySQL detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_buscar_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, codigo);

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                grupo = new Grupo();
                grupo.setId(resultado.getInt("G_Id"));
                grupo.setDescripcion(resultado.getString("G_Descripcion"));
                grupo.setEstado(resultado.getString("G_Estado"));
                grupo.setFechaCreacion(resultado.getDate("G_FechaCreacion"));
                grupo.setNombre(resultado.getString("G_Nombre"));
                grupo.setListaDetalleGrupo(detalleGrupoDAOMySQL.buscarGrupo(grupo));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return grupo;

    }

    public Grupo verificarSiEstaEnGrupo(Cliente clienteSeleccionado) throws SQLException {
        ResultSet resultado;
        Grupo grupo = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_verificarSiEstaEnGrupo_sp(?)");
            prcProcedimientoAlmacenado.setInt(1, clienteSeleccionado.getId());

            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                grupo = new Grupo();
                grupo.setId(resultado.getInt("G_Id"));
                grupo.setDescripcion(resultado.getString("G_Descripcion"));
                grupo.setEstado(resultado.getString("G_Estado"));
                grupo.setFechaCreacion(resultado.getDate("G_FechaCreacion"));
                grupo.setNombre(resultado.getString("G_Nombre"));

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return grupo;
    }

    public Grupo obtenerUltimoRegistro() throws SQLException {
        ResultSet resultado;
        Grupo grupo = null;
        try {
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_obtenerUltimoRegistro_sp()");

            resultado = prcProcedimientoAlmacenado.executeQuery();
            DetalleGrupoDAOMySQL detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);

            while (resultado.next()) {
                grupo = new Grupo();
                grupo.setId(resultado.getInt("G_Id"));
                grupo.setDescripcion(resultado.getString("G_Descripcion"));
                grupo.setNombre(resultado.getString("G_Nombre"));

                grupo.setEstado(resultado.getString("G_Estado"));
                grupo.setFechaCreacion(resultado.getDate("G_FechaCreacion"));
                grupo.setListaDetalleGrupo(detalleGrupoDAOMySQL.buscarGrupo(grupo));
            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");

        }

        return grupo;
    }

    public List<Grupo> buscarClienteLike(String dni) throws SQLException {
        ResultSet resultado;
        List<Grupo> listGrupo = new ArrayList<>();
        Grupo grupo;
        grupo = null;
        try {
            DetalleGrupoDAOMySQL detalleGrupoDAOMySQL = new DetalleGrupoDAOMySQL(gestorJDBC);
            CallableStatement prcProcedimientoAlmacenado = gestorJDBC.prepareCall("Grupo_buscarClienteLike_sp(?)");
            prcProcedimientoAlmacenado.setString(1, dni);
            resultado = prcProcedimientoAlmacenado.executeQuery();

            while (resultado.next()) {
                grupo = new Grupo();
                grupo.setId(resultado.getInt("G_Id"));
                grupo.setDescripcion(resultado.getString("G_Descripcion"));
                grupo.setEstado(resultado.getString("G_Estado"));
                grupo.setFechaCreacion(resultado.getDate("G_FechaCreacion"));
                grupo.setNombre(resultado.getString("G_Nombre"));
                grupo.setListaDetalleGrupo(detalleGrupoDAOMySQL.buscarGrupo(grupo));
                listGrupo.add(grupo);

            }
            resultado.close();

        } catch (Exception e) {
            throw new SQLException("No se pudo Mostrar los empleados.\n"
                    + "Intente de nuevo o consulte con el Administrador.");
        }
        return listGrupo;
    }

}
