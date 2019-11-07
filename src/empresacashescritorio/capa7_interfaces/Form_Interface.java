/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresacashescritorio.capa7_interfaces;

/**
 *
 * @author l9531
 */
public interface Form_Interface {

    void llenarTitulosTabla();

    void llenarDatosTabla();

    void buscarDatosConLike();
    void buscarDatosSinlike();

    void eliminar();

    void crear();

    void modificar();

    void cancelar();

    void buscar();

    void inabilitarBotones(boolean estado);

    void pintarBotones(boolean estado);

}
