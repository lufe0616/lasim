package gui;

import calc.Drehstrommotor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LasimFrame extends JFrame {

    private int WIDTH = 1000;
    private int HEIGHT = 800;
    private int PADDING = 25;

    public LasimFrame(Drehstrommotor motor) {
        super("Agil Drive GUI");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setResizable(false);

        setLayout(null);

        // ---- HEADING ----
        JPanel headingPanel = new JPanel();
        headingPanel.setBounds(0,0,WIDTH, 50);
        headingPanel.setBackground(Color.LIGHT_GRAY);
        headingPanel.setLayout(new GridLayout(1,1));
        JLabel heading = new JLabel();
        heading.setText("Lastsimulation anhand eines SEW-Drehstromgetriebemotors");
        heading.setBounds(0,0,WIDTH, 60);
        heading.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        headingPanel.add(heading);
        add(headingPanel);


        // ---- MOTOR DATEN PANEL ----
        JPanel motorDaten = new JPanel(new GridLayout(4,2));
        motorDaten.setBounds(PADDING,60, 350, 200);
        motorDaten.setVisible(true);
        motorDaten.setBorder(new TitledBorder("Nennwerte laut Leistungsschild"));

        JLabel pAuf = new JLabel("Leistungsaufnahme in kW:");
        motorDaten.add(pAuf);
        JLabel pAufWert = new JLabel(String.format("%.4f", motor.getPAuf()/1000));
        motorDaten.add(pAufWert);

        JLabel pAb = new JLabel("Leistungsabgabe in kW:");
        motorDaten.add(pAb);
        JLabel pAbWert = new JLabel(String.format("%.4f", motor.getPAb()));
        motorDaten.add(pAbWert);

        JLabel pVer = new JLabel("Verlustleistung in kW:");
        motorDaten.add(pVer);
        JLabel pVerWert = new JLabel(String.format("%.4f", (motor.getPAuf()/1000) - motor.getPAb()));
        motorDaten.add(pVerWert);

        JLabel wGrad = new JLabel("Wirkungsgrad in Prozent:");
        motorDaten.add(wGrad);
        JLabel wGradWert = new JLabel(String.format("%.4f", (motor.getPAb() / (motor.getPAuf()/1000))*100));
        motorDaten.add(wGradWert);

        add(motorDaten);


        // ---- LASTENSIMULATION WERTE PANEL ----
        JPanel lastSimWerte = new JPanel(new GridLayout(3,1));
        lastSimWerte.setVisible(true);
        lastSimWerte.setBounds(PADDING, 300, 350, 150);
        lastSimWerte.setBorder(new TitledBorder("Lastsimulation Werte"));

        JLabel lastSimInfo = new JLabel(String.format("Nennwert: %.1f Nm (%.1f Nm bis %.1f Nm):", motor.getDrehmoment(), 1.0, motor.getDrehmoment()+1));
        lastSimWerte.add(lastSimInfo);

        JTextField lastInput = new JTextField();
        lastSimWerte.add(lastInput);

        JCheckBox lastCheckBox = new JCheckBox("Drehzahl an Last anpassen (lt. Kennlinie)");
        lastSimWerte.add(lastCheckBox);

        add(lastSimWerte);


        // ---- AUSGABE PANEL ----
        JPanel ausgabe = new JPanel(new GridLayout(2, 2));
        ausgabe.setVisible(true);
        ausgabe.setBounds(PADDING, 490, 350, 150);
        ausgabe.setBorder(new TitledBorder("Ausgabe Strom und Drehzahl"));

        JLabel stromAusgabeLabel = new JLabel("Strom in Ampere:");
        ausgabe.add(stromAusgabeLabel);
        JLabel stromAusgabeWert = new JLabel();
        stromAusgabeWert.setText("-");
        ausgabe.add(stromAusgabeWert);

        JLabel drehzahlAusgabeLabel = new JLabel("Drehzahl bei Last:");
        ausgabe.add(drehzahlAusgabeLabel);
        JLabel drehzahlAusgabewert = new JLabel();
        drehzahlAusgabewert.setText("-");
        ausgabe.add(drehzahlAusgabewert);

        add(ausgabe);


        // ---- BERECHNEN BUTTON ----
        JButton calcButton = new JButton("Berechne benötigten Strom");
        calcButton.setVisible(true);
        calcButton.setBounds(PADDING, 680, 350, 50);
        calcButton.addActionListener(e -> {
            motor.setLast(Double.parseDouble(lastInput.getText().replace(',', '.')));
            stromAusgabeWert.setText(String.format("%.3f",motor.getStromstaerkeBeiLast()));
            if(lastCheckBox.isSelected()) {
                drehzahlAusgabewert.setText(String.format("%.3f",motor.getDrehzahlBeiLast()));
            } else {
                drehzahlAusgabewert.setText("-");
            }

        });
        add(calcButton);


        // ---- MOTOR BILD ----
        JLabel image = new JLabel(new ImageIcon("src/gui/sew-card.png"));
        image.setVisible(true);
        image.setBounds(400-40, 60-40, WIDTH - 400 - PADDING, 350);
        add(image);

        // ---- KENNLINIE ----
        ImageIcon i = new ImageIcon("src/gui/kennlinie.png");
        JLabel kennlinie = new JLabel(new ImageIcon(i.getImage().getScaledInstance(WIDTH - 400 - PADDING, 350, Image.SCALE_SMOOTH)));
        kennlinie.setVisible(true);
        kennlinie.setBounds(400, 410, WIDTH - 400 - PADDING, 350);
        add(kennlinie);

        setVisible(true);

    }

}

