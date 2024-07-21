package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    static Connection conn = null;
//    static String sql1 = "INSERT INTO customer3 (id,name,course,location) VALUES(?,?,?,?);";
    static String url = "jdbc:sqlite:C:/SQLite DB/SQLite GUI/Customer.db";

    static String sql0 = "CREATE TABLE IF NOT EXISTS customer3 ("
            + "	id INTEGER,"
            + "	name varchar,"
            + "	course varchar,"
            + "	location varchar"
            + ");";

    static String sql2 = "SELECT * FROM customer3;";

    public static void main(String[] args) throws SQLException {
        connect();
        conn = DriverManager.getConnection(url);

        //create database
        var meta = conn.getMetaData();
        System.out.println("The driver name is " + meta.getDriverName());
        System.out.println("A new database has been created.");

        //create tabel
        var stmt0 = conn.createStatement();
        stmt0.execute(sql0);


        //Insert Value
//        var stmt1 = conn.prepareStatement(sql1);
//        var name = new String[]{"Sourabh"};
//        var course = new String[]{"Selenium"};
//        var id = new int[]{55};
//        var location = new String[]{"Asia"};
//        stmt1.setInt(1, id[0]);
//        stmt1.setString(2, name[0]);
//        stmt1.setString(3, course[0]);
//        stmt1.setString(4, location[0]);
//        stmt1.executeUpdate();

        //Retrive from tabel
        var stmt2 = conn.createStatement();
        var rs = stmt2.executeQuery(sql2);

        while (rs.next()) {
            System.out.printf("%-5s%-10s%-10s%-10s%n",
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("course"),
                    rs.getString("location")
            );
        }
    }

    public static void connect() {

        try {

            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
