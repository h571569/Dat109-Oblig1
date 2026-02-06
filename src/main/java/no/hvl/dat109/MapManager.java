package no.hvl.dat109;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MapManager {

    private BufferedImage[] tile = new BufferedImage[5];
    private int [][] mapTileNum = new int[10][10];
    Spill spill;
    public MapManager(Spill spill) {
        this.spill = spill;
        getTileImage();
    }

    public void draw(Graphics2D g2) {



        g2.setFont(new Font("SansSerif", Font.BOLD, 12));
        FontMetrics fm = g2.getFontMetrics();

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                int x = col * spill.tileSize;
                int y = row * spill.tileSize;
                g2.drawImage(tile[0], x, y, spill.tileSize, spill.tileSize, null);

                int boardRow = 9 - row;

                int boardCol = (boardRow % 2 == 0) ? col : (9 - col);

                int number = boardRow * 10 + boardCol + 1;

                String s = String.valueOf(number);
                int textW = fm.stringWidth(s);
                int ascent = fm.getAscent();

                int tx = x + (spill.tileSize - textW) / 2;
                int ty = y + (spill.tileSize + ascent) / 2 - fm.getDescent();

                g2.setColor(Color.BLACK);
                g2.drawString(s, tx, ty);
            }
        }

    }

    private void getTileImage() {

        try {
            tile[0] = load("/tiles/normalTile.png");
            tile[1] = load("/tiles/ladderBottom.png");
            tile[2] = load("/tiles/ladderTop.png");
            tile[3] = load("/tiles/snakeTail.png");
            tile[4] = load("/tiles/snakeHead.png");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public BufferedImage getTile(int tileNum) {
        return tile[tileNum];
    }

    private BufferedImage load(String path) throws IOException {
        var in = getClass().getResourceAsStream(path);
        if (in == null) {
            throw new IllegalArgumentException("Fant ikke resource: " + path);
        }
        return ImageIO.read(in);
    }
}
