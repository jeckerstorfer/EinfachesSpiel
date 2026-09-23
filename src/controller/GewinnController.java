package controller;

import model.GewinnModel;
import view.GewinnPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GewinnController implements ActionListener {

    private GewinnModel model;
    private GewinnPanel panel;

    public GewinnController(GewinnModel model, GewinnPanel panel) {
        this.model = model;
        this.panel = panel;
        this.panel.addEnterListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int spielerZahl = 0;
        if (e.getActionCommand().equals("Eingabe") {
            try {
                spielerZahl = this.panel.getSpielerZahl();
            } catch(NumberFormatException exc) {
                return;
            }
            spielerZahl = this.panel.getSpielerZahl();
            if(spielerZahl < 1 || spielerZahl > 9) {
                return;
            }
            this.model.berechneComputerZahl();
            this.model.berechneRunde(spielerZahl);
            this.panel.zeigeComputerZahl(model.getComputerZahl());
            this.panel.zeigeErgebnis(model.getRundenErgebnis());
            this.panel.zeigeGesamtPunkte(model.getGesamtPunkte());
            break;

        }
        if(e.getActionCommand().equals("Reset"))) {
            this.panel.reset();
            break;
        }
    }
    public static void main(String[] args) {
        new GewinnController(model, panel);
    }

}
