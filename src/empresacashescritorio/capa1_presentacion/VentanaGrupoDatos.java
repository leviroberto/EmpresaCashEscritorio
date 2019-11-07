/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import static empresacashescritorio.capa1_presentacion.FormMenuPrincipal.alturaPantalla;
import static empresacashescritorio.capa1_presentacion.FormMenuPrincipal.anchoPantalla;
import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.RegistrarGrupoServicio;
import empresacashescritorio.capa3_dominio.Grupo;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaGrupoDatos extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private Grupo grupo;
    private RegistrarGrupoServicio registrarGrupoServicio;

    public static final int ACCION_CREAR = 1;
    public static final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoGrupo = 0;

    public VentanaGrupoDatos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            registrarGrupoServicio = new RegistrarGrupoServicio();
            tipo_accion = ACCION_CREAR;
            Grupo axiliar = registrarGrupoServicio.obtenerUltimoRegistro();
            this.grupo = new Grupo();
            this.grupo.setNombre("GRUPO N° " + (axiliar.getId() + 1));
            this.grupo.setDescripcion("PARA PRESTAMOS");
            llenarCombTipoGrupo();
            llenarCampos();
            inabilitarCampos(false);

        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    public VentanaGrupoDatos(java.awt.Frame parent, boolean modal, Grupo grupo) {
        super(parent, modal);
        initComponents();
        try {
            registrarGrupoServicio = new RegistrarGrupoServicio();
            tipo_accion = ACCION_MODIFICAR;
            this.grupo = grupo;
            llenarCombTipoGrupo();
            llenarCampos();
            inabilitarCampos(true);

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
        txt_descripcion = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage3 = new fivecodlabelimage.FiveCodLabelImage();
        txt_nombre = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage6 = new fivecodlabelimage.FiveCodLabelImage();
        date_fechaCreacion = new rojeru_san.componentes.RSDateChooser();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 290, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 50));

        txt_descripcion.setForeground(new java.awt.Color(65, 94, 255));
        txt_descripcion.setAccent(new java.awt.Color(0, 132, 235));
        txt_descripcion.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_descripcion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_descripcion.setLabel("DESCRPCIÓN");
        txt_descripcion.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 200, 60));
        jPanel3.add(fiveCodLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 50, 50));

        txt_nombre.setForeground(new java.awt.Color(65, 94, 255));
        txt_nombre.setAccent(new java.awt.Color(0, 132, 235));
        txt_nombre.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_nombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_nombre.setLabel("NOMBRE");
        txt_nombre.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel3.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 60));
        jPanel3.add(fiveCodLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        date_fechaCreacion.setColorBackground(new java.awt.Color(64, 95, 255));
        date_fechaCreacion.setColorButtonHover(new java.awt.Color(64, 95, 255));
        date_fechaCreacion.setColorForeground(new java.awt.Color(64, 95, 255));
        date_fechaCreacion.setPlaceholder("FECHA CREACIÓN");
        date_fechaCreacion.setPreferredSize(new java.awt.Dimension(200, 40));
        jPanel3.add(date_fechaCreacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 200, 35));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        txt_estado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 200, 60));
        jPanel3.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 50, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 290, 280));

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
        jPanel4.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 60));

        btn_Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setBorder(null);
        btn_Cancelar.setText("cancelar");
        btn_Cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 264, 300, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(309, 394));
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
            grupo = new Grupo();
            grupo.setDescripcion(txt_descripcion.getText().toString());
            grupo.setEstado(txt_estado.getText().toString());
            grupo.setNombre(txt_nombre.getText().toString());

            Date fechaNacimiento = date_fechaCreacion.getDatoFecha();
            grupo.setFechaCreacion(new java.sql.Date(fechaNacimiento.getTime()));
            int registrosAfectados = 0;
            if (tipo_accion == ACCION_CREAR) {
                try {
                    registrosAfectados = registrarGrupoServicio.guardar(grupo);
                    if (registrosAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion();
                        Grupo grupo = registrarGrupoServicio.obtenerUltimoRegistro();
                        this.dispose();
                        VentanaGrupoGeneral ventanaGrupoGeneral = new VentanaGrupoGeneral(null, true, grupo);
                        ventanaGrupoGeneral.setBounds(0, 30, anchoPantalla, alturaPantalla - 70);
                        ventanaGrupoGeneral.setVisible(true);

                    } else if (registrosAfectados == 0) {
                        Mensaje.mostrarErrorDeCreacion();
                    }
                } catch (Exception e) {
                    Mensaje.mostrarAdvertencia(e.getMessage());
                }

            } else if (tipo_accion == ACCION_MODIFICAR) {
                grupo.setId(this.codigoGrupo);
                try {
                    registrosAfectados = registrarGrupoServicio.modificar(grupo);
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

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped

    }//GEN-LAST:event_txt_nombreKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_Cancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private rojeru_san.componentes.RSDateChooser date_fechaCreacion;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage3;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_descripcion;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

//methods create for programers
    private boolean verificarCampos() {
        int contador = 0, aux = 0;

        contador = Verificador.verificadorCampos(txt_nombre);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_descripcion);
        aux = contador + aux;

        return aux == 2;
    }

    private void llenarCampos() {
        txt_descripcion.setText(grupo.getDescripcion());
        txt_estado.setText(grupo.getEstado());
        txt_nombre.setText(grupo.getNombre());
        date_fechaCreacion.setDatoFecha(grupo.getFechaCreacion());
        codigoGrupo = grupo.getId();

    }

    private void inabilitarCampos(boolean estado) {
        this.txt_estado.setEnabled(estado);
        this.date_fechaCreacion.setEnabled(estado);
        this.txt_nombre.setEnabled(estado);
        this.txt_descripcion.setEnabled(estado);
    }

    private void llenarCombTipoGrupo() throws Exception {

//        List<TipoGrupo> listaTipoGrupo = gestionarGrupoServicio.mostrarTipoGrupo();
//
//        cbx_tipoGrupo.removeAll();
//        cbx_tipoGrupo.addItem(Verificador.obtenerTipoGrupoDefacto());
//        for (TipoGrupo tipoGrupo : listaTipoGrupo) {
//            cbx_tipoGrupo.addItem(tipoGrupo);
//        }
    }
}
