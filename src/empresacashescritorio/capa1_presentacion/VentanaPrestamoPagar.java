/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.RegistrarPrestamoServicio;
import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.Prestamo;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaPrestamoPagar extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private Prestamo prestamo;
    private RegistrarPrestamoServicio registrarPrestamoServicio;
    private Cliente clienteSeleccionado = null;
    public static final int ACCION_CREAR = 1;
    public static final int ACCION_MODIFICAR = 2;
    public static final int ACCION_PAGAR = 3;

    private int tipo_accion;
    private int codigoPrestamo = 0;
    List<Prestamo> listaPrestamo;

    public VentanaPrestamoPagar(java.awt.Frame parent, boolean modal, Prestamo prestamo) {
        super(parent, modal);
        initComponents();
        try {
            registrarPrestamoServicio = new RegistrarPrestamoServicio();
            tipo_accion = ACCION_PAGAR;
            this.prestamo = prestamo;
            llenarDatosGenerales();

        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txt_subTotal = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_comision = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_total = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_mora = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_totalDiasAtrazados = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jLabel13 = new javax.swing.JLabel();
        date_fin = new rojeru_san.componentes.RSDateChooser();
        date_inicio = new rojeru_san.componentes.RSDateChooser();
        date_pago = new rojeru_san.componentes.RSDateChooser();
        txt_moraPorDia = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jPanel4 = new javax.swing.JPanel();
        btn_guardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btn_cancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        panelTitulo = new javax.swing.JPanel();
        titulo = new javax.swing.JPanel();
        fiveCodButton3 = new fivecodbutton.FiveCodButton();
        jLabel4 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(65, 94, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DATOS DEL GRUPO");

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
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 726, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(65, 94, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_subTotal.setForeground(new java.awt.Color(65, 94, 255));
        txt_subTotal.setAccent(new java.awt.Color(0, 132, 235));
        txt_subTotal.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_subTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_subTotal.setLabel("SUB TOTAL S/.");
        txt_subTotal.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_subTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_subTotalKeyTyped(evt);
            }
        });
        jPanel3.add(txt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 60));

        txt_comision.setForeground(new java.awt.Color(65, 94, 255));
        txt_comision.setAccent(new java.awt.Color(0, 132, 235));
        txt_comision.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_comision.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_comision.setLabel("COMISIÓN S/.");
        txt_comision.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_comision.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_comisionKeyTyped(evt);
            }
        });
        jPanel3.add(txt_comision, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 140, 60));

        txt_total.setForeground(new java.awt.Color(65, 94, 255));
        txt_total.setAccent(new java.awt.Color(0, 132, 235));
        txt_total.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_total.setLabel("TOTAL S/.");
        txt_total.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalKeyTyped(evt);
            }
        });
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 200, 180, 60));

        txt_mora.setForeground(new java.awt.Color(65, 94, 255));
        txt_mora.setAccent(new java.awt.Color(0, 132, 235));
        txt_mora.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_mora.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_mora.setLabel("MORA S/.");
        txt_mora.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_mora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_moraKeyTyped(evt);
            }
        });
        jPanel3.add(txt_mora, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 150, 60));

        jLabel10.setText("Fechas");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        txt_totalDiasAtrazados.setForeground(new java.awt.Color(65, 94, 255));
        txt_totalDiasAtrazados.setAccent(new java.awt.Color(0, 132, 235));
        txt_totalDiasAtrazados.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_totalDiasAtrazados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_totalDiasAtrazados.setLabel("DIAS ATRAZADOS");
        txt_totalDiasAtrazados.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_totalDiasAtrazados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalDiasAtrazadosKeyTyped(evt);
            }
        });
        jPanel3.add(txt_totalDiasAtrazados, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 200, 60));

        jLabel11.setText("Resumen pago");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 20));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        txt_estado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_estadoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 200, 60));

        jLabel13.setText("Estado");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        date_fin.setColorBackground(new java.awt.Color(64, 95, 255));
        date_fin.setColorButtonHover(new java.awt.Color(64, 95, 255));
        date_fin.setColorForeground(new java.awt.Color(64, 95, 255));
        date_fin.setPlaceholder("FECHA FIN");
        date_fin.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.add(date_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 200, 35));

        date_inicio.setColorBackground(new java.awt.Color(64, 95, 255));
        date_inicio.setColorButtonHover(new java.awt.Color(64, 95, 255));
        date_inicio.setColorForeground(new java.awt.Color(64, 95, 255));
        date_inicio.setPlaceholder("FECHA INICIO");
        date_inicio.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.add(date_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 200, 35));

        date_pago.setColorBackground(new java.awt.Color(64, 95, 255));
        date_pago.setColorButtonHover(new java.awt.Color(64, 95, 255));
        date_pago.setColorForeground(new java.awt.Color(64, 95, 255));
        date_pago.setPlaceholder("FECHA PAGO");
        date_pago.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.add(date_pago, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 200, 35));

        txt_moraPorDia.setForeground(new java.awt.Color(65, 94, 255));
        txt_moraPorDia.setAccent(new java.awt.Color(0, 132, 235));
        txt_moraPorDia.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_moraPorDia.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_moraPorDia.setLabel("MORA POR DIA S/.");
        txt_moraPorDia.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_moraPorDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_moraPorDiaKeyTyped(evt);
            }
        });
        jPanel3.add(txt_moraPorDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 200, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 780, 290));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setBorder(null);
        btn_guardar.setText("guardar");
        btn_guardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 130, 60));

        btn_cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setBorder(null);
        btn_cancelar.setText("cancelar");
        btn_cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 265, 800, 180));

        panelTitulo.setBackground(new java.awt.Color(255, 0, 153));
        panelTitulo.setLayout(new java.awt.BorderLayout());
        jPanel1.add(panelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 0, 870, -1));

        titulo.setBackground(new java.awt.Color(65, 94, 255));

        fiveCodButton3.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton3.setBorder(null);
        fiveCodButton3.setColorHover(new java.awt.Color(255, 68, 68));
        fiveCodButton3.setFont(new java.awt.Font("Roboto Bold", 1, 20)); // NOI18N
        fiveCodButton3.setLabel("X");
        fiveCodButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("PAGAR PRESTAMO");

        javax.swing.GroupLayout tituloLayout = new javax.swing.GroupLayout(titulo);
        titulo.setLayout(tituloLayout);
        tituloLayout.setHorizontalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(fiveCodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        tituloLayout.setVerticalGroup(
            tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addComponent(fiveCodButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(803, 444));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJDialog.MousePressed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJDialog.MouseDraggedJDialog(evt, this);      // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed


    private void txt_subTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_subTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subTotalKeyTyped

    private void txt_comisionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_comisionKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_comisionKeyTyped

    private void txt_totalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalKeyTyped

    private void txt_moraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moraKeyTyped

    private void calcular2() {
        try {
            if (verificarCampos()) {
                Date fechaFin = date_fin.getDatoFecha();
                prestamo.setFechaFin(new java.sql.Date(fechaFin.getTime()));

                registrarPrestamoServicio.verificarParaCalcular(prestamo, listaPrestamo);
                inabilitarPaso4(true);
                llenarCampos3();
            }

        } catch (Exception e) {
            inabilitarPaso4(false);
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
    }


    private void txt_totalDiasAtrazadosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalDiasAtrazadosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalDiasAtrazadosKeyTyped

    private void txt_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_estadoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_estadoKeyTyped

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        //        if (verificarCampos()) {
        //            prestamo = new Prestamo();
        //            prestamo.setDescripcion(txt_celular.getText().toString());
        //            prestamo.setEstado(txt_estado.getText().toString());
        //            prestamo.setNombre(txt_email.getText().toString());
        //
        //            int registrosAfectados = 0;
        //            if (tipo_accion == ACCION_CREAR) {
        //                try {
        //                    registrosAfectados = registrarPrestamoServicio.guardar(prestamo);
        //                    if (registrosAfectados == 1) {
        //                        Mensaje.mostrarAfirmacionDeCreacion();
        //                        Prestamo prestamo = registrarPrestamoServicio.obtenerUltimoRegistro();
        //                        this.dispose();
        //                        VentanaPrestamoGeneral ventanaPrestamoGeneral = new VentanaPrestamoGeneral(null, true, prestamo);
        //                        ventanaPrestamoGeneral.setVisible(true);
        //
        //                    } else if (registrosAfectados == 0) {
        //                        Mensaje.mostrarErrorDeCreacion();
        //                    }
        //                } catch (Exception e) {
        //                    Mensaje.mostrarAdvertencia(e.getMessage());
        //                }
        //
        //            } else if (tipo_accion == ACCION_MODIFICAR) {
        //                prestamo.setId(this.codigoPrestamo);
        //                try {
        //                    registrosAfectados = registrarPrestamoServicio.modificar(prestamo);
        //                    if (registrosAfectados == 1) {
        //                        Mensaje.mostrarAfirmacionDeActualizacion();
        //                        this.dispose();
        //                    } else if (registrosAfectados == 0) {
        //                        Mensaje.mostrarErrorDeActualizacion();
        //                    }
        //                } catch (Exception e) {
        //                    Mensaje.mostrarAdvertencia(e.getMessage());
        //
        //                }
        //            }
        //
        //        }
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (verificarCampos()) {
            prestamo.setCliente(clienteSeleccionado);
            prestamo.setEstado(Prestamo.ESTADO_ACTIVO);
            Date fechaInicio = date_inicio.getDatoFecha();
            prestamo.setFechaInicio(new java.sql.Date(fechaInicio.getTime()));

            Date fechaFin = date_fin.getDatoFecha();
            prestamo.setFechaFin(new java.sql.Date(fechaFin.getTime()));

            Date fechaPago = date_fin.getDatoFecha();
            prestamo.setFechaPago(new java.sql.Date(fechaPago.getTime()));
            int numeroAfectados = 0;
            try {
                if (tipo_accion == ACCION_PAGAR) {
                    numeroAfectados = registrarPrestamoServicio.pagar(prestamo);
                    if (numeroAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion();
                        this.dispose();
                    } else if (numeroAfectados == 0) {
                        Mensaje.mostrarErrorDeCreacion();
                    }
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(e.getMessage());
            }

        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_moraPorDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_moraPorDiaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_moraPorDiaKeyTyped

    private void fiveCodButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_cancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private rojeru_san.componentes.RSDateChooser date_fin;
    private rojeru_san.componentes.RSDateChooser date_inicio;
    private rojeru_san.componentes.RSDateChooser date_pago;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodbutton.FiveCodButton fiveCodButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panelTitulo;
    private javax.swing.JPanel titulo;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_comision;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_mora;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_moraPorDia;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_subTotal;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_total;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_totalDiasAtrazados;
    // End of variables declaration//GEN-END:variables

//methods create for programers
    private boolean verificarCampos() {
        int contador = 0, aux = 0;

        contador = Verificador.verificadorCampos(txt_comision);
        aux = contador + aux;
        contador = Verificador.verificadorCamposFechas(date_fin);
        aux = contador + aux;
        return aux == 2;
    }

    private void llenarCampos1() {
        date_inicio.setDatoFecha(prestamo.getFechaInicio());
        date_fin.setDatoFecha(prestamo.getFechaFin());
        date_pago.setDatoFecha(new java.util.Date());

    }

    private void llenarCampos2() {
        txt_totalDiasAtrazados.setText(String.valueOf(prestamo.calcularTotalDiasAtrazados()));
        txt_estado.setText(prestamo.calcularEstado());
        txt_moraPorDia.setText(String.valueOf(prestamo.generarMontoMora()));

    }

    private void llenarCampos3() {
        txt_subTotal.setText(String.valueOf(prestamo.getMonto()));
        txt_comision.setText(String.valueOf(prestamo.calcularComision()));
        txt_mora.setText(String.valueOf(prestamo.calcularMora()));
        txt_total.setText(String.valueOf(prestamo.calcularTotal()));

    }

    private void inabilitarPaso1(boolean estado) {
        date_fin.setEnabled(false);
        date_inicio.setEnabled(false);
        txt_moraPorDia.setEnabled(estado);
    }

    private void inabilitarPaso2(boolean estado) {
        txt_totalDiasAtrazados.setEnabled(false);
        txt_estado.setEnabled(false);

    }

    private void inabilitarPaso4(boolean estado) {
        txt_subTotal.setEnabled(false);
        txt_comision.setEnabled(false);
        txt_total.setEnabled(false);
        txt_mora.setEnabled(false);
        btn_guardar.setEnabled(estado);
        btn_cancelar.setEnabled(estado);

    }

    private void llenarDatos2() {
        date_inicio.setDatoFecha(prestamo.getFechaInicio());
    }

    private void llenarDatosGenerales() {
        clienteSeleccionado = prestamo.getCliente();

        llenarCampos1();
        llenarCampos2();
        llenarCampos3();
        inabilitarPaso1(false);
        inabilitarPaso4(false);
        inabilitarPaso2(false);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);

    }

}
