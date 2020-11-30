package Controlador;

import Modelo.OrdenesDeTrabajo;
import Modelo.Tareas;
import Vista.FrameConsultaOT;
import Vista.FrameConsultaOTOperario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import static Controlador.Controlador.ordenesDeTrabajoList;

public class ControladorConsultaOTOperario implements ActionListener {

    private FrameConsultaOTOperario vista;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonBuscar()) {

            vista.getTableModel().setRowCount(0);

            ArrayList<OrdenesDeTrabajo> ordenesDeTrabajosAux = consultaOTOperarios(vista);

            for (OrdenesDeTrabajo ot : ordenesDeTrabajosAux) {

                String esUrgente = "NO";
                if(ot.isEsUrgente()){

                    esUrgente = "SI";
                }
                Object[] row = {ot.getCodigoOT(), String.format("%02d", ot.getFechaRegistracion().get(Calendar.DAY_OF_MONTH)) + "/" +
                                String.format("%02d", (ot.getFechaRegistracion().get(Calendar.MONTH) + 1)) + "/" +
                                ot.getFechaRegistracion().get(Calendar.YEAR), ot.getProducto().getNombreProducto(),ot.getCantidadRequeridaProductos(),
                                String.format("%02d", ot.getFechaFinalizacion().get(Calendar.DAY_OF_MONTH)) + "/" +
                                String.format("%02d", (ot.getFechaFinalizacion().get(Calendar.MONTH) + 1)) + "/" +
                                ot.getFechaFinalizacion().get(Calendar.YEAR), ot.getDescripcion(), esUrgente, ot.getNombresResponsables(),
                                ot.getSupervisor().getNombreApellidoSupervisor()};
                vista.getTableModel().addRow(row);
            }
        }
    }

    public ArrayList<OrdenesDeTrabajo> consultaOTOperarios(FrameConsultaOTOperario vista) {

        ArrayList<OrdenesDeTrabajo> ordenesDeTrabajosAux = new ArrayList<OrdenesDeTrabajo>();
        try {

            long documento = Integer.parseInt(vista.getTextDocumentoOperador().getText());

            for (OrdenesDeTrabajo ot : ordenesDeTrabajoList) {

                for (Tareas tar : ot.getTareas()) {

                    if(tar.getOperario().getDocumentoOperario() == documento) {

                        ordenesDeTrabajosAux.add(ot);
                    }
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un documento");
        }

        return ordenesDeTrabajosAux;
    }

    public void setVista(FrameConsultaOTOperario vista) {
        this.vista = vista;
    }
}
