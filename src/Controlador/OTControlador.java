package Controlador;

import Modelo.OrdenesDeTrabajo;
import Vista.FrameIngresoOT;

import javax.swing.*;
import java.util.Calendar;
import java.util.Iterator;
import static Controlador.Controlador.*;

public class OTControlador {

    public static void agregarOT(FrameIngresoOT vista){


    }

    public static OrdenesDeTrabajo buscarOT(int codigoOT) {

        OrdenesDeTrabajo ot;
        Iterator<OrdenesDeTrabajo> iteratorPersonas = ordenesDeTrabajoList.iterator();
        while (iteratorPersonas.hasNext()) {
            ot = iteratorPersonas.next();

            if (ot.getCodigoOT() == codigoOT) {
                return ot;
            }
        }
        return null;
    }

    public static void eliminarOT(int codigoOT) {

        boolean encontrada = false;

        OrdenesDeTrabajo OrdenesDeTrabajoaUX;
        Iterator<OrdenesDeTrabajo> per = ordenesDeTrabajoList.iterator();
        while (per.hasNext()) {
            OrdenesDeTrabajoaUX = per.next();

            if (OrdenesDeTrabajoaUX.getCodigoOT() == codigoOT) {
                encontrada = true;
                ordenesDeTrabajoList.remove(OrdenesDeTrabajoaUX);
                break;
            }
        }

        if (!encontrada) {
            JOptionPane.showMessageDialog(null, "No se puede eliminar la OT, la misma no se encuentra ingresada");
        }
    }

    public static void mostrarOT(OrdenesDeTrabajo ordenesDeTrabajo, FrameIngresoOT vista) {

        vista.getTextCodigoOT().setText(String.valueOf(ordenesDeTrabajo.getCodigoOT()));
        vista.getLabelCantidadRequerida().setText(String.valueOf(ordenesDeTrabajo.getCantidadRequeridaProductos()));
        vista.getTextDescripcion().setText(ordenesDeTrabajo.getDescripcion());
        vista.getTextNombreResponsables().setText(ordenesDeTrabajo.getNombresResponsables());

        boolean esUrgente = (ordenesDeTrabajo.isEsUrgente());

        vista.getBoxEsUrgente().setSelected(esUrgente);

        String fechaFin = String.format("%02d", ordenesDeTrabajo.getFechaFinalizacion().get(Calendar.DAY_OF_MONTH))
                + String.format("%02d", (ordenesDeTrabajo.getFechaFinalizacion().get(Calendar.MONTH) + 1))
                + String.format("%04d", (ordenesDeTrabajo.getFechaFinalizacion().get(Calendar.YEAR)));
        vista.getTextFechaFinalizacion().setText(fechaFin);
    }
}
