package Controlador;

import Vista.FrameMenuOperador;
import Vista.FrameMenuSupervisor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorMenuOperador implements ActionListener, ItemListener {

    private FrameMenuOperador frameMenuOperador;

    public ControladorMenuOperador() {
    }

    public FrameMenuOperador getFrameMenuOperador() {
        return frameMenuOperador;
    }

    public void setFrameMenuOperador(FrameMenuOperador frameMenuOperador) {
        this.frameMenuOperador = frameMenuOperador;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
