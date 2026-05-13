package rvt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
   
   public static void main(String[] args) {


        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        UserInterface ui = new UserInterface(todoList, scanner);

        ui.start();

        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:todo.db");

            Statement stmt = conn.createStatement();

            stmt.executeUpdate(
                "CREATE TABLE IF NOT EXISTS todo " +
                "(id INTEGER PRIMARY KEY, task TEXT) STRICT"
            );

            stmt.executeUpdate(
                "INSERT INTO todo (task) VALUES ('Make a dance!')"
            );

            stmt.close();
            conn.close();

            System.out.println("Database updated successfully!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
