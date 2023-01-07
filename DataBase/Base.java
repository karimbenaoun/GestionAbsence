
package DataBase;

import java.sql.*;

public class Base {

    private Connection conn;

    public Base() {
    }

    // public void connect() {
    //     try {
    //         Class.forName("com.mysql.jdbc.Driver");
    //     } catch (ClassNotFoundException e1) {
    //         e1.printStackTrace();
    //     }
    //     String ur1 = "jdbc:mysql://localhost:3306/gestion_absence";
    //     String username = "root";
    //     String password = "";
    //     try {
    //         this.conn = DriverManager.getConnection(ur1, username, password);
    //         Statement state = this.conn.createStatement();
            
    //         System.out.println("Connection avec succées ");
    //     } catch (SQLException e) {
    //         System.out.println("connection failed ");
    //         System.out.println(e.toString());
    //     }
    // }

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

    private void connect() {
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