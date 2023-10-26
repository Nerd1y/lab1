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
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("idClients");
                String name = resultSet.getString("name");
                int idrooms = resultSet.getInt("idrooms");
                System.out.println("ID: " + id + ", Name: " + name + ", IDRooms: " + idrooms);
                int room_number = resultSet.getInt("room_number");
                String room_type = resultSet.getString("room_type");
                int room_price = resultSet.getInt("room_price");
                System.out.println("Room Number: " + room_number + ", Room Type: " + room_type + ", Room Price: " + room_price);
            }
            if (!connection.isClosed()) {
                System.out.println("Connection established.");
            }
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}