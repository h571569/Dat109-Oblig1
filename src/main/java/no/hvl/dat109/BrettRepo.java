package no.hvl.dat109;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BrettRepo {

    private int[][] slange;
    private int[][] stige;

    public BrettRepo() throws Exception {
        Properties props = new Properties();
        try (var is = getClass().getResourceAsStream("/application.properties")) {
            if (is == null) throw new RuntimeException("Fant ikke application.properties");
            props.load(is);
        }

        String url  = props.getProperty("db.url");
        String user = props.getProperty("db.username");
        String pass = props.getProperty("db.password");

        try (Connection con = DriverManager.getConnection(url, user, pass)) {

            slange = hentTabell(con, "stigespill.slange");
            stige  = hentTabell(con, "stigespill.stige");
            con.close();
        }
    }

    private int[][] hentTabell(Connection con, String tabell) throws Exception {

        List<int[]> liste = new ArrayList<>();

        String sql = "SELECT fra, til FROM " + tabell;
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            liste.add(new int[] {
                    rs.getInt("fra"),
                    rs.getInt("til")
            });
        }

        rs.close();
        stmt.close();

        return liste.toArray(new int[0][0]);
    }

    public int[][] getSlange() {
        return slange;
    }
    public int[][] getStige() {
        return stige;
    }
}
