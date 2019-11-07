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
public class VentanaPrestamoCrear extends javax.swing.JDialog {

    /**
     * Creates new form VentanaDatosAFP
     */
    private Prestamo prestamo;
    private RegistrarPrestamoServicio registrarPrestamoServicio;
    private Cliente clienteSeleccionado = null;
    public static final int ACCION_CREAR = 1;
    public static final int ACCION_MODIFICAR = 2;
    private int tipo_accion;
    private int codigoPrestamo = 0;
    List<Prestamo> listaPrestamo;

    public VentanaPrestamoCrear(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        try {
            registrarPrestamoServicio = new RegistrarPrestamoServicio();
            tipo_accion = ACCION_CREAR;
            prestamo = new Prestamo();
            inabilitarPaso1(false);
            inabilitarPaso2(false);
            inabilitarPaso3(false);
            inabilitarPaso4(false);

        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }

    public VentanaPrestamoCrear(java.awt.Frame parent, boolean modal, Prestamo prestamo) {
        super(parent, modal);
        initComponents();
        try {
            registrarPrestamoServicio = new RegistrarPrestamoServicio();
            tipo_accion = ACCION_MODIFICAR;
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
        fiveCodLabelImage1 = new fivecodlabelimage.FiveCodLabelImage();
        txt_celular = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_email = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage6 = new fivecodlabelimage.FiveCodLabelImage();
        txt_estado = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage2 = new fivecodlabelimage.FiveCodLabelImage();
        txt_cliente = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage7 = new fivecodlabelimage.FiveCodLabelImage();
        txt_dni = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage8 = new fivecodlabelimage.FiveCodLabelImage();
        btn_buscar = new javax.swing.JButton();
        btn_cancelar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fiveCodLabelImage10 = new fivecodlabelimage.FiveCodLabelImage();
        txt_monto = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_de = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        txt_hasta = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fiveCodLabelImage5 = new fivecodlabelimage.FiveCodLabelImage();
        fiveCodLabelImage11 = new fivecodlabelimage.FiveCodLabelImage();
        btn_verificarSiTienPrestamoActivo = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        jLabel8 = new javax.swing.JLabel();
        fiveCodLabelImage12 = new fivecodlabelimage.FiveCodLabelImage();
        txt_subTotal = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage13 = new fivecodlabelimage.FiveCodLabelImage();
        txt_comision = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage14 = new fivecodlabelimage.FiveCodLabelImage();
        txt_total = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        jLabel9 = new javax.swing.JLabel();
        fiveCodLabelImage15 = new fivecodlabelimage.FiveCodLabelImage();
        txt_mora = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        btn_guardar = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        btn_calcularResumen = new FiveCodMaterialDesignButton.FiveCodMaterialButton();
        txt_puntosAcumulados = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage16 = new fivecodlabelimage.FiveCodLabelImage();
        date_fin = new com.toedter.calendar.JDateChooser();
        txt_totalDiasPagar = new FiveCodMaterialDesignTextField.FiveCodMaterialTextField();
        fiveCodLabelImage17 = new fivecodlabelimage.FiveCodLabelImage();
        date_inicio = new com.toedter.calendar.JDateChooser();
        fiveCodButton2 = new fivecodbutton.FiveCodButton();

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
        jPanel3.add(fiveCodLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 50, 50));

        txt_celular.setForeground(new java.awt.Color(65, 94, 255));
        txt_celular.setAccent(new java.awt.Color(0, 132, 235));
        txt_celular.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_celular.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_celular.setLabel("CELULAR");
        txt_celular.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 200, 60));

        txt_email.setForeground(new java.awt.Color(65, 94, 255));
        txt_email.setAccent(new java.awt.Color(0, 132, 235));
        txt_email.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_email.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_email.setLabel("CORREO ELECTRÓNICO");
        txt_email.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_emailKeyTyped(evt);
            }
        });
        jPanel3.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 200, 60));
        jPanel3.add(fiveCodLabelImage6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 50, 50));

        txt_estado.setForeground(new java.awt.Color(65, 94, 255));
        txt_estado.setAccent(new java.awt.Color(0, 132, 235));
        txt_estado.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_estado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_estado.setLabel("ESTADO");
        txt_estado.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jPanel3.add(txt_estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 200, 60));
        jPanel3.add(fiveCodLabelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 50, 50));

        txt_cliente.setForeground(new java.awt.Color(65, 94, 255));
        txt_cliente.setAccent(new java.awt.Color(0, 132, 235));
        txt_cliente.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_cliente.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_cliente.setLabel("CLIENTE");
        txt_cliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_cliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_clienteKeyTyped(evt);
            }
        });
        jPanel3.add(txt_cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 200, 60));
        jPanel3.add(fiveCodLabelImage7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 50, 50));

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
        jPanel3.add(txt_dni, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 120, 60));
        jPanel3.add(fiveCodLabelImage8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 50));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 33, -1, 40));

        btn_cancelar.setBackground(new java.awt.Color(65, 94, 255));
        btn_cancelar.setBorder(null);
        btn_cancelar.setText("cancelar");
        btn_cancelar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, 130, 60));

        jLabel2.setText("Datos Personales");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setText("Verificar si tiene prestamo");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, -1));
        jPanel3.add(fiveCodLabelImage10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 50, 50));

        txt_monto.setForeground(new java.awt.Color(65, 94, 255));
        txt_monto.setAccent(new java.awt.Color(0, 132, 235));
        txt_monto.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_monto.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_monto.setLabel("MONTO S/.");
        txt_monto.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_monto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_montoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_montoKeyTyped(evt);
            }
        });
        jPanel3.add(txt_monto, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 200, 60));

        txt_de.setForeground(new java.awt.Color(65, 94, 255));
        txt_de.setAccent(new java.awt.Color(0, 132, 235));
        txt_de.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_de.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_de.setLabel("DE S/.");
        txt_de.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_de.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_deKeyTyped(evt);
            }
        });
        jPanel3.add(txt_de, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 80, 60));

        txt_hasta.setForeground(new java.awt.Color(65, 94, 255));
        txt_hasta.setAccent(new java.awt.Color(0, 132, 235));
        txt_hasta.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_hasta.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_hasta.setLabel("HASTA S/");
        txt_hasta.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_hasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_hastaKeyTyped(evt);
            }
        });
        jPanel3.add(txt_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 80, 60));

        jLabel6.setText("A");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 20, -1));

        jLabel7.setText("Montos disponibles");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, 20));

        jLabel5.setText("Mora");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 240, -1, 20));
        jPanel3.add(fiveCodLabelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 50, 50));
        jPanel3.add(fiveCodLabelImage11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, 50, 50));

        btn_verificarSiTienPrestamoActivo.setBackground(new java.awt.Color(65, 94, 255));
        btn_verificarSiTienPrestamoActivo.setBorder(null);
        btn_verificarSiTienPrestamoActivo.setText("VERIFICAR");
        btn_verificarSiTienPrestamoActivo.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_verificarSiTienPrestamoActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verificarSiTienPrestamoActivoActionPerformed(evt);
            }
        });
        jPanel3.add(btn_verificarSiTienPrestamoActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 130, 60));

        jLabel8.setText("Solicitud");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 20));
        jPanel3.add(fiveCodLabelImage12, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 50, 50));

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
        jPanel3.add(txt_subTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 200, 60));
        jPanel3.add(fiveCodLabelImage13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 50, 50));

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
        jPanel3.add(txt_comision, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 110, 200, 60));
        jPanel3.add(fiveCodLabelImage14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 50, 50));

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
        jPanel3.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 170, 200, 60));

        jLabel9.setText("Resumen del pedido");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, -1, 20));
        jPanel3.add(fiveCodLabelImage15, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 50, 50));

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
        jPanel3.add(txt_mora, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 270, 200, 60));

        btn_guardar.setBackground(new java.awt.Color(65, 94, 255));
        btn_guardar.setBorder(null);
        btn_guardar.setText("guardar");
        btn_guardar.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 350, 130, 60));

        btn_calcularResumen.setBackground(new java.awt.Color(65, 94, 255));
        btn_calcularResumen.setBorder(null);
        btn_calcularResumen.setText("calcular");
        btn_calcularResumen.setType(FiveCodMaterialDesignButton.FiveCodMaterialButton.Type.RAISED);
        btn_calcularResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calcularResumenActionPerformed(evt);
            }
        });
        jPanel3.add(btn_calcularResumen, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 130, 60));

        txt_puntosAcumulados.setForeground(new java.awt.Color(65, 94, 255));
        txt_puntosAcumulados.setAccent(new java.awt.Color(0, 132, 235));
        txt_puntosAcumulados.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_puntosAcumulados.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_puntosAcumulados.setLabel("PUNTOS ACUMULADOS");
        txt_puntosAcumulados.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_puntosAcumulados.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_puntosAcumuladosKeyTyped(evt);
            }
        });
        jPanel3.add(txt_puntosAcumulados, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 200, 60));
        jPanel3.add(fiveCodLabelImage16, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 50, 50));

        date_fin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date_finMouseClicked(evt);
            }
        });
        jPanel3.add(date_fin, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 200, 30));

        txt_totalDiasPagar.setForeground(new java.awt.Color(65, 94, 255));
        txt_totalDiasPagar.setAccent(new java.awt.Color(0, 132, 235));
        txt_totalDiasPagar.setCaretColor(new java.awt.Color(0, 132, 235));
        txt_totalDiasPagar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_totalDiasPagar.setLabel("TOTAL DIAS PAGAR");
        txt_totalDiasPagar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        txt_totalDiasPagar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalDiasPagarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_totalDiasPagarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_totalDiasPagarKeyTyped(evt);
            }
        });
        jPanel3.add(txt_totalDiasPagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 200, 60));
        jPanel3.add(fiveCodLabelImage17, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 50, 50));

        date_inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                date_inicioMouseClicked(evt);
            }
        });
        jPanel3.add(date_inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 200, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 1, 950, 520));

        fiveCodButton2.setBackground(new java.awt.Color(65, 94, 255));
        fiveCodButton2.setBorder(null);
        fiveCodButton2.setColorHover(new java.awt.Color(255, 68, 68));
        fiveCodButton2.setFont(new java.awt.Font("Roboto Bold", 1, 20)); // NOI18N
        fiveCodButton2.setLabel("X");
        fiveCodButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fiveCodButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(fiveCodButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 40, -1));

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

        setSize(new java.awt.Dimension(973, 532));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        FiveCodMover.FiveCodMoverJDialog.MousePressed(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        FiveCodMover.FiveCodMoverJDialog.MouseDraggedJDialog(evt, this);      // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

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

    private void fiveCodButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton1ActionPerformed

    private void txt_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyTyped

    }//GEN-LAST:event_txt_emailKeyTyped

    private void txt_clienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_clienteKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteKeyTyped

    private void txt_dniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_dniKeyTyped
        Verificador.verificarNumeros(evt, txt_dni, 8);
    }//GEN-LAST:event_txt_dniKeyTyped

    private void txt_montoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyTyped
        Verificador.verificarNumerosDecimales(evt, txt_monto, 5);
    }//GEN-LAST:event_txt_montoKeyTyped

    private void txt_deKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_deKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_deKeyTyped

    private void txt_hastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hastaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hastaKeyTyped

    private void btn_verificarSiTienPrestamoActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verificarSiTienPrestamoActivoActionPerformed
        try {
            registrarPrestamoServicio.verificarSiTienePrestamoActivo(clienteSeleccionado);
            calcular1();
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }


    }//GEN-LAST:event_btn_verificarSiTienPrestamoActivoActionPerformed

    private void calcular1() {
        try {

            prestamo.setListaPrestamo(registrarPrestamoServicio.buscarPrestamoRangoFecha(prestamo));
            inabilitarPaso3(true);
            txt_de.setText(String.valueOf(prestamo.obtenerMontoDe()));
            txt_hasta.setText(String.valueOf(prestamo.obtenerMontoHasta()));
            txt_puntosAcumulados.setText(String.valueOf(prestamo.calcularPuntosAcumulados()));
            txt_monto.requestFocus();
            llenarDatos2();
        } catch (Exception e) {
            inabilitarPaso3(false);
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
    }

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            String dni = txt_dni.getText();
            clienteSeleccionado = registrarPrestamoServicio.verificarDniCliente(dni);
            llenarCampos1();
            inabilitarPaso2(true);
        } catch (Exception e) {
            Mensaje.mostrarAdvertencia(e.getMessage());
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

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

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        if (verificarCampos()) {
            prestamo.setCliente(clienteSeleccionado);
            prestamo.setEstado(Prestamo.ESTADO_ACTIVO);
            Date fechaInicio = date_inicio.getDate();
            prestamo.setFechaInicio(new java.sql.Date(fechaInicio.getTime()));
            Date fechaFin = date_fin.getDate();
            prestamo.setFechaFin(new java.sql.Date(fechaFin.getTime()));
            prestamo.setMonto(Double.parseDouble(txt_monto.getText()));

            int numeroAfectados = 0;
            try {
                if (tipo_accion == ACCION_CREAR) {
                    numeroAfectados = registrarPrestamoServicio.guardar(prestamo);
                    if (numeroAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeCreacion();
                        this.dispose();
                    } else if (numeroAfectados == 0) {
                        Mensaje.mostrarErrorDeCreacion();
                    }
                } else if (tipo_accion == ACCION_MODIFICAR) {
                    numeroAfectados = registrarPrestamoServicio.modificar(prestamo);
                    if (numeroAfectados == 1) {
                        Mensaje.mostrarAfirmacionDeActualizacion();
                        this.dispose();
                    } else if (numeroAfectados == 0) {
                        Mensaje.mostrarErrorDeActualizacion();
                    }
                }
            } catch (Exception e) {
                Mensaje.mostrarAdvertencia(e.getMessage());
            }

        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_calcularResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calcularResumenActionPerformed
        calcular2();
    }//GEN-LAST:event_btn_calcularResumenActionPerformed

    private void calcular2() {
        try {
            if (verificarCampos()) {
                Date fechaFin = date_fin.getDate();
                prestamo.setFechaFin(new java.sql.Date(fechaFin.getTime()));
                prestamo.setMonto(Double.parseDouble(txt_monto.getText()));

                registrarPrestamoServicio.verificarParaCalcular(prestamo, listaPrestamo);
                inabilitarPaso4(true);
                llenarCampos3();
            }

        } catch (Exception e) {
            inabilitarPaso4(false);
            Mensaje.mostrarAdvertencia(e.getMessage());
        }
    }

    private void txt_puntosAcumuladosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_puntosAcumuladosKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_puntosAcumuladosKeyTyped

    private void date_finMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date_finMouseClicked
        JOptionPane.showMessageDialog(null, "paso");
    }//GEN-LAST:event_date_finMouseClicked

    private void txt_totalDiasPagarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalDiasPagarKeyTyped
        Verificador.verificarNumerosEspecificarRango(evt, txt_totalDiasPagar, 1, "01234567");
        
    }//GEN-LAST:event_txt_totalDiasPagarKeyTyped

    private void txt_totalDiasPagarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalDiasPagarKeyPressed

    }//GEN-LAST:event_txt_totalDiasPagarKeyPressed

    private void txt_totalDiasPagarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalDiasPagarKeyReleased
        calcularFechaDiasPagar();


    }//GEN-LAST:event_txt_totalDiasPagarKeyReleased

    private void calcularFechaDiasPagar() throws NumberFormatException {
        String numeroAux = txt_totalDiasPagar.getText();
        Date fechaInicio = date_inicio.getDate();
        if (numeroAux.equals("")) {
            Date dateFin = Verificador.sumarDiasFecha(fechaInicio, 1);
            this.date_fin.setSelectableDateRange(fechaInicio, dateFin);
            this.date_fin.setDate(dateFin);
        } else {
            int numero = Integer.parseInt(numeroAux);
            Date dateFin = Verificador.sumarDiasFecha(fechaInicio, numero);
            this.date_fin.setDate(dateFin);
            this.date_fin.setSelectableDateRange(fechaInicio, dateFin);
        }
    }

    private void date_inicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_date_inicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_date_inicioMouseClicked

    private void fiveCodButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fiveCodButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_fiveCodButton2ActionPerformed

    private void txt_montoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_montoKeyReleased
       Verificador.verificarNumerosEntreRango(evt, txt_monto , prestamo.obtenerMontoDe(),prestamo.obtenerMontoHasta());
    }//GEN-LAST:event_txt_montoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_calcularResumen;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_cancelar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_guardar;
    private FiveCodMaterialDesignButton.FiveCodMaterialButton btn_verificarSiTienPrestamoActivo;
    private com.toedter.calendar.JDateChooser date_fin;
    private com.toedter.calendar.JDateChooser date_inicio;
    private fivecodbutton.FiveCodButton fiveCodButton1;
    private fivecodbutton.FiveCodButton fiveCodButton2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage1;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage10;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage11;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage12;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage13;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage14;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage15;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage16;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage17;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage2;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage5;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage6;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage7;
    private fivecodlabelimage.FiveCodLabelImage fiveCodLabelImage8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_celular;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_cliente;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_comision;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_de;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_dni;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_email;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_estado;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_hasta;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_monto;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_mora;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_puntosAcumulados;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_subTotal;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_total;
    private FiveCodMaterialDesignTextField.FiveCodMaterialTextField txt_totalDiasPagar;
    // End of variables declaration//GEN-END:variables

//methods create for programers
    private boolean verificarCampos() {
        int contador = 0, aux = 0;

        contador = Verificador.verificadorCampos(txt_monto);
        aux = contador + aux;
        contador = Verificador.verificadorCamposFechas(date_fin);
        aux = contador + aux;
        return aux == 2;
    }

    private void llenarCampos1() {
        txt_dni.setText(clienteSeleccionado.getDni());
        txt_celular.setText(String.valueOf(clienteSeleccionado.getCelular()));
        txt_email.setText(clienteSeleccionado.getCorreoElectronico());
        txt_estado.setText(clienteSeleccionado.getEstado());
        txt_cliente.setText(clienteSeleccionado.generaNombre());

    }

    private void llenarCampos2() {
        txt_monto.setText(String.valueOf(prestamo.getMonto()));
        txt_totalDiasPagar.setText(String.valueOf(Verificador.obtenerDiasEntreFechas(prestamo.getFechaInicio(), prestamo.getFechaFin())));
        date_inicio.setDate(prestamo.getFechaInicio());
        date_fin.setDate(prestamo.getFechaFin());
    }

    private void llenarCampos3() {
        txt_subTotal.setText(String.valueOf(prestamo.getMonto()));
        txt_comision.setText(String.valueOf(prestamo.calcularComision()));
        txt_total.setText(String.valueOf(prestamo.calcularTotal()));
        txt_mora.setText("Por cada 1 día de atrazo S/. " + prestamo.generarMontoMora());

    }

    private void inabilitarPaso1(boolean estado) {
        this.txt_estado.setEnabled(estado);
        this.txt_email.setEnabled(estado);
        this.txt_celular.setEnabled(estado);
        this.txt_cliente.setEnabled(estado);
    }

    private void inabilitarPaso2(boolean estado) {
        btn_verificarSiTienPrestamoActivo.setEnabled(estado);
    }

    private void inabilitarPaso3(boolean estado) {
        txt_de.setEnabled(false);
        txt_hasta.setEnabled(false);
        date_fin.setEnabled(false);
        date_inicio.setEnabled(false);
        btn_calcularResumen.setEnabled(estado);
        txt_totalDiasPagar.setEnabled(estado);
        txt_puntosAcumulados.setEnabled(false);

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
        date_inicio.setDate(prestamo.getFechaInicio());
    }

    private void llenarDatosGenerales() {
        clienteSeleccionado = prestamo.getCliente();
        llenarCampos1();
        calcular1();
        calcular2();
        llenarCampos2();
        llenarCampos3();
        calcularFechaDiasPagar();
        inabilitarPaso2(false);
        inabilitarPaso4(false);
        inabilitarPaso1(false);
        btn_buscar.setEnabled(false);
        btn_guardar.setEnabled(true);
        btn_cancelar.setEnabled(true);

    }

}
