package Controlador;

import Modelo.Tareas;
import Vista.FrameAsignarTarea;
import Vista.FrameConsultarTarea;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import static Controlador.Controlador.tareasList;

public class ControladorConsultarTarea implements ActionListener, ItemListener {

    private FrameConsultarTarea vista;

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonBuscar()) {

            Tareas tarea = buscarTarea(vista);

            if (tarea != null) {

                ControladorAsignarTarea controladorAsignarTarea = new ControladorAsignarTarea();
                FrameAsignarTarea consulta = new FrameAsignarTarea(controladorAsignarTarea);

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa OT");
            }
        }
    }

    private Tareas buscarTarea(FrameConsultarTarea vista) {
        Tareas tarea;
        try {
            int codTarea = Integer.parseInt(vista.getTextCodigo().getText());

            Iterator<Tareas> iteratorTarea = tareasList.iterator();
            while (iteratorTarea.hasNext()) {
                tarea = iteratorTarea.next();
                if (tarea.getCodigoTarea() == codTarea) {
                    return tarea;
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una OT ");
        }
        return null;
    }

    public void itemStateChanged(ItemEvent e) { }

    public void setVista(FrameConsultarTarea vista) {
        this.vista = vista;
    }
}
