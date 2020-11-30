package Controlador;

import Modelo.DAO.OrdenTrabajoDB;
import Modelo.OrdenesDeTrabajo;
import Modelo.Productos;
import Modelo.Supervisores;
import Vista.FrameIngresoOT;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import static Controlador.OTControlador.*;
import static Controlador.Controlador.*;

public class ControladorFrameIngresoOT implements ActionListener, ItemListener{

    private FrameIngresoOT vista;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.getButtonAceptar()) {

            agregarOT(vista);
            vista.limpiar(false);

        } else if (e.getSource() == vista.getButtonEditar()) {
            vista.editable(true);
            vista.getButtonAceptar().setVisible(true);
            vista.getButtonCancelar().setVisible(true);
            vista.getButtonAceptar().setEnabled(true);
            vista.getButtonCancelar().setEnabled(true);
            vista.getButtonEditar().setVisible(false);
            vista.getTextCodigoOT().setEnabled(false);
            vista.getButtonAnular().setVisible(false);

        } else if (e.getSource() == vista.getButtonAnular()) {
            int codigoOT = Integer.parseInt(vista.getTextCodigoOT().getText().trim());

            int opcion = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar la OT?",
                    "Confirmación", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {

                OrdenesDeTrabajo ordenDeTrabajo = buscarOT(codigoOT);
                OrdenTrabajoDB.deleteOT(codigoOT); //de tabla
                eliminarOT(codigoOT); //de memoria
                JOptionPane.showMessageDialog(null, "La persona se elimino correctamente");
            }
            vista.limpiar(false);
        }
    }

    public void setVista(FrameIngresoOT vista) {

        vista.getComboProductos().addItem("Seleccione un producto");

        for (Productos pro : productos) {
            vista.getComboProductos().addItem(pro.getNombreProducto());

        }

        vista.getComboProductos().addItem("Seleccione un supervisor");

        for (Supervisores sup : supervisores) {
            vista.getComboSupervisor().addItem(sup.getNombreApellidoSupervisor());

        }

        this.vista = vista;
    }

    public void itemStateChanged(ItemEvent o) {

    }
}
