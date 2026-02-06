package no.hvl.dat109;

import javax.swing.*;
import java.awt.*;

import static no.hvl.dat109.Terning.trill;

/**
 * @Author Elias Frette
 * @Author Edvar Motrøen
 * */

public class Main {
    public static void main(String[] args) throws Exception {

        /**
         * @Param Antall spillere som skal være med i spillet
         * */
//        Spill s1 = new Spill(3);
//        s1.spill();

        JFrame window = new JFrame("Stige- Og Slangespill");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);


        window.setContentPane(new StartSide(window));
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}