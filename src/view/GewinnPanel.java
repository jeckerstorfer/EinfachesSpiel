package view;

import controller.GewinnController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GewinnPanel extends JPanel {
    private JLabel gesamtPunktsLabel;
    private JTextField spielerZahlTextField;
    private JTextField computerZahlTextField;
    private JLabel ergebnisLabel;
    private JButton nochMalButton;

    public GewinnPanel(GewinnController controller) {
        setLayout(new BorderLayout());
        JPanel oben = new JPanel(new GridLayout(1, 2));
        this.gesamtPunktsLabel = new JLabel("Gesamtpunkte: 30", JLabel.CENTER);
        this.ergebnisLabel = new JLabel = new JLabel("Ergebnis: -", JLabel.CENTER);
        this.gesamtPunktsLabel.setBackground(Color.WHITE);
        this.ergebnisLabel.setBackground(Color.WHITE);
        oben.add(this.gesamtPunkteLabel);
        oben.add(this.ergebnisLabel);
        JPanel unten = new JPanel();
        this.spielerZahlTextField = new JTextField(5);
        this.computerZahlTextField = new JTextField(5);
        computerZahlTextField.setEditable(false);
        nochMalButton = new JButton("Noch einmal!");
        unten.add(new JLabel("Deine Zahl:"));
        unten.add(spielerZahlTextField);
        unten.add(new JLabel("Computer:"));
        unten.add(computerZahlTextField);
        unten.add(nochMalButton);
        add(unten, BorderLayout.CENTER);

        spielerZahlTextField.setActionCommand("Eingabe");
        spielerZahlTextField.addActionListener(controller);
        nochMalButton.setActionCommand("Reset");
        nochMalButton.addActionListener(controller);
}
