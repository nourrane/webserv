package com.uca.dao;


import com.uca.entity.GomEntity;

import java.sql.*;
import java.util.ArrayList;

public class GomDAO extends _Generic<GomEntity> {

    public GomEntity getOneGom(String id){
        GomEntity entity = new GomEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM goms WHERE id=?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                entity.setId(resultSet.getInt("id"));
                entity.setDescription(resultSet.getString("description"));
                entity.setColor(resultSet.getString("color"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity; 
    }
    
    public ArrayList<GomEntity> getAllGoms() {
        ArrayList<GomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM goms ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                GomEntity entity = new GomEntity();
                entity.setId(resultSet.getInt("id"));
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
            statement = connection.prepareStatement("INSERT INTO Goms(description, color) VALUES(?, ?);");
            statement.setString(1, obj.getDescription());
            statement.setString(2, obj.getColor());
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

    public GomEntity modify(String id, String d, String c) {
        
        GomEntity entity = new GomEntity();
        
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE Goms SET description =?, color=? WHERE id =?;");
            preparedStatement.setString(1,d);
            preparedStatement.setString(2,c);
            preparedStatement.setString(3,id);
            preparedStatement.executeUpdate(); 

            entity.setId(Integer.parseInt(id));
            entity.setDescription(d);
            entity.setColor(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }
}