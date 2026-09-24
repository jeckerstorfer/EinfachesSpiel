package model;

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        // Standard-Werte werden gesetzt
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
        this.computerZahl = (int) ((Math.random() * 9) + 1); // Zufallszahl wird für den Computer berechnet
    }

    public void berechneRunde(int spielerZahl) {
        if(spielerZahl > 9 || spielerZahl < 1) { // Prüfen für gültige Zahlen
            return;
        }
        this.spielerZahl = spielerZahl;
        int differenz = this.spielerZahl - this.computerZahl; // die Berechnung der Differenz
        if(differenz == 0) {
            rundenErgebnis = 20;
        }
        if(differenz == 1 || differenz == -1) { // wenn die Differenz genau 1 ist
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10; // Die Differenz darf nicht über 1 sein, sonst werden 10 Punkte abgezogen
        }
        this.gesamtPunkte += this.rundenErgebnis;
    }

    public boolean hatGewonnen() {
        if (gesamtPunkte >= 100) {
            return true;
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
