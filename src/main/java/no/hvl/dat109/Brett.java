package no.hvl.dat109;

/**
 * @Author Edvar Motrøen
 * @Author Elias Frette
 * @
 * */

import java.sql.*;
import java.util.*;
import java.io.*;

public class Brett {

    private int[][] slange;
    private int[][] stige;

    public Brett() throws Exception {

        Properties props = new Properties();
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("application.properties");

        if (is == null) {
            throw new FileNotFoundException("Fant ikke application.properties på classpath");
        }

        props.load(is);

        String url  = props.getProperty("spring.datasource.url");
        String user = props.getProperty("spring.datasource.username");
        String pass = props.getProperty("spring.datasource.password");

        Connection con = DriverManager.getConnection(url, user, pass);

        slange = hentTabell(con, "stigespill.slange");
        stige  = hentTabell(con, "stigespill.stige");

        con.close();
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
}