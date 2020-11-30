package Controlador;

import Modelo.OrdenesDeTrabajo;
import Modelo.Tareas;
import Vista.FrameConsultaOT;
import Vista.FrameConsultaOTOperario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static Controlador.Controlador.ordenesDeTrabajoList;

public class ControladorConsultaOTOperario implements ActionListener {

    private FrameConsultaOTOperario vista;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonBuscar()) {

            vista.getTableModel().setRowCount(0);

            OrdenesDeTrabajo ordenesDeTrabajosAux = consultaOT(vista);

            for (Tareas tareas : ordenesDeTrabajosAux.getTareas()) {
                String tareaRealizada = "NO";
                if(tareas.isTareaRealizada()){

                    tareaRealizada = "SI";
                }
                Object[] row = {tareas.getCodigoTarea(), tareaRealizada,
                        String.format("%02d", tareas.getFechaFinTarea().get(Calendar.DAY_OF_MONTH)) + "/" +
                                String.format("%02d", (tareas.getFechaFinTarea().get(Calendar.MONTH) + 1)) + "/" +
                                tareas.getFechaFinTarea().get(Calendar.YEAR), tareas.getHoraFinTarea(),
                        tareas.getOperario()};
                vista.getTableModel().addRow(row);
            }
        }
    }

    public OrdenesDeTrabajo consultaOT(FrameConsultaOT vista) {

        OrdenesDeTrabajo ordenesDeTrabajosAux = new OrdenesDeTrabajo();
        try {

            int codigoOT = Integer.parseInt(vista.getTextCodigoOT().getText());

            for (OrdenesDeTrabajo ot : ordenesDeTrabajoList) {

                int codOT = ot.getCodigoOT();

                if (codOT == codigoOT) {
                    ordenesDeTrabajosAux = ot;
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una OT ");
        }

        return ordenesDeTrabajosAux;
    }

    public void setVista(FrameConsultaOTOperario vista) {
        this.vista = vista;
    }
}
