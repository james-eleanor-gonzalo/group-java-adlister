package com.codeup.adlister.dao;
import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.Ad;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(

                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM ads");

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
 categories
            String insertQuery = "INSERT INTO ads(user_id, title, description, price) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());

            stmt.setDouble(4, ad.getPrice());

        

            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    @Override
    public Ad individualAd(long adID) {
        String query = "SELECT * FROM ads WHERE id = ?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setLong(1, adID);
            ResultSet rs = pst.executeQuery();
            rs.next();
            return extractAd(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving specific add", e);
        }
    }

    @Override
    public List<Ad> searchedAds(String searchInput, String searchCat) {
        System.out.println(searchInput);
        PreparedStatement pst = null;
        try {
            pst = connection.prepareStatement("SELECT * FROM ads WHERE ads.title LIKE CONCAT('%',?,'%') AND ads.category = ? ");
            pst.setString(1, searchInput );
            pst.setString(2, searchCat);
            ResultSet rs = pst.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding match.", e);
        }
    }

    @Override
    public void editTitle(String title, String adId) {
        String query = "UPDATE ads SET title = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, title);
            stmt.setString(2, String.valueOf(Integer.parseInt(adId)));
            stmt.executeUpdate();
    } catch (SQLException e){
          throw new RuntimeException("Error editing title.", e);
        }
    }

    @Override
    public void editDescription(String description, String adId) {
        String query = "UPDATE ads SET description = ? WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, description);
            stmt.setString(2, String.valueOf(Integer.parseInt(adId)));
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error editing description.", e);
        }
    }

    @Override
    public void deleteAd(String adId) {
        String query = "DELETE FROM ads WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, String.valueOf(Integer.parseInt(adId)));
            stmt.executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException("Error deleting ad.", e);
        }
    }

    @Override
    public Ad findById(long id) {

        String query = "SELECT a.*, u.*\n" +
                "FROM ads AS a\n" +
                "JOIN users AS u\n" +
                "ON a.user_id\n" +
                "WHERE a.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            rs.next();

            Ad ad = new Ad();
            ad.setId(rs.getLong("a.id"));
            ad.setTitle(rs.getString("a.title"));
            ad.setDescription(rs.getString("a.description"));
            ad.setUser(
                    new User(
                            rs.getString("u.id"),
                            rs.getString("u.name"),
                            rs.getString("u.email")
                    )
            );

            ad.setId(rs.getLong("id"));

            return ad;

        } catch (SQLException e) {
            throw new RuntimeException("Error finding by ID");
        }

    }

    private Ad buildAdObject(ResultSet rs) throws SQLException {
        Ad ad = new Ad();
        ad.setId(rs.getLong("a.id"));
        ad.setTitle(rs.getString("a.title"));
        ad.setDescription(rs.getString("a.description"));
        return ad;
    }

    @Override
    public List<Ad> getAdsByUser(long user_id) {
        String query = "SELECT a.*, u.*\n" +
                "FROM ads AS a\n" +
                "JOIN users AS u\n" +
                "ON a.user_id = u.id\n" +
                "WHERE user_id = ?";
        List<Ad> ads = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, user_id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ads.add(buildAdObject(rs));
            }

            return ads;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error with retrieving all ads");
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
            rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("description"),
            rs.getDouble("price")

        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
}
