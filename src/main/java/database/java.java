package database;

import java.sql.*;

public class java {
    private final static String URL = "jdbc:mysql://localhost:3306/laba1";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection;
        String query = "SELECT * FROM clients, rooms WHERE clients.idClients = rooms.idrooms";
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);;
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int idrooms = resultSet.getInt(3);
                System.out.println("ID: " + id + ", Name: " + name + ", IDRooms: " + idrooms);
                int room_number = resultSet.getInt(5);
                String room_type = resultSet.getString(6);
                int room_price = resultSet.getInt(7);
                System.out.println("Room Number: " + room_number + ", Room Type: " + room_type + ", Room Price: " + room_price);
            }
            if (!connection.isClosed()) {
                System.out.println("Soed est'");
            }
        } catch (SQLException e) {
              System.out.println("Net soed");
        }
    }
}
