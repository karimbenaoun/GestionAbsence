
package DataBase;

import java.sql.*;

public class Base {

    private Connection conn;

    public Base() {
    }

    public Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
        String ur1 = "jdbc:mysql://localhost:3306/gestion_ab";
        String DBusername = "root";
        String password = "";
        try {
            this.conn = DriverManager.getConnection(ur1, DBusername, password);
            Statement state = this.conn.createStatement();

            System.out.println("Connection avec succées ");
        } catch (SQLException e) {
            System.out.println("connection failed ");
            System.out.println(e.toString());
        }
        return conn;
    }

    public ResultSet useStatament(String SQLQuuerry) {
        this.conn = this.connect();
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