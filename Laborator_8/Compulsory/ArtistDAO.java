package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArtistDAO {
    private Connection connection;

    public ArtistDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Artist> select() throws SQLException {
        String query = "SELECT * FROM artists";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        List<Artist> artists = new ArrayList<>();
        while (resultSet.next()) {
            Artist artist = new Artist();
            artist.setId(resultSet.getInt("id"));
            artist.setName(resultSet.getString("name"));
            artists.add(artist);
        }

        return artists;
    }


    public void insert(Artist artist) throws SQLException {
        String query = "INSERT INTO artists (id, name) VALUES (?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, artist.getId());
        statement.setString(2, artist.getName());
        statement.executeUpdate();

//        // commit the transaction
//        connection.commit();
    }

    public void update(Artist artist) throws SQLException {
        String query = "UPDATE artists SET name = ? WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, artist.getName());
        statement.setInt(2, artist.getId());
        statement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM artists WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        statement.executeUpdate();
    }

//    public Artist findById(int id) throws SQLException {
//        String query = "SELECT * FROM artists WHERE id = ?";
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setInt(1, id);
//        ResultSet resultSet = statement.executeQuery();
//
//        if (resultSet.next()) {
//            Artist artist = new Artist();
//            artist.setId(resultSet.getInt("id"));
//            artist.setName(resultSet.getString("name"));
//            return artist;
//        }
//
//        return null;
//    }
}









//
//public class ArtistDAO {
//    private DBManager Database;
//    public void create(String name) throws SQLException {
//        Connection con = Database.getConnection();
//        try (PreparedStatement pstmt = con.prepareStatement(
//                "insert into artists (name) values (?)")) {
//            pstmt.setString(1, name);
//            pstmt.executeUpdate();
//        }
//    }
//    public Integer findByName(String name) throws SQLException {
//        Connection con = Database.getConnection();
//        try (Statement stmt = con.createStatement();
//             ResultSet rs = stmt.executeQuery(
//                     "select id from artists where name='" + name + "'")) {
//            return rs.next() ? rs.getInt(1) : null;
//        }
//    }
////    public String findById(int id) throws SQLException {
////        TODO
////    }
//}
//
////public class ArtistDAO {
////    private Connection connection;
////
////    public ArtistDAO() throws SQLException {
////        connection = DBManager.getInstance().getConnection();
////    }
////
////    public void addArtist(Artist artist) throws SQLException {
////        String sql = "INSERT INTO artists (id, name) VALUES (?, ?)";
////        try (PreparedStatement statement = connection.prepareStatement(sql)) {
////            statement.setInt(1, artist.getId());
////            statement.setString(2, artist.getName());
////            statement.executeUpdate();
////        }
////    }
////
////    public List<Artist> getAllArtists() throws SQLException {
////        List<Artist> artists = new ArrayList<>();
////        String sql = "SELECT * FROM artists";
////        try (Statement statement = connection.createStatement()) {
////            ResultSet result = statement.executeQuery(sql);
////            while (result.next()) {
////                int id = result.getInt("id");
////                String name = result.getString("name");
////                Artist artist = new Artist(id, name);
////                artists.add(artist);
////            }
////        }
////        return artists;
////    }
////
////
////}