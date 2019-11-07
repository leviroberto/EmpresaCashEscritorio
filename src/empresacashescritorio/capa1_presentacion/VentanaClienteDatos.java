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
import empresacashescritorio.capa3_dominio.TipoCliente;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaClienteDatos extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private Cliente cliente;
    private GestionarClienteServicio gestionarClienteServicio;

    private final int ACCION_CREAR = 1;
    private final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoCliente = 0;

    public VentanaClienteDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            gestionarClienteServicio = new GestionarClienteServicio();
            tipo_accion = ACCION_CREAR;
            txt_estado.setText(Cliente.ESTADO_ACTIVO);
            inabilitarCampos(false);

            llenarCombTipoCliente();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    public VentanaClienteDatos(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        try {
            gestionarClienteServicio = new GestionarClienteServicio();
            tipo_accion = ACCION_MODIFICAR;
            this.cliente = cliente;
            llenarCombTipoCliente();
            llenarCampos();
            txt_dni.setEnabled(false);
            btn_buscar.setVisible(false);
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

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
        fiveCodLabelImage1 = new fivecodlabelimage.FiveCodLabelImage();
        txt_apellidos = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_nombre = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage3 = new fivecodlabelimage.FiveCodLabelImage();
        txt_dni = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage6 = new fivecodlabelimage.FiveCodLabelImage();
        btn_buscar = new javax.swing.JButton();
        fiveCodLabelImage10 = new fivecodlabelimage.FiveCodLabelImage();
        txt_correoElectronico = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        date_fechaNacimiento = new rojeru_san.componentes.RSDateChooser();
        fiveCodLabelImage5 = new fivecodlabelimage.FiveCodLabelImage();
        jPanel5 = new javax.swing.JPanel();
        txt_celular = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        lblFechaFin2 = new javax.swing.JLabel();
        fiveCodLabelImage8 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage9 = new fivecodlabelimage.FiveCodLabelImage();
        cbx_genero = new FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage4 = new fivecodlabelimage.FiveCodLabelImage();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage11 = new fivecodlabelimage.FiveCodLabelImage();
        txt_carrera = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage12 = new fivecodlabelimage.FiveCodLabelImage();
        cbx_tipoCliente = new FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox<>();
        cbx_universidad = new FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox();
        jPanel4 = new javax.swing.JPanel();
        btn_guardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btn_Cancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();

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
        jLabel1.setText("DATOS DEL EMPLEADO");

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
                .addGap(158, 158, 158)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 153, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 614, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 50));

        txt_apellidos.setForeground(new java.awt.Color(65, 94, 255));
        txt_apellidos.setAccent(new java.awt.Color(0, 132, 235));
        txt_apellidos.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_apellidos.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_apellidos.setLabel("APELLIDOS");
        txt_apellidos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 200, 60));

        txt_nombre.setForeground(new java.awt.Color(65, 94, 255));
        txt_nombre.setAccent(new java.awt.Color(0, 132, 235));
        txt_nombre.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setLabel("NOMBRE");
        txt_nombre.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 200, 60));
        jPanel3.add(fiveCodLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 50));

        txt_dni.setForeground(new java.awt.Color(65, 94, 255));
        txt_dni.setAccent(new java.awt.Color(0, 132, 235));
        txt_dni.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_dni.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_dni.setLabel("DNI");
        txt_dni.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_dni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_dniKeyTyped(evt);
            }
        });
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 130, 60));
        jPanel3.add(fiveCodLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 23, 70, 40));
        jPanel3.add(fiveCodLabelImage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 50, 50));

        txt_correoElectronico.setForeground(new java.awt.Color(65, 94, 255));
        txt_correoElectronico.setAccent(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_correoElectronico.setLabel("CORREO ELECTRÓNICO");
        txt_correoElectronico.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_correoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 200, 60));

        date_fechaNacimiento.setColorBackground(new java.awt.Color(64, 95, 255));
        date_fechaNacimiento.setColorButtonHover(new java.awt.Color(64, 95, 255));
        date_fechaNacimiento.setColorForeground(new java.awt.Color(64, 95, 255));
        date_fechaNacimiento.setPlaceholder("FECHA DE NACIMIENTO");
        date_fechaNacimiento.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.add(date_fechaNacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 200, 35));
        jPanel3.add(fiveCodLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 50, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 290, 370));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder2 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder2.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder2.setShowLeftShadow(true);
        dropShadowBorder2.setShowTopShadow(true);
        jPanel5.setBorder(dropShadowBorder2);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_celular.setForeground(new java.awt.Color(65, 94, 255));
        txt_celular.setAccent(new java.awt.Color(0, 132, 235));
        txt_celular.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_celular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_celular.setLabel("CELULAR");
        txt_celular.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_celularActionPerformed(evt);
            }
        });
        txt_celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_celularKeyTyped(evt);
            }
        });
        jPanel5.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 190, 60));
        jPanel5.add(lblFechaFin2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 190, 10));
        jPanel5.add(fiveCodLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 50));
        jPanel5.add(fiveCodLabelImage9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 50, 50));

        cbx_genero.setBackground(new java.awt.Color(255, 255, 255));
        cbx_genero.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(65, 94, 255)));
        cbx_genero.setForeground(new java.awt.Color(65, 94, 255));
        cbx_genero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "GENERO", "MASCULINO", "FEMENINO", "PREFIERO NO DECIRLO" }));
        cbx_genero.setToolTipText("ESTADO CIVIL");
        cbx_genero.setAccent(new java.awt.Color(65, 94, 255));
        cbx_genero.setHint("CARGO");
        jPanel5.add(cbx_genero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 190, 40));
        jPanel5.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 50, 50));
        jPanel5.add(fiveCodLabelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 50, 50));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        txt_estado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel5.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 190, 60));
        jPanel5.add(fiveCodLabelImage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 50, 50));

        txt_carrera.setForeground(new java.awt.Color(65, 94, 255));
        txt_carrera.setAccent(new java.awt.Color(0, 132, 235));
        txt_carrera.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_carrera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_carrera.setLabel("CARRERA");
        txt_carrera.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel5.add(txt_carrera, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 190, 60));
        jPanel5.add(fiveCodLabelImage12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 50, 50));

        cbx_tipoCliente.setBackground(new java.awt.Color(255, 255, 255));
        cbx_tipoCliente.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(65, 94, 255)));
        cbx_tipoCliente.setForeground(new java.awt.Color(65, 94, 255));
        cbx_tipoCliente.setToolTipText("ESTADO CIVIL");
        cbx_tipoCliente.setAccent(new java.awt.Color(65, 94, 255));
        cbx_tipoCliente.setHint("CARGO");
        jPanel5.add(cbx_tipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 190, 50));

        cbx_universidad.setBackground(new java.awt.Color(255, 255, 255));
        cbx_universidad.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(65, 94, 255)));
        cbx_universidad.setForeground(new java.awt.Color(65, 94, 255));
        cbx_universidad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "UNIVERSIDAD", "UCV", "UPAO", "UPN", "UNT", "UPT", "UPD", "ULADECH", "CIBERTEC", "OTROS" }));
        cbx_universidad.setToolTipText("UNIVERSIDAD");
        cbx_universidad.setAccent(new java.awt.Color(65, 94, 255));
        cbx_universidad.setHint("CARGO");
        jPanel5.add(cbx_universidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 190, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 290, 360));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setBorder(null);
        btn_guardar.setText("Guardar");
        btn_guardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 130, 60));

        btn_Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setBorder(null);
        btn_Cancelar.setText("cancelar");
        btn_Cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 304, 614, 175));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(617, 482));
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

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (verificarCampos()) {
            cliente = new Cliente();
            cliente.setNombre(txt_nombre.getText().toString());
            cliente.setApellidos(txt_apellidos.getText().toString());
            cliente.setCorreoElectronico(txt_correoElectronico.getText().toString());
            cliente.setDni(txt_dni.getText().toString());

            Date fechaNacimiento = date_fechaNacimiento.getDatoFecha();
            cliente.setFechaNacimiento(new java.sql.Date(fechaNacimiento.getTime()));

            cliente.setGenero(cbx_genero.getSelectedItem().toString());
            cliente.setCelular(Integer.parseInt(txt_celular.getText().toString()));
            cliente.setUniversidad(cbx_universidad.getSelectedItem().toString());

            cliente.setCarrera(txt_carrera.getText().toString());
            cliente.setEstado(txt_estado.getText().toString());

            cliente.setTipoCliente(cbx_tipoCliente.getItemAt(cbx_tipoCliente.getSelectedIndex()));

            int registrosAfectados = 0;
            if (tipo_accion == ACCION_CREAR) {
                try {
                    registrosAfectados = gestionarClienteServicio.guardar(cliente);
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
                cliente.setId(this.codigoCliente);
                try {
                    registrosAfectados = gestionarClienteServicio.modificar(cliente);
                    if (registrosAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeActualizacion();
                        this.dispose();
                    } else if (registrosAfectados == 0) {
                        Mensaje.mostrarErrorDeActualizacion();
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(e.getMessage());

                }
            }

        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_celularActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            int contador = Verificador.verificarDNI(txt_dni);
            if (contador == 1) {
                int verificar = gestionarClienteServicio.buscarDni(txt_dni.getText().toString());
                if (verificar == 1) {
                    txt_nombre.requestFocus();
                    inabilitarCampos(true);
                } else {
                    inabilitarCampos(false);
                }
            }
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_celularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_celularKeyTyped
        Verificador.verificarNumeros(evt, txt_celular, 9);
    }//GEN-LAST:event_txt_celularKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        Verificador.verificarNumeros(evt, txt_dni, 8);
    }//GEN-LAST:event_txt_dniKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_Cancelar;
    private javax.swing.JButton btn_buscar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox cbx_genero;
    private FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox<TipoCliente> cbx_tipoCliente;
    private FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox cbx_universidad;
    private rojeru_san.componentes.RSDateChooser date_fechaNacimiento;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage10;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage11;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage12;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage3;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage4;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage5;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage6;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage8;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblFechaFin2;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_apellidos;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_carrera;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_celular;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_correoElectronico;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_dni;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

//methods create for programers
    private boolean verificarCampos() {
        int contador = 0, aux = 0;

        contador = Verificador.verificadorCampos(txt_nombre);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_apellidos);
        aux = contador + aux;

        contador = Verificador.verificadorCamposFechas(date_fechaNacimiento);
        aux = contador + aux;
        contador = Verificador.verificarCombobox(cbx_genero);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_dni);
        aux = contador + aux;

        contador = Verificador.verificadorCampos(txt_celular);
        aux = contador + aux;

        contador = Verificador.verificarCombobox(cbx_genero);
        aux = contador + aux;
        contador = Verificador.verificarCombobox(cbx_tipoCliente);
        aux = contador + aux;
        contador = Verificador.verificarCombobox(cbx_universidad);
        aux = contador + aux;
        return aux == 9;
    }

    private void llenarCampos() {
        if (cliente != null) {
            this.txt_nombre.setText(cliente.getNombre());
            this.txt_apellidos.setText(cliente.getApellidos());
            this.txt_correoElectronico.setText(cliente.getCorreoElectronico());
            this.txt_dni.setText(cliente.getDni());
            this.date_fechaNacimiento.setDatoFecha(cliente.getFechaNacimiento());
            this.cbx_genero.setSelectedItem(cliente.getGenero());
            this.txt_celular.setText(String.valueOf(cliente.getCelular()));
            this.txt_carrera.setText(cliente.getCarrera());
            this.txt_estado.setText(cliente.getEstado());

            this.codigoCliente = cliente.getId();

            for (int i = 0; i < cbx_tipoCliente.getItemCount(); i++) {
                if (cliente.getTipoCliente().getDescripcion().equals(cbx_tipoCliente.getItemAt(i).getDescripcion())) {
                    cbx_tipoCliente.setSelectedIndex(i);
                }
            }
            
             for (int i = 0; i < cbx_universidad.getItemCount(); i++) {
                if (cliente.getUniversidad().equals(cbx_universidad.getItemAt(i).toString())) {
                    cbx_universidad.setSelectedIndex(i);
                }
            }
        } else {
            Mensaje.mostrarAdvertencia("Cliente no encontrado");
        }

    }

    private void inabilitarCampos(boolean estado) {
        this.txt_nombre.setEnabled(estado);
        this.txt_apellidos.setEnabled(estado);
        this.txt_correoElectronico.setEnabled(estado);
        this.date_fechaNacimiento.setEnabled(estado);
        this.cbx_genero.setEnabled(estado);
        this.txt_celular.setEnabled(estado);
        this.cbx_universidad.setEnabled(estado);
        this.txt_carrera.setEnabled(estado);
        this.txt_estado.setEnabled(false);
        this.btn_guardar.setEnabled(estado);
        this.cbx_tipoCliente.setEnabled(estado);

    }

    private void llenarCombTipoCliente() throws Exception {

        List<TipoCliente> listaTipoCliente = gestionarClienteServicio.mostrarTipoCliente();

        cbx_tipoCliente.removeAll();
        cbx_tipoCliente.addItem(Verificador.obtenerTipoClienteDefacto());
        for (TipoCliente tipoCliente : listaTipoCliente) {
            cbx_tipoCliente.addItem(tipoCliente);
        }
    }
}
