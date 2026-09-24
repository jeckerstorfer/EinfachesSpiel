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

        JPanel unten = new JPanel(new BorderLayout());

        JPanel eingabeSpalte = new JPanel();
        eingabeSpalte.setLayout(new BoxLayout(eingabeSpalte, BoxLayout.Y_AXIS));
        JLabel deineZahlLabel = new JLabel("Deine Zahl:");
        deineZahlLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        eingabeSpalte.add(deineZahlLabel);
        this.spielerZahlTextField = new JTextField(4);
        this.spielerZahlTextField.setHorizontalAlignment(JTextField.CENTER);
        this.spielerZahlTextField.setFont(spielerZahlTextField.getFont().deriveFont(36f));
        this.spielerZahlTextField.setMaximumSize(new Dimension(80, 60));
        this.spielerZahlTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        eingabeSpalte.add(spielerZahlTextField);

        JPanel computerSpalte = new JPanel();
        computerSpalte.setLayout(new BoxLayout(computerSpalte, BoxLayout.Y_AXIS));
        JLabel computerLabel = new JLabel("Computer:");
        computerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        computerSpalte.add(computerLabel);
        this.computerZahlTextField = new JTextField(4);
        this.computerZahlTextField.setHorizontalAlignment(JTextField.CENTER);
        this.computerZahlTextField.setFont(computerZahlTextField.getFont().deriveFont(36f));
        this.computerZahlTextField.setMaximumSize(new Dimension(80, 60));
        this.computerZahlTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        computerZahlTextField.setEditable(false);
        computerSpalte.add(computerZahlTextField);

        JPanel felderReihe = new JPanel();
        felderReihe.add(eingabeSpalte);
        felderReihe.add(computerSpalte);
        unten.add(felderReihe, BorderLayout.NORTH);

        nochMalButton = new JButton("Noch einmal!");
        JPanel buttonReihe = new JPanel();
        buttonReihe.add(nochMalButton);
        unten.add(buttonReihe, BorderLayout.CENTER);

        add(unten, BorderLayout.CENTER);

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