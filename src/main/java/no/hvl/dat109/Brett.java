package no.hvl.dat109;

/**
 * @Author Edvar Motrøen
 * @Author Elias Frette
 * @
 * */

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.util.List;

public class Brett extends JPanel {

    private MapManager mapManager;
    private Spill spill;
    private int [][] slanger;
    private int [][] stiger;

    public Brett(Spill spill, int [][] slanger,int [][] stiger) throws Exception {
        this.spill = spill;
        this.slanger = slanger;
        this.stiger = stiger;

        setPreferredSize(new Dimension(spill.screenWidth, spill.screenHeight));
        mapManager = new MapManager(spill);
        this.setFocusable(true);
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        mapManager.draw(g2);
        drawLaddersAndSnakes(g2);
        drawBrikker(g2);
    }

    private void drawBrikker(Graphics2D g2) {

        Brikke[] brikker = spill.getBrikker();
        if (brikker == null) return;

        Color[] colors = { Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE };

        //Brikke størrelse
        int radius = 22;

        for (int i = 0; i < brikker.length; i++) {
            int pos = brikker[i].getPosisjon();
            Point point = posToPixel(pos, spill.tileSize);

            int xKordinat = (i % 2) * 35 + 6;
            int yKordinat = (i / 2) * 40 + 6;

            g2.setColor(colors[i % colors.length]);
            g2.fillOval(point.x + xKordinat, point.y + yKordinat, radius, radius);

            g2.setColor(Color.BLACK);
            g2.drawOval(point.x + xKordinat, point.y + yKordinat, radius, radius);
        }
    }

    private void drawLaddersAndSnakes(Graphics2D g2) {

        for (int[] stige : stiger) {
            int fra = stige[0];
            int til = stige[1];

            Point pointFra = posToPixel(fra, spill.tileSize);
            Point pointTil = posToPixel(til, spill.tileSize);
            g2.drawImage(mapManager.getTile(1), pointFra.x, pointFra.y,spill.tileSize, spill.tileSize, null);
            g2.drawImage(mapManager.getTile(2), pointTil.x, pointTil.y,spill.tileSize, spill.tileSize, null);

        }

        for (int[] slange : slanger) {
            int fra = slange[0];
            int til = slange[1];

            Point pointFra = posToPixel(fra, spill.tileSize);
            Point pointTil = posToPixel(til, spill.tileSize);
            g2.drawImage(mapManager.getTile(4), pointFra.x, pointFra.y,spill.tileSize, spill.tileSize, null);
            g2.drawImage(mapManager.getTile(3), pointTil.x, pointTil.y,spill.tileSize, spill.tileSize, null);

        }


    }

    private Point posToPixel(int pos, int tileSize) {
        if (pos < 1) pos = 1;
        if (pos > 100) pos = 100;

        int idx = pos - 1;
        int boardRow = idx / 10;
        int colInRow = idx % 10;

        int boardCol = (boardRow % 2 == 0) ? colInRow : (9 - colInRow);

        int screenRow = 9 - boardRow;
        int screenCol = boardCol;

        return new Point(screenCol * tileSize, screenRow * tileSize);
    }
}