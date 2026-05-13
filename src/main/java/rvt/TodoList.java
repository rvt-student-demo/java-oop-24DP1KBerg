package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TodoList {

    private String url;

    public TodoList() {
        this.url = "jdbc:sqlite:todo.db";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS todo (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "task TEXT NOT NULL)"
            );

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void add(String task) {

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "INSERT INTO todo(task) VALUES ('" + task + "')"
            );

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void print() {

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM todo"
            );

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + ": " +
                    rs.getString("task")
                );
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void remove(int id) {

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "DELETE FROM todo WHERE id = " + id
            );

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}