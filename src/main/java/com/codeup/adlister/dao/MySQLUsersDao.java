package com.codeup.adlister.dao;

import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection;

    public MySQLUsersDao(Config config) {
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
    public User findByUsername(String username) {
        String query = "SELECT * FROM users WHERE username = ? LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            return extractUser(stmt.executeQuery());
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        String query = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }

    @Override
    public String hashPassword(String password) {
        int numberOfRounds = 12;
        return BCrypt.hashpw(password, BCrypt.gensalt(numberOfRounds));
    }

    @Override
    public void changeEmail(String emailUpdate, String username) {
        String query = "UPDATE users SET email =? WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, emailUpdate);
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating email.", e);
        }
    }

    @Override
    public void changePassword(String password, String username) {
        String query = "UPDATE users SET password =? WHERE username = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, hashPassword(password));
            stmt.setString(2, username);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error updating password.", e);
        }
    }

    @Override
    public List<User> all() {
        String query = "SELECT * FROM users";

        try {
            Statement stmt = connection.createStatement();
            ResultSet usersRs = stmt.executeQuery(query);
            List<User> users = new ArrayList<>();

            while(usersRs.next()) {

                long id = usersRs.getLong("id");
                String name = usersRs.getString("name");
                String email = usersRs.getString("email");
                String password = usersRs.getString("password");


                User user = new User(id, name, email, password);

                users.add(user);

            }

            return users;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error getting all users");
        }    }

    @Override
    public User find(String column, String value) {

        // attempt to validate proper column values and keep them variable
        String columnValue;
        if (column.equals("username") || column.equals("id") || column.equals("email")) {
            columnValue = column;
        } else {
            throw new RuntimeException("Invalid column name!");
        }

        String query = "SELECT * FROM users WHERE " + columnValue + " = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, value);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                long user_id = rs.getLong("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");


                return new User(user_id, username, email, password);

            } else {
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error finding user");
        }

    }


    private User extractUser(ResultSet rs) throws SQLException {
        if (! rs.next()) {
            return null;
        }
        return new User(
            rs.getLong("id"),
            rs.getString("username"),
            rs.getString("email"),
            rs.getString("password")
        );
    }

}
