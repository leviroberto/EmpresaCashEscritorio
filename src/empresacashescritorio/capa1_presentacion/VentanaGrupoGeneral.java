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
import empresacashescritorio.capa3_dominio.TipoCliente;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Antonio Aburto Cortez
 */
public class VentanaGrupoGeneral extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private RegistrarGrupoServicio registrarGrupoServicio;
    
    public static final int ACCION_CREAR = 1;
    public static final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoCliente = 0;
    
    private Grupo grupoSeleccionado;
    
    public VentanaGrupoGeneral(java.awt.Frame parent, boolean modal, Grupo grupoSeleccionado) {
        super(parent, modal);
        initComponents();
        try {
            registrarGrupoServicio = new RegistrarGrupoServicio();
            this.grupoSeleccionado = grupoSeleccionado;
            this.lbl_datosGenerales.setText("DATOS DEL " + grupoSeleccionado.getNombre());
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_datosGenerales = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel3 = new javax.swing.JPanel();
        btn_datos = new javax.swing.JButton();
        btn_integrante = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

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

        lbl_datosGenerales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_datosGenerales.setForeground(new java.awt.Color(255, 255, 255));
        lbl_datosGenerales.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_datosGenerales.setText("DATOS DEL GRUPO");

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
                .addGap(81, 81, 81)
                .addComponent(lbl_datosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_datosGenerales, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 550, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_datos.setText("Datos");
        btn_datos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datosActionPerformed(evt);
            }
        });
        jPanel3.add(btn_datos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        btn_integrante.setText("Integrantes");
        btn_integrante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_integranteActionPerformed(evt);
            }
        });
        jPanel3.add(btn_integrante, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 530, 280));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 264, 550, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(552, 394));
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

    private void btn_datosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datosActionPerformed
        VentanaGrupoDatos d = new VentanaGrupoDatos(null, true, grupoSeleccionado);
        d.setVisible(true);
    }//GEN-LAST:event_btn_datosActionPerformed

    private void btn_integranteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_integranteActionPerformed
        try {
            VentanaGrupoIntegrantes d = new VentanaGrupoIntegrantes(null, true, grupoSeleccionado);
            d.setVisible(true);
            this.grupoSeleccionado = registrarGrupoServicio.buscar(grupoSeleccionado.getId());
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
        
    }//GEN-LAST:event_btn_integranteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_datos;
    private javax.swing.JButton btn_integrante;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_datosGenerales;
    // End of variables declaration//GEN-END:variables

//methods create for programers
}
