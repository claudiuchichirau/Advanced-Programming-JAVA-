package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
public class Main {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DBManager.getInstance().getConnection();

            ArtistDAO artistDAO = new ArtistDAO(connection);

            List<Artist> artists = artistDAO.select();

            System.out.println("All artists (BEFORE INSERTION) :");
            for (Artist artist : artists) {
                System.out.println("\t" + artist);
            }

            Artist queen = new Artist(4, "Queen");
            artistDAO.insert(queen);

            artists = artistDAO.select();

            System.out.println("\nAll artists (AFTER INSERTION) :");
            for (Artist artist : artists) {
                System.out.println("\t" + artist);
            }

            artistDAO.delete(4);

            artists = artistDAO.select();

            System.out.println("\nAll artists (AFTER DELETION) :");
            for (Artist artist : artists) {
                System.out.println("\t" + artist);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}