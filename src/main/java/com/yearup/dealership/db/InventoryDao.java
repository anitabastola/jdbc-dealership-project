package com.yearup.dealership.db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InventoryDao {
    private DataSource dataSource;

    public InventoryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addVehicleToInventory(String vin, int dealershipId) {
        // TODO: Implement the logic to add a vehicle to the inventory
        String query = "INSERT INTO inventory VALUES (?,?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)){

            preparedStatement.setString(1,vin);
            preparedStatement.setInt(2, dealershipId);

            preparedStatement.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void removeVehicleFromInventory(String vin) {
        // TODO: Implement the logic to remove a vehicle from the inventory

        String sql = "DELETE FROM inventory WHEN VIN = ?";


        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,vin);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



