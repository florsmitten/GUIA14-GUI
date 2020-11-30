package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorMenuSupervisor implements ActionListener, ItemListener {

    private FrameMenuSupervisor frameMenuSupervisor;

    public ControladorMenuSupervisor() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frameMenuSupervisor.getSubopcion1()) {

            new FrameIngresoOT(new ControladorFrameIngresoOT(), true);

        } else if (e.getSource() == frameMenuSupervisor.getSubopcion2()) {

            new FrameModificacionOT(new ControladorModificacionOT());

        } else if (e.getSource() == frameMenuSupervisor.getSubopcion3()) {

            new FrameConsultaOT(new ControladorConsultaOT());

        } else if (e.getSource() == frameMenuSupervisor.getSubopcion4()) {

            new FrameConsultarTarea(new ControladorConsultarTarea());
        }

    }

    public void itemStateChanged(ItemEvent e) {

    }

    public FrameMenuSupervisor getFrameMenuSupervisor() {
        return frameMenuSupervisor;
    }

    public void setFrameMenuSupervisor(FrameMenuSupervisor frameMenuSupervisor) {
        this.frameMenuSupervisor = frameMenuSupervisor;
    }
}
