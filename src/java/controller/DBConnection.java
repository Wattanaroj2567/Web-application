/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author NITRO V 15
 */
import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import model.Product;

public class DBConnection {

    public boolean insertNewProduct(Product product) {
        boolean result = false;
        Connection connection = null;
        try {
            // below two lines are used for connectivity.
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ubumarketcenter",
                    "root", "Tawan_987654321");

            Statement statement;
            statement = connection.createStatement();

            String query = "INSERT INTO product "
                    + "(name, type, quantity, price) "
                    + "VALUES('"
                    + product.getName() + "','"
                    + product.getType() + "','"
                    + product.getQuantity() + "',"
                    + product.getPrice() + ")";
            System.out.println("........SQL: " + query);

            int i = statement.executeUpdate(query);	// executeUpdate returns row count ****
            if (i != 0) {
                result = true;
            }
            statement.close();
            connection.close();
        } catch (Exception exception) {
            System.out.println(exception);
        }

        return result;

    }
}


