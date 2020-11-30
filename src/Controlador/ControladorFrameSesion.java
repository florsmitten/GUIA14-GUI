package Controlador;

import Vista.FrameMenuOperador;
import Vista.FrameMenuSupervisor;
import Vista.FrameSesion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorFrameSesion implements ActionListener, ItemListener {

    private FrameSesion frameSesion;

    public ControladorFrameSesion() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == frameSesion.getButtonSupervisor()) {

            new FrameMenuSupervisor(new ControladorMenuSupervisor());

        } else if (e.getSource() == frameSesion.getButtonOperario()) {

            new FrameMenuOperador(new ControladorMenuOperador());

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }

    public void setframeSesion(FrameSesion frameSesion) {
        this.frameSesion = frameSesion;
    }

    public FrameSesion getframeSesion() {
        return frameSesion;
    }
}
