/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.GestionarDescripcionPrestamoServicio;
import empresacashescritorio.capa3_dominio.DescripcionPrestamo;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaDescripcionPrestamoDatos extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private DescripcionPrestamo descripcionPrestamo;
    private GestionarDescripcionPrestamoServicio gestionarDescripcionPrestamoServicio;
    
    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoAFP = 0;
    
    public VentanaDescripcionPrestamoDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        gestionarDescripcionPrestamoServicio = new GestionarDescripcionPrestamoServicio();
        tipo_accion = ACCION_CREAR;
    }
    
    public VentanaDescripcionPrestamoDatos(java.awt.Frame parent, boolean modal, DescripcionPrestamo descripcionPrestamo) {
        super(parent, modal);
        initComponents();
        gestionarDescripcionPrestamoServicio = new GestionarDescripcionPrestamoServicio();
        tipo_accion = ACCION_MODIFICAR;
        this.descripcionPrestamo = descripcionPrestamo;
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
        fiveCodLabelImage1 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
        txt_comision = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_monto = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage3 = new fivecodlabelimage.FiveCodLabelImage();
        txt_mora = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage4 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage5 = new fivecodlabelimage.FiveCodLabelImage();
        txt_puntos = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        cbx_estado = new FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox();
        txt_descripcion = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage6 = new fivecodlabelimage.FiveCodLabelImage();
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
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));
        jPanel3.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 50, 50));

        txt_comision.setForeground(new java.awt.Color(65, 94, 255));
        txt_comision.setAccent(new java.awt.Color(0, 132, 235));
        txt_comision.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_comision.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_comision.setLabel("COMISIÓN");
        txt_comision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_comisionActionPerformed(evt);
            }
        });
        txt_comision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_comisionKeyTyped(evt);
            }
        });
        jPanel3.add(txt_comision, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 210, 60));

        txt_monto.setForeground(new java.awt.Color(65, 94, 255));
        txt_monto.setAccent(new java.awt.Color(0, 132, 235));
        txt_monto.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_monto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_monto.setLabel("MONTO");
        txt_monto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_montoActionPerformed(evt);
            }
        });
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 210, 60));
        jPanel3.add(fiveCodLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 50));

        txt_mora.setForeground(new java.awt.Color(65, 94, 255));
        txt_mora.setAccent(new java.awt.Color(0, 132, 235));
        txt_mora.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_mora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_mora.setLabel("MORA");
        txt_mora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_moraActionPerformed(evt);
            }
        });
        txt_mora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_moraKeyTyped(evt);
            }
        });
        jPanel3.add(txt_mora, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 210, 60));
        jPanel3.add(fiveCodLabelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 50, 50));
        jPanel3.add(fiveCodLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 50, 50));

        txt_puntos.setForeground(new java.awt.Color(65, 94, 255));
        txt_puntos.setAccent(new java.awt.Color(0, 132, 235));
        txt_puntos.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_puntos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_puntos.setLabel("PUNTOS");
        txt_puntos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_puntosActionPerformed(evt);
            }
        });
        txt_puntos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_puntosKeyTyped(evt);
            }
        });
        jPanel3.add(txt_puntos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 210, 60));

        cbx_estado.setBackground(new java.awt.Color(255, 255, 255));
        cbx_estado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(65, 94, 255)));
        cbx_estado.setForeground(new java.awt.Color(65, 94, 255));
        cbx_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ESTADO", "ACTIVO", "INACTIVO" }));
        cbx_estado.setToolTipText("UNIVERSIDAD");
        cbx_estado.setAccent(new java.awt.Color(65, 94, 255));
        cbx_estado.setHint("CARGO");
        jPanel3.add(cbx_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 190, 50));

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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_descripcionKeyTyped(evt);
            }
        });
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 250, 210, 60));
        jPanel3.add(fiveCodLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 50, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 300, 380));

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
        jPanel4.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, 60));

        btnGuardar.setBackground(new java.awt.Color(255, 255, 255));
        btnGuardar.setBorder(null);
        btnGuardar.setText("Guardar");
        btnGuardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel4.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 320, 140));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(323, 481));
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
            descripcionPrestamo = new DescripcionPrestamo();
            descripcionPrestamo.setComision(Double.parseDouble(txt_comision.getText().toString()));
            descripcionPrestamo.setEstado(cbx_estado.getSelectedItem().toString());
            descripcionPrestamo.setMonto(Double.parseDouble(txt_monto.getText().toString()));
            descripcionPrestamo.setMora(Double.parseDouble(txt_mora.getText().toString()));
            descripcionPrestamo.setPuntos(Integer.parseInt(txt_puntos.getText().toString()));
            descripcionPrestamo.setDescripcion(txt_descripcion.getText().toString());
            
            int registrosAfectados = 0;
            if (tipo_accion == ACCION_CREAR) {
                try {
                    registrosAfectados = gestionarDescripcionPrestamoServicio.guardar(descripcionPrestamo);
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
                descripcionPrestamo.setId(this.codigoAFP);
                try {
                    registrosAfectados = gestionarDescripcionPrestamoServicio.modificar(descripcionPrestamo);
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

    private void txt_comisionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_comisionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_comisionActionPerformed

    private void txt_montoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_montoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_montoActionPerformed

    private void txt_moraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_moraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moraActionPerformed

    private void txt_puntosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_puntosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_puntosActionPerformed

    private void txt_puntosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_puntosKeyTyped
        Verificador.verificarNumerosDecimales(evt, txt_puntos, 9);
    }//GEN-LAST:event_txt_puntosKeyTyped

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        Verificador.verificarNumerosDecimales(evt, txt_monto, 9);
    }//GEN-LAST:event_txt_montoKeyTyped

    private void txt_moraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moraKeyTyped
        Verificador.verificarNumerosDecimales(evt, txt_mora, 9);
    }//GEN-LAST:event_txt_moraKeyTyped

    private void txt_comisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_comisionKeyTyped
        Verificador.verificarNumerosDecimales(evt, txt_comision, 9);
    }//GEN-LAST:event_txt_comisionKeyTyped

    private void txt_descripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_descripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionActionPerformed

    private void txt_descripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_descripcionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_descripcionKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btnCancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btnGuardar;
    private FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox cbx_estado;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage3;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage4;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage5;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblDescripcion;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_comision;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_descripcion;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_monto;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_mora;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_puntos;
    // End of variables declaration//GEN-END:variables
 private boolean verificarCampos() {
        int contador = 0, aux = 0;
        contador = Verificador.verificadorCampos(txt_comision);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_monto);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_mora);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_puntos);
        aux = contador + aux;
        
        contador = Verificador.verificarCombobox(cbx_estado);
        aux = contador + aux;
        return aux == 5;
    }
    
    private void llenarCampos() {
        if (descripcionPrestamo != null) {
            this.txt_comision.setText(String.valueOf(descripcionPrestamo.getComision()));
            this.txt_monto.setText(String.valueOf(descripcionPrestamo.getMonto()));
            this.txt_mora.setText(String.valueOf(descripcionPrestamo.getMora()));
            this.txt_puntos.setText(String.valueOf(descripcionPrestamo.getPuntos()));
            this.txt_descripcion.setText(descripcionPrestamo.getDescripcion());
            for (int i = 0; i < cbx_estado.getItemCount(); i++) {
                if (descripcionPrestamo.getEstado().equals(cbx_estado.getItemAt(i).toString())) {
                    cbx_estado.setSelectedIndex(i);
                }
            }
            this.codigoAFP = descripcionPrestamo.getId();
        } else {
            Mensaje.mostrarAdvertencia("AFP no encontrado");
        }
        
    }
    
}
