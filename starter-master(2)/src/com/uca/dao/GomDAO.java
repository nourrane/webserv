package com.uca.dao;

import com.uca.entity.GomEntity;

import java.sql.*;
import java.util.ArrayList;

public class GomDAO extends _Generic<GomEntity> {

    public ArrayList<GomEntity> getAllGoms() {
        ArrayList<GomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM goms ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GomEntity entity = new GomEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setName(resultSet.getString("name"));
                entity.setDescription(resultSet.getString("description"));
                entity.setColor(resultSet.getString("color"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public GomEntity create(GomEntity obj) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Goms(name, description, color) VALUES(?, ?,?);");
            statement.setString(1, obj.getName());
            statement.setString(2, obj.getDescription());
            statement.setString(3, obj.getColor());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
        return obj;
    }

    @Override
    public void delete(GomEntity obj) {
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM Goms WHERE id=?;");
            statement.setString(1,""+obj.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not delete the Gom!");
        }
    }
}