/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.GestionarClienteServicio;
import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa7_interfaces.Form_Interface;
import java.awt.Color;
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
public class FormPlantilla extends javax.swing.JDialog implements Form_Interface {

    public FormPlantilla(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        llenarTitulosTabla();
        llenarDatosTabla();
        inabilitarBotones(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCuerpo = new javax.swing.JPanel();
        panel_table = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_cliente = new FiveCodTable.FiveCodJTable();
        panel_opciones = new javax.swing.JPanel();
        btn_eliminar = new fivecodbutton.FiveCodButton();
        fiveCodButton4 = new fivecodbutton.FiveCodButton();
        btn_modificar = new fivecodbutton.FiveCodButton();
        btn_cancelar = new fivecodbutton.FiveCodButton();
        btn_crear = new fivecodbutton.FiveCodButton();
        jTextField1 = new javax.swing.JTextField();
        panelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JPanel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jLabel3 = new javax.swing.JLabel();

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
            .addComponent(jScrollPane1)
        );
        panel_tableLayout.setVerticalGroup(
            panel_tableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );

        panelCuerpo.add(panel_table, java.awt.BorderLayout.CENTER);

        btn_eliminar.setBackground(new java.awt.Color(65, 94, 255));
        btn_eliminar.setColorHover(new java.awt.Color(253, 173, 1));
        btn_eliminar.setText("ELIMINAR");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
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

        btn_modificar.setBackground(new java.awt.Color(65, 94, 255));
        btn_modificar.setColorHover(new java.awt.Color(253, 173, 1));
        btn_modificar.setText("MODIFICAR");
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(65, 94, 255));
        btn_cancelar.setColorHover(new java.awt.Color(253, 173, 1));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_crear.setBackground(new java.awt.Color(65, 94, 255));
        btn_crear.setColorHover(new java.awt.Color(253, 173, 1));
        btn_crear.setText("CREAR");
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
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
                .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(fiveCodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panel_opcionesLayout.setVerticalGroup(
            panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_opcionesLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panel_opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveCodButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_crear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("TITULO");

        javax.swing.GroupLayout tituloLayout = new javax.swing.GroupLayout(titulo);
        titulo.setLayout(tituloLayout);
        tituloLayout.setHorizontalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 913, Short.MAX_VALUE)
                .addGap(85, 85, 85)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        tituloLayout.setVerticalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        panelTitulo.add(titulo, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelTitulo, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(1038, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged

    }//GEN-LAST:event_formMouseDragged

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void fiveCodButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton4ActionPerformed

    }//GEN-LAST:event_fiveCodButton4ActionPerformed

    private void tabla_clienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clienteMousePressed

    }//GEN-LAST:event_tabla_clienteMousePressed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        inabilitarBotones(true);
        pintarBotones(true);
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_crearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private fivecodbutton.FiveCodButton btn_cancelar;
    private fivecodbutton.FiveCodButton btn_crear;
    private fivecodbutton.FiveCodButton btn_eliminar;
    private fivecodbutton.FiveCodButton btn_modificar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodbutton.FiveCodButton fiveCodButton2;
    private fivecodbutton.FiveCodButton fiveCodButton3;
    private fivecodbutton.FiveCodButton fiveCodButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
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
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));

        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tabla_cliente.setModel(modeloTabla);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setWidth(0);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setMinWidth(0);
        tabla_cliente.getColumn(tabla_cliente.getColumnName(0)).setMaxWidth(0);
    }

    @Override
    public void llenarDatosTabla() {
    }

    @Override
    public void eliminar() {
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
//metodos creados por el usuario

    @Override
    public void crear() {
    }

    @Override
    public void inabilitarBotones(boolean estado) {
         pintarBotones(estado);
        btn_cancelar.setEnabled(true);
        btn_crear.setEnabled(estado);
        btn_eliminar.setEnabled(!estado);
        btn_modificar.setEnabled(!estado);
    }

    @Override
    public void pintarBotones(boolean estado) {
        btn_crear.setBackground(new Color(65, 94, 255));
        btn_eliminar.setBackground(new Color(65, 94, 255));
        btn_modificar.setBackground(new Color(65, 94, 255));
      
        if (estado) {
            btn_crear.setBackground(new Color(253, 173, 1));
        } else {
            btn_eliminar.setBackground(new Color(253, 173, 1));
            btn_modificar.setBackground(new Color(253, 173, 1));

        }
    }

    @Override
    public void buscarDatosConLike() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void buscarDatosSinlike() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
