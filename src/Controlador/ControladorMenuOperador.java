package Controlador;

import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorMenuOperador implements ActionListener, ItemListener {

    private FrameMenuOperador frameMenuOperador;

    public ControladorMenuOperador() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frameMenuOperador.getSubopcion1()) {

            new FrameConsultaTareasOperario(new ControladorConsultaTareasOperario());

        } else if (e.getSource() == frameMenuOperador.getSubopcion2()) {

            new FrameConsultaOTOperario(new ControladorConsultaOTOperario());
        }
    }

    public void itemStateChanged(ItemEvent e) {

    }

    public FrameMenuOperador getFrameMenuOperador() {
        return frameMenuOperador;
    }

    public void setFrameMenuOperador(FrameMenuOperador frameMenuOperador) {
        this.frameMenuOperador = frameMenuOperador;
    }
}
