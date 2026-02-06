package no.hvl.dat109;

import javax.swing.*;
import java.awt.*;

public class StartSide extends JPanel {

    public StartSide(JFrame frame) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);

        JLabel label = new JLabel("Antall spillere (2–4):");
        JTextField input = new JTextField("2", 5);
        JButton startButton = new JButton("Start spill");

        gbc.gridx = 0; gbc.gridy = 0;
        add(label, gbc);

        gbc.gridx = 1;
        add(input, gbc);

        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 5; gbc.gridheight = 3;
        add(startButton, gbc);

        startButton.addActionListener(e -> {


            int antall;
            try {
                antall = Integer.parseInt(input.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Skriv ett heltall",
                        "Feil",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

                if (antall < 2 || antall > 4) {
                    JOptionPane.showMessageDialog(
                            this,
                            "Skriv inn ett heltall mellom 2-4",
                            "Feil",
                            JOptionPane.ERROR_MESSAGE);
                    return;
            }

            try{
                BrettRepo brettRepo = new BrettRepo();
                Spill spill = new Spill(antall);
                spill.setSlangerOgStiger(brettRepo.getSlange(), brettRepo.getStige());
                Brett brett = new Brett(spill, brettRepo.getSlange(), brettRepo.getStige());

                JPanel gamerWindow = new JPanel(new BorderLayout());
                gamerWindow.add(brett, BorderLayout.CENTER);

                JButton rollButton = new JButton("Rull terning");
                rollButton.addActionListener(ev -> {
                    spill.rullTerning();
                    brett.repaint();
                    if(spill.getVunnet()) {
                        JOptionPane.showMessageDialog(
                                this,
                                "Brikke nr " + spill.getVinner() + " har vunnet spillet",
                                "Spillet er ferdig",
                                JOptionPane.INFORMATION_MESSAGE
                        );

                        frame.setContentPane(new StartSide(frame));
                        frame.pack();
                        frame.setLocationRelativeTo(null);
                    }
                });

                gamerWindow.add(rollButton, BorderLayout.SOUTH);

                frame.setContentPane(gamerWindow);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.revalidate();
                frame.repaint();

            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(
                        this,
                        "Klarte ikke starte spillet",
                        "Feilkode",
                        JOptionPane.ERROR_MESSAGE
                );
            };
        });
    }
}

