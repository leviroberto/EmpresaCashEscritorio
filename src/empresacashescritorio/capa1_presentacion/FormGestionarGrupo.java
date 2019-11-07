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
import empresacashescritorio.capa3_dominio.Grupo;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mastersoft.modelo.ModeloTabla;
import mastersoft.tabladatos.Columna;
import mastersoft.tabladatos.Fila;
import mastersoft.tabladatos.Tabla;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class FormGestionarGrupo extends javax.swing.JDialog {

    private RegistrarGrupoServicio registrarGrupoServicio;
    private List<Grupo> listaGrupo = null;
    private int filaSeleccionada = -1;

    public FormGestionarGrupo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            popMenu.add(pnlMenu);
            registrarGrupoServicio = new RegistrarGrupoServicio();
            inicializarTablaColumnas();
            llenarDatosGenerales();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popMenu = new javax.swing.JPopupMenu();
        pnlMenu = new javax.swing.JPanel();
        btn_modificar = new fivecodbutton.FiveCodButton();
        btn_eliminar = new fivecodbutton.FiveCodButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_grupo = new FiveCodTable.FiveCodJTable();
        jPanel8 = new javax.swing.JPanel();
        fiveCodButton2 = new fivecodbutton.FiveCodButton();
        fiveCodButton3 = new fivecodbutton.FiveCodButton();
        txt_dniCliente = new org.jdesktop.swingx.JXSearchField();
        fiveCodButton4 = new fivecodbutton.FiveCodButton();

        popMenu.setBackground(new java.awt.Color(65, 94, 255));
        popMenu.setForeground(new java.awt.Color(65, 94, 255));
        popMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));

        btn_modificar.setBackground(new java.awt.Color(65, 94, 255));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_eliminar.setBackground(new java.awt.Color(65, 94, 255));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(65, 94, 255), 2));

        jPanel6.setBackground(new java.awt.Color(65, 94, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GESTIONAR GRUPOS");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel7.setBorder(dropShadowBorder1);

        table_grupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table_grupo.setComponentPopupMenu(popMenu);
        table_grupo.setGrosorBordeFilas(0);
        table_grupo.setGrosorBordeHead(0);
        table_grupo.setRowHeight(20);
        table_grupo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                table_grupoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(table_grupo);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel8.setBorder(dropShadowBorder2);

        fiveCodButton2.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton2.setText("CREAR");
        fiveCodButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton2ActionPerformed(evt);
            }
        });

        fiveCodButton3.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton3.setColorHover(new java.awt.Color(253, 173, 1));
        fiveCodButton3.setText("CANCELAR");
        fiveCodButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton3ActionPerformed(evt);
            }
        });

        txt_dniCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(65, 94, 255)));
        txt_dniCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_dniCliente.setPrompt("DNI DEL CLIENTE");
        txt_dniCliente.setPromptFontStyle(new java.lang.Integer(4));
        txt_dniCliente.setPromptForeground(new java.awt.Color(65, 94, 255));
        txt_dniCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_dniClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_dniClienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniClienteKeyTyped(evt);
            }
        });

        fiveCodButton4.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton4.setColorHover(new java.awt.Color(253, 173, 1));
        fiveCodButton4.setText("BUSCAR");
        fiveCodButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fiveCodButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fiveCodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(txt_dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fiveCodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveCodButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveCodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fiveCodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_dniCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(1038, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void fiveCodButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton2ActionPerformed
        try {
            VentanaGrupoDatos f = new VentanaGrupoDatos(null, true);
            f.setVisible(true);
            llenarDatosGenerales();
        } catch (Exception e) {
        }        // TODO add your handling code here:
    }//GEN-LAST:event_fiveCodButton2ActionPerformed

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJDialog.MousePressed(evt);
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJDialog.MouseDraggedJDialog(evt, this);
    }//GEN-LAST:event_formMouseDragged

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed

    private void table_grupoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_grupoMousePressed
        filaSeleccionada = table_grupo.getSelectedRow();
    }//GEN-LAST:event_table_grupoMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        try {
            Grupo grupo = buscarCliente((int) table_grupo.getValueAt(filaSeleccionada, 0));
            VentanaGrupoGeneral ventanaDatosCliente = new VentanaGrupoGeneral(null, true, grupo);
            ventanaDatosCliente.setVisible(true);
            llenarDatosGenerales();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        if (filaSeleccionada != -1) {
            int codigo = (int) table_grupo.getValueAt(filaSeleccionada, 0);
            int indice = JOptionPane.showConfirmDialog(this, "Desea eliminar", "FiveCod: Pregunta", JOptionPane.YES_NO_OPTION);
            if (indice == 1) {
                return;
            }
            try {
                int registros_afectados = registrarGrupoServicio.eliminar(codigo);
                if (registros_afectados == 1) {
                    Mensaje.mostrarAfirmacionDeEliminacion();
                    llenarDatosGenerales();
                } else {
                    Mensaje.mostrarErrorDeEliminacion();
                }

            } catch (Exception e) {
                Mensaje.mostrarAdvertenciaDeEliminacion();
            }

        } else {
            Mensaje.mostrarFilaNoSeleccionada();
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void txt_dniClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniClienteKeyTyped
        Verificador.verificarNumeros(evt, txt_dniCliente, 8);
    }//GEN-LAST:event_txt_dniClienteKeyTyped

    private void fiveCodButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton3ActionPerformed
        try {
            llenarDatosGenerales();
        } catch (Exception ex) {
            Mensaje.mostrarAdvertencia(ex.getMessage());
        }
    }//GEN-LAST:event_fiveCodButton3ActionPerformed

    private void fiveCodButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton4ActionPerformed
        buscarClientes();
    }//GEN-LAST:event_fiveCodButton4ActionPerformed

    private void txt_dniClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniClienteKeyPressed

    }//GEN-LAST:event_txt_dniClienteKeyPressed

    private void txt_dniClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniClienteKeyReleased
        buscarClientes();
    }//GEN-LAST:event_txt_dniClienteKeyReleased

    private void buscarClientes() {
        try {
            String dni = txt_dniCliente.getText();

            if (!dni.isEmpty()) {
                llenarDatosLike(dni);
            } else {
                llenarDatosGenerales();
            }
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
    }

    private void llenarDatosGenerales() throws Exception {
        listaGrupo = registrarGrupoServicio.mostrar();
        llenarDatosTabla();
    }

    private void llenarDatosLike(String dni) throws Exception {
        listaGrupo = registrarGrupoServicio.buscarClienteLike(dni);
        llenarDatosTabla();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fivecodbutton.FiveCodButton btn_eliminar;
    private fivecodbutton.FiveCodButton btn_modificar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodbutton.FiveCodButton fiveCodButton2;
    private fivecodbutton.FiveCodButton fiveCodButton3;
    private fivecodbutton.FiveCodButton fiveCodButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPopupMenu popMenu;
    private FiveCodTable.FiveCodJTable table_grupo;
    private org.jdesktop.swingx.JXSearchField txt_dniCliente;
    // End of variables declaration//GEN-END:variables
//metodos creados por el usuario
    private void inicializarTablaColumnas() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("NOMBRE", "java.lang.String"));
        tabla.agregarColumna(new Columna("DESCRIPCIÓN", "java.lang.String"));
        tabla.agregarColumna(new Columna("FECHA CREACION", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));

        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        table_grupo.setModel(modeloTabla);
        table_grupo.getColumn(table_grupo.getColumnName(0)).setWidth(0);
        table_grupo.getColumn(table_grupo.getColumnName(0)).setMinWidth(0);
        table_grupo.getColumn(table_grupo.getColumnName(0)).setMaxWidth(0);
    }

    private void llenarDatosTabla() throws Exception {

        Fila filaTabla;
        try {
            ModeloTabla modeloTabla = (ModeloTabla) table_grupo.getModel();
            modeloTabla.eliminarTotalFilas();
            if (listaGrupo.size() == 0) {
                Mensaje.mostrarAdvertenciaSinElementos();
            } else {
                for (Grupo grupo : listaGrupo) {
                    filaTabla = new Fila();
                    filaTabla.agregarValorCelda(grupo.getId());
                    filaTabla.agregarValorCelda(grupo.getNombre());
                    filaTabla.agregarValorCelda(grupo.getDescripcion());
                    filaTabla.agregarValorCelda(grupo.getFechaCreacion());
                    filaTabla.agregarValorCelda(grupo.getEstado());

                    modeloTabla.agregarFila(filaTabla);
                }
                modeloTabla.refrescarDatos();
            }

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema();
        }

    }

    private Grupo buscarCliente(int codigo) {
        Grupo grupoEncotnrado = null;
        for (Grupo grupo : listaGrupo) {
            if (grupo.getId() == codigo) {
                grupoEncotnrado = grupo;
            }
        }
        return grupoEncotnrado;
    }

}
