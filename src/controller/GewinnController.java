package controller;

import model.GewinnModel;
import view.GewinnPanel;
import view.GewinnFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {

    private GewinnModel model;
    private GewinnPanel panel;

    public GewinnController() {
        this.model = new GewinnModel();
        this.panel = new GewinnPanel(this);
        GewinnFrame frame = new GewinnFrame(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int spielerZahl = 0;
        if (e.getActionCommand().equals("Eingabe")) {
            try {
                spielerZahl = this.panel.getSpielerZahl();
            } catch (NumberFormatException exc) {
                return;
            }
            if (spielerZahl < 1 || spielerZahl > 9) {
                return;
            }
            this.model.berechneComputerZahl();
            this.model.berechneRunde(spielerZahl);
            this.panel.showComputerZahl(model.getComputerZahl());
            this.panel.showErgebnis(model.getRundenErgebnis());
            this.panel.showGesamtPunkte(model.getGesamtPunkte());
            this.panel.sperreEingabe();
        }
        if (e.getActionCommand().equals("Reset")) {
            this.panel.reset();
            this.panel.entsperreEingabe();
        }
    }

    public static void main(String[] args) {
        new GewinnController();
    }
}