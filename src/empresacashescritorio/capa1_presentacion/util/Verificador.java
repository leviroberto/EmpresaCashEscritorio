/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion.util;

import FiveCodMaterialDesignTextField.FiveCodMaterialTextField;
import FiveCodMaterilalDesignComboBox.FiveCodMaterialComboBox;
import app.bolivia.swing.JCTextField;
import com.toedter.calendar.JDateChooser;
import empresacashescritorio.capa3_dominio.TipoCliente;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import org.jdesktop.swingx.JXSearchField;
import rojeru_san.componentes.RSDateChooser;

/**
 *
 * @author FiveCod Software
 */
public class Verificador {

    private static int x, y;

    public static int obtenerDiasEntreFechas(Date fechaInicio, Date fechaFin) {
        return (int) ((fechaFin.getTime() - fechaInicio.getTime()) / 86400000);
    }

    public static TipoCliente obtenerTipoClienteDefacto() {
        TipoCliente tipoCliente = new TipoCliente();
        tipoCliente.setDescripcion("TIPO CLIENTE");
        return tipoCliente;
    }

    public static Boolean estaVacioTexto(FiveCodMaterialTextField texto) {
        if (texto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean estaVacioTexto(JXSearchField texto) {
        if (texto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean estaVacio(FiveCodMaterialTextField texto) {
        if (texto.getText().equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean estaVacioTextoFecha(RSDateChooser texto) {
        if (texto.getDatoFecha() == null) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean estaVacioTextoFecha(JDateChooser texto) {
        if (texto.getDate() == null) {
            return true;
        } else {
            return false;
        }
    }
//nos permite decirle que cuente una cantidad de letras dentro del objeto

    public static int verificarContadorNumeros(FiveCodMaterialTextField texto, JLabel label, String cadena, int cantidad) {
        int contador = 0;
        if (texto.getText().length() < cantidad) {
            label.setText("Numero " + cadena + " incorrecto");
            label.requestFocus();
            pintarColor(label);
            contador = 0;
        } else {
            label.setText(cadena + "Correcto");
            quitarColor(label);
            contador = 1;
        }
        return contador;
    }

    public static int verificarCantidadLetras(FiveCodMaterialTextField texto, JLabel label, String cadena, int cantidad) {
        int contador = 0;
        if (texto.getText().length() < cantidad) {
            label.setText(cadena + " Correcto");
            quitarColor(label);
            contador = 1;
        } else {
            label.setText("Hay mucho texto en " + cadena);
            label.requestFocus();
            pintarColor(label);
            contador = 0;
        }
        return contador;
    }

    public static int verificadorCampos(FiveCodMaterialTextField texto) {
        int contador = 0;
        if (Verificador.estaVacioTexto(texto)) {
            texto.setAccent(Color.RED);
            texto.requestFocus();
            texto.selectAll();
            contador = 0;
        } else {
            texto.setAccent(new Color(0, 132, 235));
            contador = 1;
        }
        return contador;
    }

    public static int verificadorCampos(JXSearchField texto, JLabel label, String cadena) {
        int contador = 0;
        if (Verificador.estaVacioTexto(texto)) {
            label.setText("Falta " + cadena);
            label.requestFocus();
            pintarColor(label);
            contador = 0;
        } else {
            label.setText(cadena + " Correcto");
            quitarColor(label);
            contador = 1;
        }
        return contador;
    }

    public static int verificadorCamposFechas(RSDateChooser fecha) {
        int contador = 0;
        if (estaVacioTextoFecha(fecha)) {
            contador = 0;
        } else {
            contador = 1;
        }
        return contador;
    }

    public static int verificadorCamposFechas(JDateChooser fecha) {
        int contador = 0;
        if (estaVacioTextoFecha(fecha)) {
            contador = 0;
        } else {
            contador = 1;
        }
        return contador;
    }

    public static int verificarDNI(FiveCodMaterialTextField txt_dni) {
        int contador = 0;
        if (estaVacio(txt_dni)) {
            txt_dni.requestFocus();

            contador = 0;
        } else if (txt_dni.getText().length() == 8) {
            contador = 1;
        } else {
            txt_dni.requestFocus();
            txt_dni.selectAll();
            contador = 0;
        }
        return contador;
    }

    public static boolean verificarCorreoElectronico(String email) {
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        // El email a validar
        Matcher mather = pattern.matcher(email);
        return mather.find();
    }

    public static int verificarCombobox(FiveCodMaterialComboBox combobox) {
        int contador = 0;
        if (combobox.getSelectedIndex() == 0) {
            combobox.setAccent(Color.RED);
            combobox.requestFocus();

            contador = 0;
        } else {

            combobox.setAccent(new Color(0, 132, 235));
            contador = 1;
        }
        return contador;
    }

    public static void ponerMayusculaPrimeraLetra(FiveCodMaterialTextField texto) {
        try {
            if (texto.getText().length() > 0) {
                String[] arreglo = texto.getText().split(" ");
                String cadenaContenada = "";
                for (int i = 0; i < arreglo.length; i++) {
                    String Axtexto = arreglo[i];
                    if (Axtexto.length() > 0) {
                        cadenaContenada = cadenaContenada + " " + Axtexto.substring(0, 1).toUpperCase() + "" + Axtexto.substring(1, Axtexto.length()).toLowerCase();
                    }
                }
                texto.setText(cadenaContenada);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void pintarColor(JLabel label) {
        label.setForeground(new Color(219, 0, 0));
    }

    public static void pintarColor(JLabel label, String texto) {
        label.setForeground(new Color(219, 0, 0));
        label.setText("Error  " + texto);
    }

    public static void quitarColor(JLabel label) {
        label.setForeground(new Color(0, 200, 81));
    }

    public static void MousePressed(MouseEvent evt) {
        x = evt.getX();
        y = evt.getY();
    }

    public static void MouseDragged(MouseEvent evt, JDialog dialog) {
        dialog.setLocation(dialog.getLocation().x + evt.getX() - x, dialog.getLocation().y + evt.getY() - y);
    }

    public static void MouseDraggedFrame(MouseEvent evt, JFrame dialog) {
        dialog.setLocation(dialog.getLocation().x + evt.getX() - x, dialog.getLocation().y + evt.getY() - y);
    }

    public static void PresionarEnter(KeyEvent evt, FiveCodMaterialTextField texto) {
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            texto.requestFocus();
        }
    }

    public static int obtenerNumeroMes(String mes) {
        int numero = 0;
        switch (mes) {
            case "ENERO":
                numero = 1;
                break;
            case "FEBRERO":
                numero = 2;
                break;
            case "MARZO":
                numero = 3;
                break;
            case "ABRIL":
                numero = 4;
                break;
            case "MAYO":
                numero = 5;
                break;
            case "JUNIO":
                numero = 6;
                break;
            case "JULIO":
                numero = 7;
                break;
            case "AGOSTO":
                numero = 8;
                break;
            case "SEPTIEMBRE":
                numero = 9;
                break;
            case "OCTUBRE":
                numero = 10;
                break;
            case "NOVIEMBRE":
                numero = 11;
                break;
            case "DICIEMBRE":
                numero = 12;
                break;

        }
        return numero;
    }

    public static String obtenerNombreMes(int mes) {
        String nombreMes = "";
        switch (mes) {
            case 1:
                nombreMes = "ENERO";
                break;
            case 2:
                nombreMes = "FEBRERO";
                break;
            case 3:
                nombreMes = "MARZO";
                break;
            case 4:
                nombreMes = "ABRIL";
                break;
            case 5:
                nombreMes = "MAYO";
                break;
            case 6:
                nombreMes = "JUNIO";
                break;
            case 7:
                nombreMes = "JULIO";
                break;
            case 8:
                nombreMes = "AGOSTO";
                break;
            case 9:
                nombreMes = "SEPTIEMBRE";
                break;
            case 10:
                nombreMes = "OCTUBRE";
                break;
            case 11:
                nombreMes = "NOVIEMBRE";
                break;
            case 12:
                nombreMes = "DICIEMBRE";
                break;

        }
        return nombreMes;
    }

    public static boolean verificarCumpleaños(Date fechaSistema, Date fechaTrabajador) {
//        String formatoAnio = "yyyy";
        String formatomes = "MM";
        String formatodia = "DD";
//        SimpleDateFormat dateFormatAnio = new SimpleDateFormat(formatoAnio);
        SimpleDateFormat dateFormatMes = new SimpleDateFormat(formatomes);
        SimpleDateFormat dateFormatDia = new SimpleDateFormat(formatodia);

//        int aniosistema = Integer.parseInt(dateFormatAnio.format(fechaSistema));
        int messistema = Integer.parseInt(dateFormatMes.format(fechaSistema));
        int diasistema = Integer.parseInt(dateFormatDia.format(fechaSistema));

//        int anioTrabajador = Integer.parseInt(dateFormatAnio.format(fechaTrabajador));
        int mesTrabajador = Integer.parseInt(dateFormatMes.format(fechaTrabajador));
        int diaTrabajador = Integer.parseInt(dateFormatDia.format(fechaTrabajador));

        return mesTrabajador == messistema && diaTrabajador == diasistema;

    }

//    public static int calcularEdad(Date fechaNacimiento) {
//        java.util.Date fecha = new java.util.Date();
//        LocalDate fechaHoy = LocalDate.now();
//        return fechaHoy.getYear() - fechaNacimiento.getYear();
//    }
    public static int calcularEdad(Date fechaNacimiento) {
        Calendar today = Calendar.getInstance();
        String formatoAnio = "yyyy";
        SimpleDateFormat dateFormatAnio = new SimpleDateFormat(formatoAnio);
        int anio = Integer.parseInt(dateFormatAnio.format(fechaNacimiento));
        int diffYear = today.get(Calendar.YEAR) - anio;

        return diffYear;
    }

    public static void verificarNumeros(KeyEvent evt, FiveCodMaterialTextField txt_dni, int numero) {
        String patron_de_entrada = "0123456789";
        if (txt_dni.getText().length() == numero
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }
    public static void verificarNumeros(KeyEvent evt, JTextField txt_dni, int numero) {
        String patron_de_entrada = "0123456789";
        if (txt_dni.getText().length() == numero
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }

    public static void verificarNumerosEspecificarRango(KeyEvent evt, FiveCodMaterialTextField txt_dni, int numero, String rango) {
        String patron_de_entrada = rango;
        if (txt_dni.getText().length() == numero
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }
    }

    public static void verificarNumerosEntreRango(KeyEvent evt, FiveCodMaterialTextField txt_dni, double numeroInicio, double numeroFin) {
        String patron_de_entrada = "0123456789.";
        String numeroAux = txt_dni.getText();
        double numero = 0;
        if (!numeroAux.equals("")) {
            numero = Double.parseDouble(numeroAux);
        }

        if (txt_dni.getText().length() == 4 || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        } else if (numero < numeroInicio || numero > numeroFin) {
            txt_dni.setAccent(Color.RED);
        } else {
            txt_dni.setAccent(Color.GREEN);
        }
    }
    
     public static void verificarNumerosEntreRango(KeyEvent evt, FiveCodMaterialTextField txt_dni, double numeroInicio, double numeroFin,String entrada) {
        String patron_de_entrada = entrada;
        String numeroAux = txt_dni.getText();
        double numero = 0;
        if (!numeroAux.equals("")) {
            numero = Double.parseDouble(numeroAux);
        }

        if (txt_dni.getText().length() == 4 || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        } else if (numero < numeroInicio || numero > numeroFin) {
            txt_dni.setAccent(Color.RED);
        } else {
            txt_dni.setAccent(Color.GREEN);
        }
    }

    public static void verificarNumerosDecimales(KeyEvent evt, FiveCodMaterialTextField txt_dni, int numero) {
        String patron_de_entrada = "0123456789.";

        if (txt_dni.getText().length() == numero
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }

    }

    public static void verificarNumeros(KeyEvent evt, JXSearchField txt_dni, int numero) {
        String patron_de_entrada = "0123456789";
        if (txt_dni.getText().length() == numero
                || !patron_de_entrada.contains(String.valueOf(evt.getKeyChar()))) {
            evt.consume();
        }

    }

    public static Date sumarDiasFecha(Date fecha, int dias) {
        if (dias == 0) {
            return fecha;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

}
