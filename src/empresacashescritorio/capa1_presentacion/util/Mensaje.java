/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa1_presentacion.util;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Mensaje {

    private static final String errorDeConsulta = "No se pudo realizar la consulta, intente de nuevo o consulte con el Administrador.";
    private static final String filaNoSeleccionada = "Seleccione una fila.";
    private static final String filaNoExiste = "La fila seleccionada ya no existe.";

    private static final String preguntaDeEliminacion = "¿Está seguro de eliminar?";
    private static final String afirmacionDeEliminacion = "El registro fue eliminado.";
    private static final String advertenciaDeEliminacion = "El registro no puede ser eliminado, verifique.";
    private static final String advertenciaSinElementos = "Aun no hay registros para mostrar.";

    private static final String errorDeEliminacion = "No se pudo eliminar, intente de nuevo o consulte con el Administrador.";
    private static final String afirmacionDeCreacion = "Los datos fueron guardados.";
    private static final String advertenciaDeCreacion = "Los datos no fueron guardados, verifique.";
    private static final String errorDeCreacion = "No se pudieron guardar los datos.\n"
            + "Verifique los datos obligatorios y únicos.\n"
            + "Intente de nuevo o consulte con el Administrador.";
    private static final String afirmacionDeActualizacion = "Los datos fueron actualizados.";
    private static final String advertenciaDeActualizacion = "Los datos no fueron actualizados, verifique.";
    private static final String errorDeActualizacion = "No se pudieron actualizar los datos.\n"
            + "Verifique los datos obligatorios y únicos.\n"
            + "intente de nuevo o consulte con el Administrador.";

    private static final String errorDeSistema = "Error inesperado.\n"
            + "Intente de nuevo o consulte con el Administrador.";

    private static final String errorFaltaLlenar = "Error falta llenar ";
    private static final String errorNoEncontrado = "No se ha encontrado ";

    public static void mostrarMensajeDefinido(String mensaje) {

        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.SUCCESS);

    }

    public static void mostrarErrorDeConsulta() {

        DesktopNotify.showDesktopMessage(errorDeConsulta, DesktopNotify.ERROR);
    }

    public static void mostrarErrorSistema() {

        DesktopNotify.showDesktopMessage(errorDeSistema, DesktopNotify.ERROR);
    }

    public static void mostrarErrorFaltaLlenar() {
        DesktopNotify.showDesktopMessage(errorFaltaLlenar, DesktopNotify.ERROR);
    }

    public static void mostrarErrorNoEncontrado() {
        DesktopNotify.showDesktopMessage(errorNoEncontrado, DesktopNotify.ERROR);
    }

    /**
     * Seleccione una fila.
     *
     * @param dialogo
     */
    public static void mostrarFilaNoSeleccionada() {
        DesktopNotify.showDesktopMessage(filaNoSeleccionada, DesktopNotify.ERROR);

    }

    public static void mostrarFilaNoExiste() {
        DesktopNotify.showDesktopMessage(filaNoExiste, DesktopNotify.ERROR);

    }

    public static boolean mostrarPreguntaDeEliminacion(JDialog dialogo) {
        int respuesta = JOptionPane.showConfirmDialog(dialogo, preguntaDeEliminacion, "FiveCod: Pregunta", JOptionPane.YES_NO_OPTION);

        return respuesta == 1;

    }

    public static void mostrarAfirmacionDeEliminacion() {
        DesktopNotify.showDesktopMessage(afirmacionDeEliminacion, DesktopNotify.SUCCESS);
    }

    public static void mostrarAdvertenciaDeEliminacion() {
        DesktopNotify.showDesktopMessage(advertenciaDeEliminacion, DesktopNotify.SUCCESS);
    }

    public static void mostrarErrorDeEliminacion() {
        DesktopNotify.showDesktopMessage(errorDeEliminacion, DesktopNotify.ERROR);
    }

    public static void mostrarAfirmacionDeCreacion() {
        DesktopNotify.showDesktopMessage(afirmacionDeCreacion, DesktopNotify.SUCCESS);
    }

    public static void mostrarAfirmacionDeCreacion(String mensaje) {
        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.SUCCESS);
    }

    /**
     * Los datos no fueron guardados, verifique.
     *
     * @param dialogo
     */
    public static void mostrarAdvertenciaDeCreacion() {
        DesktopNotify.showDesktopMessage(advertenciaDeCreacion, DesktopNotify.WARNING);
    }

    public static void mostrarAdvertenciaSinElementos() {
        DesktopNotify.showDesktopMessage(advertenciaSinElementos, DesktopNotify.WARNING);
    }

    /**
     * No se pudieron guardar los datos, intente de nuevo o consulte con el
     * Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeCreacion() {
        DesktopNotify.showDesktopMessage(errorDeCreacion, DesktopNotify.ERROR);
    }

    /**
     * Los datos fueron actualizados.
     *
     * @param dialogo
     */
    public static void mostrarAfirmacionDeActualizacion() {
        DesktopNotify.showDesktopMessage(afirmacionDeActualizacion, DesktopNotify.SUCCESS);
    }
     public static void mostrarAfirmacionDeActualizacion(String mensaje) {
        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.SUCCESS);
    }

    /**
     * Los datos no fueron actualizados, verifique.
     *
     * @param dialogo
     */
    public static void mostrarAdvertenciaDeActualizacion() {
        DesktopNotify.showDesktopMessage(advertenciaDeActualizacion, DesktopNotify.WARNING);
    }

    /**
     * No se pudieron actualizar los datos, intente de nuevo o consulte con el
     * Administrador.
     *
     * @param dialogo
     */
    public static void mostrarErrorDeActualizacion() {
        DesktopNotify.showDesktopMessage(errorDeActualizacion, DesktopNotify.ERROR);

    }

    /**
     * Muestra un mensaje de afirmación
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarAfirmacion(String mensaje) {
        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.SUCCESS);

    }

    /**
     * Muestra un mensaje de advertencia
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarAdvertencia(String mensaje) {
        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.WARNING);

    }

    /**
     * Muestra un mensaje de error
     *
     * @param dialogo
     * @param mensaje es el mensaje que se desea mostrar
     */
    public static void mostrarError(String mensaje) {

        DesktopNotify.showDesktopMessage(mensaje, DesktopNotify.ERROR);

    }

    public static void mostrarErrorJDBC(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
