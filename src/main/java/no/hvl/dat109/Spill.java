package no.hvl.dat109;

/**
 * @Author Elias Frette
 * @Author Edvar Motrøen
 * @Author Jonas glambek
 * @Author Fredrik Furustør
 * @Author Domas Gostautas
 * @Author Gabriel Hugaas 
 * */

import no.hvl.dat109.interfaces.SpillInterface;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static no.hvl.dat109.Terning.trill;

public class Spill extends JPanel implements SpillInterface {
    // private Brett brett;
    private final int antallSpillerer;
    private boolean vunnet = false;
    private int vinner;
    private Brikke[] brikker;
    private int currentPlayer = 0;
    private final Map<Integer, Integer> snake = new HashMap<>();
    private final Map<Integer, Integer> ladder = new HashMap<>();

    final int tileSize = 80;
    public final int maxScreenCol = 10;
    public final int maxScreenRow = 10;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    public Spill(int antallSpillerer) throws Exception {
        this.antallSpillerer = antallSpillerer;
        if (antallSpillerer < 2 || antallSpillerer > 4) throw new IllegalArgumentException();
        startSpill();
    }

    private void startSpill() {
        brikker = new Brikke[antallSpillerer];
        for (int i = 0; i < antallSpillerer; i++) {
            brikker[i] = new Brikke(1, i + 1);
        }
    }

    public Brikke[] getBrikker() {
        return brikker;
    }

    public void rullTerning() {
        int sum = trill();
        Brikke b = brikker[currentPlayer];

        while (sum == 6) {
            int kastetTreGangerPaaRaad = sum;
            sum = trill();
            kastetTreGangerPaaRaad = kastetTreGangerPaaRaad + sum;
            System.out.println("Brikke " + b.getBrikkeId() + " kastet 6 og må kaste på nytt");
            if (kastetTreGangerPaaRaad == 18) {
                b.setPosisjon(1);
                System.out.println("Brikke " + b.getBrikkeId()
                        + " kastet 6 tre ganger på rad og må flytte til start");
                sum = 0;
            }
        }
        int nyPos = b.getPosisjon() + sum;
        if (nyPos < 100) {
            b.setPosisjon(nyPos);
            System.out.println("Brikke " + b.getBrikkeId() + " Rullet " + sum +
                    " og flytter til rute " + b.getPosisjon());

            //Klatre stigen ?
            if (ladder.get(nyPos) != null) {
                b.setPosisjon(ladder.get(nyPos));
                return;
            }
            //Falle ned slangen ??
            if(snake.get(nyPos) != null) {
                b.setPosisjon(snake.get(nyPos));
                return;
            }
        }
        if (nyPos == 100) {
            b.setPosisjon(nyPos);
            System.out.println("Brikke " + b.getBrikkeId() + " vant spillet");
            vunnet = true;
            vinner = b.getBrikkeId();
        }
        if (nyPos > 100) {
            System.out.println("Brikke " + b.getBrikkeId() + " kastet " + sum +
                    " og kastet over 100, brikke " + b.getBrikkeId() + " blir stående");
        }

        currentPlayer = getCurrentPlayer();

    }

    public void setSlangerOgStiger(int[][] slangeTabell, int[][] stigeTabell) {
        snake.clear();
        ladder.clear();

        for(int[] slange : slangeTabell) {
            snake.put(slange[0], slange[1]);
        }
        for(int[] stige : stigeTabell) {
            ladder.put(stige[0], stige[1]);
        }

    }

    public int getCurrentPlayer() {
        return (currentPlayer+1)%brikker.length;
    }

    public boolean getVunnet() {
        return vunnet;
    }
    public int getVinner() {
        return vinner;
    }

    /**
     * @Throw IllegalArgumentException hvis antallSpillerer er mindre enn 2 eller større enn 4
     * */
    @Override
    public void spill() {
        }

//        Brikke[] brikker = new Brikke[antallSpillerer];
//        for (int x = 0; x < antallSpillerer; x++) {
//            brikker[x] = new Brikke(0, x + 1);
//        }


//        Scanner scanner = new Scanner(System.in);
//
//        while (!vunnet) {
//
//            for (int i = 0; i < antallSpillerer && !vunnet; i++) {
//
//                System.out.println("Brikke nr: " + brikker[i].getBrikkeId()
//                        + " sin tur. Trykk Enter for å fortsette..");
//                scanner.nextLine();
//
//                int sum = Terning.trill();
//
//                if (brikker[i].getPosisjon() + sum < 100) {
//                    brikker[i].setPosisjon(brikker[i].getPosisjon() + sum);
//                    System.out.println(brikker[i].getBrikkeId() + " er på rute "
//                            + brikker[i].getPosisjon() + " og fikk terningkast: " + sum);
//
//                } else if (brikker[i].getPosisjon() + sum == 100) {
//                    System.out.println("Brikke: " + brikker[i].getBrikkeId() + " Har vunnet!");
//                    vunnet = true;
//                } else {
//                    System.out.println(brikker[i].getBrikkeId() + " fikk for mye!");
//                }
//                sum = 0;
//            }
//
//        }
//        scanner.close();
    }
