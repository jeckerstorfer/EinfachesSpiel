package controller;

import model.GewinnModel;
import view.GewinnPanel;
import view.GewinnFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Julius Eckerstorfer
 * @version 2026-09-25
 * Der Controller für das Zahlenspiel
 */
public class GewinnController implements ActionListener {

    private GewinnModel model;
    private GewinnPanel panel;

    public GewinnController() {
        this.model = new GewinnModel();
        this.panel = new GewinnPanel(this);
        GewinnFrame frame = new GewinnFrame(panel);
    }

    /**
     * Reagiert auf die Eingabe des Spielers
     * @param e das ausgelöste Event, also ButtonClick oder Enter
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int spielerZahl = 0;
        if (e.getActionCommand().equals("Eingabe")) {
            try {
                spielerZahl = this.panel.getSpielerZahl();
            } catch (NumberFormatException exc) {
                return; //prüfen für ungültige Eingaben (keine Zahlen)
            }
            if (spielerZahl < 1 || spielerZahl > 9) {
                return; // prüfen für ungültige Eingaben
            }
            // Berechnung der Runde und Ergebnis anzeigen
            this.model.berechneComputerZahl();
            this.model.berechneRunde(spielerZahl);
            this.panel.showComputerZahl(model.getComputerZahl());
            this.panel.showErgebnis(model.getRundenErgebnis());
            this.panel.showGesamtPunkte(model.getGesamtPunkte());
            this.panel.sperreEingabe();
            this.panel.faerbeLabels(model.getRundenErgebnis());
        }
        if (e.getActionCommand().equals("Reset")) { // Runde zurücksetzen
            this.panel.reset();
            this.panel.entsperreEingabe();
            this.panel.faerbeLabels(0);
        }
    }
    public static void main(String[] args) {
        new GewinnController();
    }
}