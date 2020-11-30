package Controlador;

import Modelo.OrdenesDeTrabajo;
import Vista.FrameIngresoOT;
import Vista.FrameModificacionOT;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Iterator;
import static Controlador.Controlador.ordenesDeTrabajoList;
import static Controlador.OTControlador.mostrarOT;

public class ControladorModificacionOT implements ActionListener, ItemListener {

    private FrameModificacionOT vista;

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getButtonBuscar()) {

            OrdenesDeTrabajo ordenesDeTrabajo = buscarOT(vista);

            if (ordenesDeTrabajo != null) {

                ControladorFrameIngresoOT controladorFrameIngresoOT = new ControladorFrameIngresoOT();
                FrameIngresoOT consulta = new FrameIngresoOT(controladorFrameIngresoOT, false);
                mostrarOT(ordenesDeTrabajo, consulta);
                consulta.editable(false);

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa OT");
            }
        }
    }

    private OrdenesDeTrabajo buscarOT(FrameModificacionOT vista) {
        OrdenesDeTrabajo ordenesDeTrabajo;
        try {
            int ot = Integer.parseInt(vista.getTextCodigo().getText());

            Iterator<OrdenesDeTrabajo> iteratorOT = ordenesDeTrabajoList.iterator();
            while (iteratorOT.hasNext()) {
                ordenesDeTrabajo = iteratorOT.next();
                if (ordenesDeTrabajo.getCodigoOT() == ot) {
                    return ordenesDeTrabajo;
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una OT ");
        }
        return null;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public void setVista(FrameModificacionOT vista) {
        this.vista = vista;
    }
}
