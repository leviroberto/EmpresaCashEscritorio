/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.GestionarTipoClienteServicio;
import empresacashescritorio.capa3_dominio.TipoCliente;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaTipoClienteDatos extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private TipoCliente tipoCliente;
    private GestionarTipoClienteServicio gestionarTipoClienteServicio;
    
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoAFP = 0;
    
    public VentanaTipoClienteDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        gestionarTipoClienteServicio = new GestionarTipoClienteServicio();
        tipo_accion = ACCION_CREAR;
        txt_estado.setText(TipoCliente.ESTADO_ACTIVO);
        Verificador.seleccionarFocus(txt_descripcion);
    }
    
    public VentanaTipoClienteDatos(java.awt.Frame parent, boolean modal, TipoCliente tipoCliente) {
        super(parent, modal);
        initComponents();
        gestionarTipoClienteServicio = new GestionarTipoClienteServicio();
        tipo_accion = ACCION_MODIFICAR;
        this.tipoCliente = tipoCliente; 
        
        llenarCampos();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel3 = new javax.swing.JPanel();
        lblDescripcion = new javax.swing.JLabel();
        lblPersonal = new javax.swing.JLabel();
        fiveCodLabelImage1 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_descripcion = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jPanel4 = new javax.swing.JPanel();
        btnCancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btnGuardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(65, 94, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(65, 94, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS DE AFP");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 320, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 210, 10));

        lblPersonal.setForeground(new java.awt.Color(51, 204, 0));
        jPanel3.add(lblPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 10));
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));
        jPanel3.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 50, 50));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setEnabled(false);
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        jPanel3.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 210, 60));

        txt_descripcion.setForeground(new java.awt.Color(65, 94, 255));
        txt_descripcion.setAccent(new java.awt.Color(0, 132, 235));
        txt_descripcion.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setLabel("DESCRIPCIÒN");
        txt_descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_descripcionActionPerformed(evt);
            }
        });
        txt_descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyReleased(evt);
            }
        });
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 210, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 302, 150));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setBorder(null);
        btnCancelar.setText("cancelar");
        btnCancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 130, 60));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setBorder(null);
        btnGuardar.setText("Guardar");
        btnGuardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 94, 320, 150));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(326, 244));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJDialog.MousePressed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJDialog.MouseDraggedJDialog(evt, this);       // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (verificarCampos()) {
            tipoCliente = new TipoCliente();
            tipoCliente.setDescripcion(txt_descripcion.getText().toString());
            tipoCliente.setEstado(txt_estado.getText());
            int registrosAfectados = 0;
            if (tipo_accion == ACCION_CREAR) {
                try {
                    registrosAfectados = gestionarTipoClienteServicio.guardar(tipoCliente);
                    if (registrosAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion();
                        this.dispose();
                    } else if (registrosAfectados == 0) {
                        Mensaje.mostrarErrorDeCreacion();
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(e.getMessage());
                }
            } else if (tipo_accion == ACCION_MODIFICAR) {
                tipoCliente.setId(this.codigoAFP);
                try {
                    registrosAfectados = gestionarTipoClienteServicio.modificar(tipoCliente);
                    if (registrosAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeActualizacion();
                        this.dispose();
                    } else {
                        Mensaje.mostrarMensajeDefinido("La AFP ya existe");
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void txt_descripcionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyReleased
        txt_descripcion.setText(txt_descripcion.getText().toUpperCase());
    }//GEN-LAST:event_txt_descripcionKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btnCancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btnGuardar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblPersonal;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_descripcion;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    // End of variables declaration//GEN-END:variables
 private boolean verificarCampos() {
        int contador = 0, aux = 0;        
        contador = Verificador.verificadorCampos(txt_descripcion);
        aux = contador + aux;
        return aux == 1;
    }
    
    private void llenarCampos() {
        if (tipoCliente != null) {
            this.txt_descripcion.setText(tipoCliente.getDescripcion());
            this.txt_estado.setText(String.valueOf(tipoCliente.getEstado()));
            this.codigoAFP = tipoCliente.getId();
        } else {
            Mensaje.mostrarAdvertencia("AFP no encontrado");
        }
        
    }
    
}
