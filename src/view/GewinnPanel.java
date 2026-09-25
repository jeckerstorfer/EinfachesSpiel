package view;

import controller.GewinnController;
import javax.swing.*;
import java.awt.*;

public class GewinnPanel extends JPanel {
    private JLabel gesamtPunktsLabel;
    private JTextField spielerZahlTextField;
    private JTextField computerZahlTextField;
    private JLabel ergebnisLabel;
    private JButton nochMalButton;

    public GewinnPanel(GewinnController controller) {
        setLayout(new BorderLayout());
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
        nochMalButton = new JButton("Noch einmal!");
        JPanel buttonReihe = new JPanel();
        buttonReihe.add(nochMalButton);
        add(buttonReihe, BorderLayout.SOUTH);
        spielerZahlTextField.setActionCommand("Eingabe");
        spielerZahlTextField.addActionListener(controller);
        nochMalButton.setActionCommand("Reset");
        nochMalButton.addActionListener(controller);
    }

    public int getSpielerZahl() {
        return Integer.parseInt(spielerZahlTextField.getText());
    }

    public void showErgebnis(int ergebnis) {
        ergebnisLabel.setText(String.valueOf(ergebnis));
    }

    public void showComputerZahl(int zahl) {
        computerZahlTextField.setText(String.valueOf(zahl));
    }

    public void showGesamtPunkte(int punkte) {
        gesamtPunktsLabel.setText(String.valueOf(punkte));
    }

    public void reset() {
        spielerZahlTextField.setText("");
        computerZahlTextField.setText("");
        ergebnisLabel.setText("Tippe eine Zahl von 1 bis 9");
    }
}