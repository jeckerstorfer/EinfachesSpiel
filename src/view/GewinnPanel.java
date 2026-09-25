package view;

import controller.GewinnController;
import javax.swing.*;
import java.awt.*;

/**
 * @author Julius Eckerstorfer
 * @verson 2026-09-25
 * Die UI Oberfläche für das Spiel
 */
public class GewinnPanel extends JPanel {
    private JLabel gesamtPunktsLabel;
    private JTextField spielerZahlTextField;
    private JTextField computerZahlTextField;
    private JLabel ergebnisLabel;
    private JButton nochMalButton;

    /**
     * Baut das Layout auf und registriert den Controller
     * @param controller der Controller, welcher auf Events reagiert
     */
    public GewinnPanel(GewinnController controller) {
        setLayout(new BorderLayout());
        // Der obere Breich für Rundenergebnis und Gesamtpunkte
        JPanel oben = new JPanel(new GridLayout(1, 2));
        JPanel ergebnisSpalte = new JPanel(new GridLayout(2, 1));
        JLabel ergebnisText = new JLabel("Rundenergebnis", JLabel.CENTER);
        this.ergebnisLabel = new JLabel("Tippe eine Zahl von 1 bis 9", JLabel.CENTER);
        ergebnisSpalte.add(ergebnisText);
        ergebnisSpalte.add(ergebnisLabel);
        this.gesamtPunktsLabel = new JLabel("30", JLabel.CENTER);
        JPanel punkteSpalte = new JPanel(new GridLayout(2, 1));
        JLabel punkteText = new JLabel("Gesamtpunkte", JLabel.CENTER);
        punkteSpalte.add(punkteText);
        punkteSpalte.add(gesamtPunktsLabel);
        ergebnisSpalte.setOpaque(true);
        punkteSpalte.setOpaque(true);
        this.gesamtPunktsLabel.setOpaque(true);
        this.ergebnisLabel.setOpaque(true);
        ergebnisSpalte.setBackground(Color.WHITE);
        punkteSpalte.setBackground(Color.WHITE);
        this.gesamtPunktsLabel.setBackground(Color.WHITE);
        this.ergebnisLabel.setBackground(Color.WHITE);
        oben.add(ergebnisSpalte);
        oben.add(punkteSpalte);
        add(oben, BorderLayout.NORTH);

        // Der mittlere Bereich für das Eingabefeld von Spieler und Computer
        JPanel mitte = new JPanel(new GridLayout(1, 2));
        JPanel eingabeSpalte = new JPanel(new BorderLayout());
        JLabel eingabeText = new JLabel("Deine Zahl:", JLabel.CENTER);
        eingabeSpalte.add(eingabeText, BorderLayout.NORTH);
        this.spielerZahlTextField = new JTextField();
        this.spielerZahlTextField.setHorizontalAlignment(JTextField.CENTER);
        this.spielerZahlTextField.setFont(spielerZahlTextField.getFont().deriveFont(48f));
        eingabeSpalte.add(spielerZahlTextField, BorderLayout.CENTER);
        JPanel computerSpalte = new JPanel(new BorderLayout());
        JLabel computerText = new JLabel("Computer:", JLabel.CENTER);
        computerSpalte.add(computerText, BorderLayout.NORTH);
        this.computerZahlTextField = new JTextField();
        this.computerZahlTextField.setHorizontalAlignment(JTextField.CENTER);
        this.computerZahlTextField.setFont(computerZahlTextField.getFont().deriveFont(48f));
        computerZahlTextField.setEditable(false);
        computerSpalte.add(computerZahlTextField, BorderLayout.CENTER);
        mitte.add(eingabeSpalte);
        mitte.add(computerSpalte);
        add(mitte, BorderLayout.CENTER);

        // Unterer Bereich für den Reset Button
        nochMalButton = new JButton("Noch einmal!");
        nochMalButton.setEnabled(false);
        JPanel buttonReihe = new JPanel();
        buttonReihe.add(nochMalButton);
        add(buttonReihe, BorderLayout.SOUTH);
        // der Controller wird als Listener beschrieben
        spielerZahlTextField.setActionCommand("Eingabe");
        spielerZahlTextField.addActionListener(controller);
        nochMalButton.setActionCommand("Reset");
        nochMalButton.addActionListener(controller);
    }

    /**
     * Liest die Zahl des Spielers und wandelt sie zu int um
     * @return die eingegebne Zahl
     * @throws NumberFormatException wenn die Eingabe keine Zahl ist
     */
    public int getSpielerZahl() {
        return Integer.parseInt(spielerZahlTextField.getText());
    }

    /**
     * Zeigt das aktuelle Ergebnis an
     * @param ergebnis das Rundenergebnis
     */
    public void showErgebnis(int ergebnis) {
        ergebnisLabel.setText(String.valueOf(ergebnis));
    }

    /**
     * Zeigt die zufällig generierte Zahl des Computers an
     * @param zahl die Zufallszahl
     */
    public void showComputerZahl(int zahl) {
        computerZahlTextField.setText(String.valueOf(zahl));
    }

    /**
     * der aktuelle Punktestand wird gezeigt
     * @param punkte der Punktestand
     */
    public void showGesamtPunkte(int punkte) {
        gesamtPunktsLabel.setText(String.valueOf(punkte));
    }

    /**
     * Löscht die Anzeigen der letzten Runde und setzt sie zurück
     */
    public void reset() {
        spielerZahlTextField.setText("");
        computerZahlTextField.setText("");
        ergebnisLabel.setText("Tippe eine Zahl von 1 bis 9");
    }

    /**
     * Sperrt das Eingabefeld und entsperrt den Button
     */
    public void sperreEingabe() {
        spielerZahlTextField.setEnabled(false);
        nochMalButton.setEnabled(true);
    }

    /**
     * Das Eingabefeld wird entsperrt und der Button wird gesperrt
     */
    public void entsperreEingabe() {
        spielerZahlTextField.setEnabled(true);
        nochMalButton.setEnabled(false);
    }

    /**
     * Bestimmt die Farbe der Labels je nach Ergebnis
     * @param rundenErgebnis das aktuelle Rundenergebnis
     */
    public void faerbeLabels(int rundenErgebnis) {
        Color farbe;
        if (rundenErgebnis > 0) {
            farbe = Color.GREEN;
        } else if (rundenErgebnis < 0) {
            farbe = Color.RED;
        } else {
            farbe = Color.WHITE;
        }
        ergebnisLabel.setBackground(farbe);
        gesamtPunktsLabel.setBackground(farbe);
    }
}