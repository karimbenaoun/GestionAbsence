
package DataBase;

import java.sql.*;

public class Base {

    private Connection conn;

    public void connect() {

        String ur1 = "jdbc:mysql://localhost:3306/absence";
        String username = "root";
        String password = "";
        try {
            this.conn = DriverManager.getConnection(ur1, username, password);
            System.out.println("Connection avec succées ");
        } catch (SQLException e) {
            System.out.println("connection failed ");
            System.out.println(e.toString());
        }
    }

    public void close() {
        try {
            this.conn.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public Connection getConnection() {
        return this.conn;
    }

    public PreparedStatement preparedStatement(String SQLQuerry) {
        try {
            return this.conn.prepareStatement(SQLQuerry);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return null;
    }

    public void updateQuerry(String SQLQuerry) {
        this.connect();
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate(SQLQuerry);
            System.out.println("requette avet succe");
        } catch (Exception e) {
            System.out.println(e.toString());
            System.out.println("requette failed");
        }
    }

    public ResultSet useStatament(String SQLQuuerry) {
        this.connect();
        try {
            Statement stmt = this.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQLQuuerry);
            return rs;
        } catch (SQLException e) {
            System.out.print("requette filed : ");
            System.out.println(e.toString());
        }
        return null;
    }

}