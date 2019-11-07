/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.GestionarClienteServicio;
import empresacashescritorio.capa2_aplicacion.RegistrarGrupoServicio;
import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.DetalleGrupo;
import empresacashescritorio.capa3_dominio.Grupo;
import empresacashescritorio.capa3_dominio.TipoCliente;
import empresacashescritorio.capa7_interfaces.Form_Interface;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaGrupoGeneral extends javax.swing.JDialog implements Form_Interface {

    /**
     * Creates new form VentanaDatosAFP
     */
    private RegistrarGrupoServicio registrarGrupoServicio;

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoCliente = 0;
    private Cliente clienteSeleccionado = null;
    private Grupo grupo;
    int filaSeleccionada = -1;

    public VentanaGrupoGeneral(java.awt.Frame parent, boolean modal, Grupo grupo) {
        super(parent, modal);
        initComponents();
        try {
            registrarGrupoServicio = new RegistrarGrupoServicio();
            this.grupo = grupo;
            lbl_NombreGrupo.setText("DATOS DEL " + grupo.getNombre());
            llenarTitulosTabla();
            llenarDatosTabla();
            this.lbl_NombreGrupo.setText("DATOS DEL " + grupo.getNombre());
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new FiveCodTable.FiveCodJTable();
        panel_opciones = new javax.swing.JPanel();
        btn_modificar = new fivecodbutton.FiveCodButton();
        btn_cancelar = new fivecodbutton.FiveCodButton();
        btn_crear = new fivecodbutton.FiveCodButton();
        btn_cancelar1 = new fivecodbutton.FiveCodButton();
        panelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JPanel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        lbl_NombreGrupo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panelCuerpo.setBackground(new java.awt.Color(0, 51, 255));
        panelCuerpo.setLayout(new java.awt.BorderLayout());

        tabla_cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_cliente.setGrosorBordeFilas(0);
        tabla_cliente.setGrosorBordeHead(0);
        tabla_cliente.setRowHeight(20);
        tabla_cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_clienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_cliente);

        javax.swing.GroupLayout panel_tableLayout = new javax.swing.GroupLayout(panel_table);
        panel_table.setLayout(panel_tableLayout);
        panel_tableLayout.setHorizontalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1132, Short.MAX_VALUE)
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        );

        panelCuerpo.add(panel_table, java.awt.BorderLayout.CENTER);

        btn_modificar.setBackground(new java.awt.Color(65, 94, 255));
        btn_modificar.setColorHover(new java.awt.Color(253, 173, 1));
        btn_modificar.setText("AGREGAR INTEGRANTE");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(65, 94, 255));
        btn_cancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btn_cancelar.setText("ELIMINAR INTEGRANTE");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_crear.setBackground(new java.awt.Color(65, 94, 255));
        btn_crear.setColorHover(new java.awt.Color(253, 173, 1));
        btn_crear.setText("GRUPO");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_cancelar1.setBackground(new java.awt.Color(65, 94, 255));
        btn_cancelar1.setColorHover(new java.awt.Color(253, 173, 1));
        btn_cancelar1.setText("CANCELAR");
        btn_cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_opcionesLayout = new javax.swing.GroupLayout(panel_opciones);
        panel_opciones.setLayout(panel_opcionesLayout);
        panel_opcionesLayout.setHorizontalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_opcionesLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(485, Short.MAX_VALUE))
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelCuerpo.add(panel_opciones, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(panelCuerpo, java.awt.BorderLayout.CENTER);

        panelTitulo.setBackground(new java.awt.Color(255, 0, 153));
        panelTitulo.setLayout(new java.awt.BorderLayout());

        titulo.setBackground(new java.awt.Color(65, 94, 255));

        fiveCodButton1.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton1.setBorder(null);
        fiveCodButton1.setColorHover(new java.awt.Color(255, 68, 68));
        fiveCodButton1.setFont(new java.awt.Font("Roboto Bold", 1, 20)); // NOI18N
        fiveCodButton1.setLabel("X");
        fiveCodButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton1ActionPerformed(evt);
            }
        });

        lbl_NombreGrupo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbl_NombreGrupo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NombreGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NombreGrupo.setText("TITULO");

        javax.swing.GroupLayout tituloLayout = new javax.swing.GroupLayout(titulo);
        titulo.setLayout(tituloLayout);
        tituloLayout.setHorizontalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_NombreGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, 1007, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tituloLayout.setVerticalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(lbl_NombreGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelTitulo.add(titulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(1132, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void tabla_clienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clienteMousePressed
        filaSeleccionada = tabla_cliente.getSelectedRow();
    }//GEN-LAST:event_tabla_clienteMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        agregarIntegranteGrupo();
        llenarDatosTabla();
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        eliminarDetalle();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        datosGrupo();
    }//GEN-LAST:event_btn_crearActionPerformed

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed

    private void btn_cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelar1ActionPerformed

    private void datosGrupo() {
        VentanaGrupoDatos d = new VentanaGrupoDatos(null, true, grupo);
        d.setVisible(true);
    }

    private void integrantes() {
        try {
            VentanaGrupoIntegrantes d = new VentanaGrupoIntegrantes(null, true, grupo);
            d.setVisible(true);
            this.grupo = registrarGrupoServicio.buscar(grupo.getId());
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
    }

    private void eliminarDetalle() {
        try {
            if (filaSeleccionada != -1) {
                int codigo = (int) tabla_cliente.getValueAt(filaSeleccionada, 0);
                int indice = JOptionPane.showConfirmDialog(this, "Desea eliminar", "FiveCod: Pregunta", JOptionPane.YES_NO_OPTION);
                if (indice == 1) {
                    return;
                }
                try {
                    int numeroAfectado = registrarGrupoServicio.eliminarDetalleGrupo(codigo);
                    if (numeroAfectado == 1) {
                        Mensaje.mostrarAfirmacionDeEliminacion();
                        grupo.eliminarDetalleGrupo(codigo);
                        llenarDatosTabla();
                    } else {
                        Mensaje.mostrarErrorDeEliminacion();
                    }

                } catch (Exception e) {
                    Mensaje.mostrarAdvertenciaDeEliminacion();
                }

            } else {
                Mensaje.mostrarFilaNoSeleccionada();
            }
        } catch (Exception e) {
            Mensaje.mostrarFilaNoSeleccionada();
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fivecodbutton.FiveCodButton btn_cancelar;
    private fivecodbutton.FiveCodButton btn_cancelar1;
    private fivecodbutton.FiveCodButton btn_crear;
    private fivecodbutton.FiveCodButton btn_modificar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_NombreGrupo;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel panel_opciones;
    private javax.swing.JPanel panel_table;
    private FiveCodTable.FiveCodJTable tabla_cliente;
    private javax.swing.JPanel titulo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void llenarTitulosTabla() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("CLIENTE", "java.lang.String"));
        tabla.agregarColumna(new Columna("EMAIL", "java.lang.String"));
        tabla.agregarColumna(new Columna("DNI", "java.lang.String"));
        tabla.agregarColumna(new Columna("FECHA NACIMIENTO", "java.lang.String"));
        tabla.agregarColumna(new Columna("GENERO", "java.lang.String"));
        tabla.agregarColumna(new Columna("CELULAR", "java.lang.String"));
        tabla.agregarColumna(new Columna("UNIVERSIDAD", "java.lang.String"));
        tabla.agregarColumna(new Columna("FECHA UNIÓN", "java.lang.String"));

        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));

        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tabla_cliente.setModel(modeloTabla);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setWidth(0);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setMinWidth(0);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setMaxWidth(0);
    }

    @Override
    public void llenarDatosTabla() {
        try {
            Fila filaTabla;
            ModeloTabla modeloTabla = (ModeloTabla) tabla_cliente.getModel();
            modeloTabla.eliminarTotalFilas();
            if (grupo.getListaDetalleGrupo().size() == 0) {
                Mensaje.mostrarAdvertenciaSinElementos();
            } else {
                for (DetalleGrupo detalleGrupo : grupo.getListaDetalleGrupo()) {
                    filaTabla = new Fila();
                    filaTabla.agregarValorCelda(detalleGrupo.getId());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().generaNombre());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getCorreoElectronico());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getDni());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getFechaNacimiento());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getGenero());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getCelular());
                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getUniversidad());
                    filaTabla.agregarValorCelda(detalleGrupo.getFechaCreacion());

                    filaTabla.agregarValorCelda(detalleGrupo.getCliente().getEstado());

                    modeloTabla.agregarFila(filaTabla);
                }
                modeloTabla.refrescarDatos();
            }

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema();
        }
    }

    @Override
    public void buscarDatosConLike() {
    }

    @Override
    public void buscarDatosSinlike() {
    }

    @Override
    public void eliminar() {
    }

    @Override
    public void crear() {
    }

    @Override
    public void modificar() {
    }

    @Override
    public void cancelar() {
    }

    @Override
    public void buscar() {
    }

    @Override
    public void inabilitarBotones(boolean estado) {
    }

    @Override
    public void pintarBotones(boolean estado) {
    }

//methods create for programers
    private void agregarIntegranteGrupo() {
        VentanaGrupoIntegrantes ventanaGrupoIntegrantes = new VentanaGrupoIntegrantes(null, true, grupo);
        ventanaGrupoIntegrantes.setVisible(true);
    }
}
