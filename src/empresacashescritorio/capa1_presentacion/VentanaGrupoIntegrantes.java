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
            inabilitarCampos(false);
            inicializarTablaColumnas();
            llenarDatosTabla();

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
        jLabel1 = new javax.swing.JLabel();
        fiveCodButton1 = new fivecodbutton.FiveCodButton();
        jPanel3 = new javax.swing.JPanel();
        fiveCodLabelImage1 = new fivecodlabelimage.FiveCodLabelImage();
        txt_cliente = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_dni = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage6 = new fivecodlabelimage.FiveCodLabelImage();
        btn_buscar = new javax.swing.JButton();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
        txt_correoElectronico = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_celular = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage3 = new fivecodlabelimage.FiveCodLabelImage();
        btn_agregar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_clientes = new FiveCodTable.FiveCodJTable();
        jLabel2 = new javax.swing.JLabel();
        btn_guardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btn_Cancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        jButton1 = new javax.swing.JButton();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 606, Short.MAX_VALUE)
                .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fiveCodButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 3, 860, 33));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        org.jdesktop.swingx.border.DropShadowBorder dropShadowBorder1 = new org.jdesktop.swingx.border.DropShadowBorder();
        dropShadowBorder1.setShadowColor(new java.awt.Color(65, 94, 255));
        dropShadowBorder1.setShowLeftShadow(true);
        dropShadowBorder1.setShowTopShadow(true);
        jPanel3.setBorder(dropShadowBorder1);
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 50, 50));

        txt_cliente.setForeground(new java.awt.Color(65, 94, 255));
        txt_cliente.setAccent(new java.awt.Color(0, 132, 235));
        txt_cliente.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente.setLabel("CLIENTE");
        txt_cliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 200, 60));

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
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 120, 60));
        jPanel3.add(fiveCodLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 50, 50));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, 30));
        jPanel3.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 50, 50));

        txt_correoElectronico.setForeground(new java.awt.Color(65, 94, 255));
        txt_correoElectronico.setAccent(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_correoElectronico.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_correoElectronico.setLabel("CORREO ELECTROÓNICO");
        txt_correoElectronico.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_correoElectronico, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, 200, 60));

        txt_celular.setForeground(new java.awt.Color(65, 94, 255));
        txt_celular.setAccent(new java.awt.Color(0, 132, 235));
        txt_celular.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_celular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_celular.setLabel("CELULAR");
        txt_celular.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 200, 60));
        jPanel3.add(fiveCodLabelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, 50, 50));

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 41, 850, 190));

        jPanel4.setBackground(new java.awt.Color(65, 94, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla_clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabla_clientes.setGrosorBordeFilas(0);
        tabla_clientes.setGrosorBordeHead(0);
        tabla_clientes.setRowHeight(20);
        tabla_clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_clientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_clientes);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 830, 170));

        jLabel2.setText("Integrantes");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_guardar.setBackground(new java.awt.Color(255, 255, 255));
        btn_guardar.setBorder(null);
        btn_guardar.setText("Guardar");
        btn_guardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 130, 60));

        btn_Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setBorder(null);
        btn_Cancelar.setText("cancelar");
        btn_Cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btn_Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 130, 60));

        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 234, 850, 270));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(875, 503));
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

    private void tabla_clientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_clientesMousePressed
        filaSeleccionada = tabla_clientes.getSelectedRow();
    }//GEN-LAST:event_tabla_clientesMousePressed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        try {
            inabilitarCampos(false);
            String dni = txt_dni.getText().toString();
            clienteSeleccionado = registrarGrupoServicio.verificarDniCliente(dni);
            llenarDatos();
            inabilitarCampos(true);
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        try {
            boolean resultado = registrarGrupoServicio.verificarSiEstaEnGrupo(clienteSeleccionado);
            if (resultado) {
                if (grupo.agregarDetalleGrupo(clienteSeleccionado, grupo)) {
                    llenarDatosTabla();
                    limpiarDatos();
                } else {
                    Mensaje.mostrarAdvertencia("Error al agregar al grupo");
                }
            }
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed

        try {
            int registrosAfectados = 0;
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


    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        eliminarDetalle();
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        eliminarDetalle();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void llenarDatos() {
        txt_celular.setText(String.valueOf(clienteSeleccionado.getCelular()));
        txt_correoElectronico.setText(clienteSeleccionado.getCorreoElectronico());
        txt_cliente.setText(clienteSeleccionado.generaNombre());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_Cancelar;
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_buscar;
    private fivecodbutton.FiveCodButton btn_eliminar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private fivecodbutton.FiveCodButton btn_modificar;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage3;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage6;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPopupMenu popMenu;
    private FiveCodTable.FiveCodJTable tabla_clientes;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_celular;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_cliente;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_correoElectronico;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_dni;
    // End of variables declaration//GEN-END:variables

//methods create for programers
    private void eliminarDetalle() {
        if (filaSeleccionada != -1) {
            int codigo = (int) tabla_clientes.getValueAt(filaSeleccionada, 0);
            int indice = JOptionPane.showConfirmDialog(this, "Desea eliminar", "FiveCod: Pregunta", JOptionPane.YES_NO_OPTION);
            if (indice == 1) {
                return;
            }
            try {
                if (grupo.eliminarDetalleGrupo(codigo)) {
                    llenarDatosTabla();
                } else {
                    Mensaje.mostrarAdvertencia("Error al eliminar el cliente del grupo");
                }

            } catch (Exception e) {
                Mensaje.mostrarAdvertenciaDeEliminacion();
            }

        } else {
            Mensaje.mostrarFilaNoSeleccionada();
        }
    }

    private void inicializarTablaColumnas() {
        Tabla tabla = new Tabla();
        tabla.agregarColumna(new Columna("Codigo", "java.lang.Integer"));
        tabla.agregarColumna(new Columna("CLIENTE", "java.lang.String"));
        tabla.agregarColumna(new Columna("EMAIL", "java.lang.String"));
        tabla.agregarColumna(new Columna("DNI", "java.lang.String"));
        tabla.agregarColumna(new Columna("ESTADO", "java.lang.String"));

        ModeloTabla modeloTabla = new ModeloTabla(tabla);
        tabla_clientes.setModel(modeloTabla);
        tabla_clientes.getColumn(tabla_clientes.getColumnName(0)).setWidth(0);
        tabla_clientes.getColumn(tabla_clientes.getColumnName(0)).setMinWidth(0);
        tabla_clientes.getColumn(tabla_clientes.getColumnName(0)).setMaxWidth(0);
    }

    private void llenarDatosTabla() throws Exception {
        Fila filaTabla;
        try {
            ModeloTabla modeloTabla = (ModeloTabla) tabla_clientes.getModel();
            modeloTabla.eliminarTotalFilas();
            if (grupo.getListaDetalleGrupo().size() == 0) {
                Mensaje.mostrarAdvertenciaSinElementos();
            } else {
                for (DetalleGrupo detalleGrupo : grupo.getListaDetalleGrupo()) {
                    if (!detalleGrupo.getEstadoAccion().equals(DetalleGrupo.ESTADO_ELIMINAR)) {
                        filaTabla = new Fila();
                        filaTabla.agregarValorCelda(detalleGrupo.getId());
                        filaTabla.agregarValorCelda(detalleGrupo.getCliente().generaNombre());
                        filaTabla.agregarValorCelda(detalleGrupo.getCliente().getCorreoElectronico());
                        filaTabla.agregarValorCelda(detalleGrupo.getCliente().getDni());
                        filaTabla.agregarValorCelda(detalleGrupo.getCliente().getEstado());

                        modeloTabla.agregarFila(filaTabla);
                    }

                }
                modeloTabla.refrescarDatos();
            }

        } catch (Exception e) {
            Mensaje.mostrarErrorSistema();
        }

    }

    private void limpiarDatos() {
        txt_celular.setText("");
        txt_cliente.setText("");
        txt_correoElectronico.setText("");
        txt_dni.setText("");
        clienteSeleccionado = null;
        inabilitarCampos(false);

    }

    private boolean verificarCampos() {
        int contador = 0, aux = 0;

//        contador = Verificador.verificadorCampos(txt_nombre);
//        aux = contador + aux;
//        contador = Verificador.verificadorCampos(txt_apellidos);
//        aux = contador + aux;
//
//        contador = Verificador.verificadorCamposFechas(date_fechaNacimiento);
//        aux = contador + aux;
//        contador = Verificador.verificarCombobox(cbx_genero);
//        aux = contador + aux;
//        contador = Verificador.verificadorCampos(txt_dni);
//        aux = contador + aux;
//
//        contador = Verificador.verificadorCampos(txt_celular);
//        aux = contador + aux;
//
//        contador = Verificador.verificarCombobox(cbx_genero);
//        aux = contador + aux;
//        contador = Verificador.verificarCombobox(cbx_tipoCliente);
//        aux = contador + aux;
//        contador = Verificador.verificarCombobox(cbx_universidad);
//        aux = contador + aux;
        return aux == 9;
    }

    private void llenarCampos() {
//        if (cliente != null) {
//            this.txt_nombre.setText(cliente.getNombre());
//            this.txt_apellidos.setText(cliente.getApellidos());
//            this.txt_correoElectronico.setText(cliente.getCorreoElectronico());
//            this.txt_dni.setText(cliente.getDni());
//            this.date_fechaNacimiento.setDatoFecha(cliente.getFechaNacimiento());
//            this.cbx_genero.setSelectedItem(cliente.getGenero());
//            this.txt_celular.setText(String.valueOf(cliente.getCelular()));
//            this.txt_carrera.setText(cliente.getCarrera());
//            this.txt_estado.setText(cliente.getEstado());
//
//            this.codigoCliente = cliente.getId();
//
//            for (int i = 0; i < cbx_tipoCliente.getItemCount(); i++) {
//                if (cliente.getTipoCliente().getDescripcion().equals(cbx_tipoCliente.getItemAt(i).getDescripcion())) {
//                    cbx_tipoCliente.setSelectedIndex(i);
//                }
//            }
//            
//             for (int i = 0; i < cbx_universidad.getItemCount(); i++) {
//                if (cliente.getUniversidad().equals(cbx_universidad.getItemAt(i).toString())) {
//                    cbx_universidad.setSelectedIndex(i);
//                }
//            }
//        } else {
//            Mensaje.mostrarAdvertencia("Cliente no encontrado");
//        }

    }

    private void inabilitarCampos(boolean estado) {
        this.txt_cliente.setEnabled(false);
        this.txt_correoElectronico.setEnabled(false);
        this.txt_celular.setEnabled(false);
        this.btn_agregar.setEnabled(estado);
    }

}
