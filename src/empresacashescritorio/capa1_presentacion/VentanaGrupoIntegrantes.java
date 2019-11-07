/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import empresacashescritorio.capa1_presentacion.util.Verificador;
import empresacashescritorio.capa2_aplicacion.GestionarClienteServicio;
import empresacashescritorio.capa2_aplicacion.GestionarDetalleGrupoServicio;
import empresacashescritorio.capa2_aplicacion.RegistrarGrupoServicio;
import empresacashescritorio.capa3_dominio.Cliente;
import empresacashescritorio.capa3_dominio.DetalleGrupo;
import empresacashescritorio.capa3_dominio.Grupo;
import empresacashescritorio.capa3_dominio.TipoCliente;
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
public class VentanaGrupoIntegrantes extends javax.swing.JDialog {

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

    public VentanaGrupoIntegrantes(java.awt.Frame parent, boolean modal, Grupo grupo) {
        super(parent, modal);
        try {

            initComponents();
            popMenu.add(pnlMenu);
            registrarGrupoServicio = new RegistrarGrupoServicio();
            tipo_accion = ACCION_CREAR;
            this.grupo = grupo;
            lbl_NombreGrupo.setText("DATOS DEL " + grupo.getNombre());
            inabilitarCampos(false);
            inabilitarBotones(false);
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_NombreGrupo = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel3 = new javax.swing.JPanel();
        txt_cliente = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_dni = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_correoElectronico = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_celular = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        btn_buscar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        jPanel4 = new javax.swing.JPanel();
        btn_guardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btn_Cancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(65, 94, 255)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(65, 94, 255));

        lbl_NombreGrupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_NombreGrupo.setForeground(new java.awt.Color(255, 255, 255));
        lbl_NombreGrupo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_NombreGrupo.setText("DATOS DEL GRUPO");

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
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(lbl_NombreGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_NombreGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 300, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_cliente.setForeground(new java.awt.Color(65, 94, 255));
        txt_cliente.setAccent(new java.awt.Color(0, 132, 235));
        txt_cliente.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente.setLabel("CLIENTE");
        txt_cliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 230, 60));

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
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 150, 60));

        txt_correoElectronico.setForeground(new java.awt.Color(65, 94, 255));
        txt_correoElectronico.setAccent(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_correoElectronico.setLabel("CORREO ELECTROÓNICO");
        txt_correoElectronico.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_correoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 230, 60));

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
        jPanel3.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 230, 60));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        txt_estado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 230, 60));

        btn_buscar.setBackground(new java.awt.Color(65, 94, 255));
        btn_buscar.setBorder(null);
        btn_buscar.setText("BUSCAR");
        btn_buscar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 110, 60));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 270, 280));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setBorder(null);
        btn_guardar.setText("AGREGAR");
        btn_guardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 130, 60));

        btn_Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setBorder(null);
        btn_Cancelar.setText("cancelar");
        btn_Cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 130, 60));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 300, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(300, 410));
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

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        Verificador.verificarNumeros(evt, txt_dni, 8);
    }//GEN-LAST:event_txt_dniKeyTyped


    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        try {
            if (verificarCampos()) {
                registrarGrupoServicio.verificarSiEstaEnGrupo(clienteSeleccionado);
                if (grupo.agregarDetalleGrupo(clienteSeleccionado, grupo)) {

                    int numerosAfectados = registrarGrupoServicio.modificar(grupo);
                    if (numerosAfectados == 1) {
                        Mensaje.mostrarAdvertenciaDeCreacion();
                        this.dispose();
                    } else {
                        Mensaje.mostrarErrorDeCreacion();
                    }
                } else {
                    Mensaje.mostrarAdvertencia("El cliente ya se encuntra agregado al grupo");
                }
            }

        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());

        }


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed

    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            String dni = txt_dni.getText();
            clienteSeleccionado = registrarGrupoServicio.verificarDniCliente(dni);
            llenarDatosCliente();
            inabilitarBotones(true);
        } catch (Exception e) {
            inabilitarBotones(false);
            Mensaje.mostrarAdvertencia(e.getMessage());
            limpiarCampos();
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void txt_celularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_celularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_celularActionPerformed

    private void llenarDatos() {
        txt_celular.setText(String.valueOf(clienteSeleccionado.getCelular()));
        txt_correoElectronico.setText(clienteSeleccionado.getCorreoElectronico());
        txt_cliente.setText(clienteSeleccionado.generaNombre());
    }

    private boolean verificarCampos() {

        int contador = 0, aux = 0;

        contador = Verificador.verificadorCampos(txt_celular);
        aux = contador + aux;
        contador = Verificador.verificadorCampos(txt_cliente);
        aux = contador + aux;

        return aux == 2;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_Cancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_buscar;
    private fivecodbutton.FiveCodButton btn_eliminar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private fivecodbutton.FiveCodButton btn_modificar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lbl_NombreGrupo;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPopupMenu popMenu;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_celular;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_cliente;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_correoElectronico;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_dni;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    // End of variables declaration//GEN-END:variables

    private void inabilitarCampos(boolean estado) {
        txt_celular.setEnabled(estado);
        txt_cliente.setEnabled(estado);
        txt_correoElectronico.setEnabled(estado);
        txt_estado.setEnabled(estado);
    }

    private void llenarDatosCliente() {
        txt_celular.setText(String.valueOf(clienteSeleccionado.getCelular()));
        txt_cliente.setText(String.valueOf(clienteSeleccionado.generaNombre()));
        txt_correoElectronico.setText(String.valueOf(clienteSeleccionado.getCorreoElectronico()));
        txt_estado.setText(String.valueOf(clienteSeleccionado.getEstado()));

    }

    private void inabilitarBotones(boolean estado) {
        btn_guardar.setEnabled(estado);
        btn_Cancelar.setEnabled(true);
    }

    private void limpiarCampos() {
        Verificador.limpiarTexto(txt_celular);
        Verificador.limpiarTexto(txt_cliente);
        Verificador.limpiarTexto(txt_correoElectronico);
        Verificador.limpiarTexto(txt_estado);
  
    }

}
