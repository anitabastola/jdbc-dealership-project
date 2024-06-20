package com.yearup.dealership.db;

import com.yearup.dealership.models.LeaseContract;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LeaseDao {
    private DataSource dataSource;

    public LeaseDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addLeaseContract(LeaseContract leaseContract) {
        // TODO: Implement the logic to add a lease contract
        String query = "INSERT INTO lease_contract VALUES (?, ?, ?, ?, ?);";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, leaseContract.getContractId());
            statement.setString(2, leaseContract.getVin());
            statement.setObject(3, leaseContract.getLeaseStart());
            statement.setObject(4, leaseContract.getLeaseEnd());
            statement.setDouble(5, leaseContract.getMonthlyPayment());

            statement.executeUpdate();
            System.out.println("Lease Contracted recorded! Row(s) updates " );

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}