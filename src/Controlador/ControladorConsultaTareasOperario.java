package Controlador;

import Modelo.OrdenesDeTrabajo;
import Modelo.Tareas;
import Vista.FrameConsultaTareasOperario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

import static Controlador.Controlador.ordenesDeTrabajoList;

public class ControladorConsultaTareasOperario implements ActionListener {

    private FrameConsultaTareasOperario vista;

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonBuscar()) {

            vista.getTableModel().setRowCount(0);

            ArrayList<Tareas> tareasAux = consultaTareasAsignadas(vista);

            for (Tareas tareas : tareasAux) {

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

    public ArrayList<Tareas> consultaTareasAsignadas(FrameConsultaTareasOperario vista) {

        ArrayList<Tareas> tareasAux = new ArrayList<Tareas>();
        try {

            long documentoOperador = Long.parseLong(vista.getTextDocumentoOperador().getText());

            for (OrdenesDeTrabajo ot : ordenesDeTrabajoList) {

                for(Tareas tar : ot.getTareas()){

                    long docOp = tar.getOperario().getDocumentoOperario();

                    if (docOp == documentoOperador) {
                        tareasAux.add(tar);
                    }
                }
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un documento");
        }

        return tareasAux;
    }

    public void setVista(FrameConsultaTareasOperario vista) {
        this.vista = vista;
    }
}
