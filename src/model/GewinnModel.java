package model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 0;
        this.spielerZahl = 30;
        this.computerZahl = 0;
        this.rundenErgebnis = 0;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getSpielerZahl() {
        return spielerZahl;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        this.computerZahl = (int) ((Math.random() * 9) + 1);
    }

    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) {
            return;
        }
        int differenz = this.spielerZahl - this.computerZahl;
        if(differenz == 0) {
            rundenErgebnis = 20;
        }
        if(differenz == 1 || differenz == -1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }

    public boolean hatGewonnen() {
        if(gesamtPunkte >= 100) {
            return true
        }
        return false;
    }

    public boolean hatVerloren() {
        if(gesamtPunkte <= 0) {
            return true;
        }
        return false;
    }
}
