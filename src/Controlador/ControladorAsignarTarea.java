package Controlador;

import Modelo.Operarios;
import Vista.FrameAsignarTarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static Controlador.Controlador.*;
import static Controlador.OTControlador.*;

public class ControladorAsignarTarea implements ActionListener, ItemListener {

    private FrameAsignarTarea vista;

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonAceptar()) {

            agregarTarea(vista);
            vista.limpiar(false);
        }
    }

    public void setVista(FrameAsignarTarea vista) {

        vista.getComboOperarios().addItem("Seleccione un operario");

        for (Operarios oper : operarios) {
            vista.getComboOperarios().addItem(oper.getNombreApellidoOperario());
        }
        this.vista = vista;
    }

    public void itemStateChanged(ItemEvent o) {

    }
}
