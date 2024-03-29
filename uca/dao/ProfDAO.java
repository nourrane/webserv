package com.uca.dao;

import com.uca.entity.ProfEntity;

import java.sql.*;
import java.util.ArrayList;

public class ProfDAO extends _Generic<ProfEntity> {

    public Boolean IsInTable(String id){
        ArrayList<String> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT id FROM professeurs;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entities.add(resultSet.getString("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities.contains(id);
    }

    public ProfEntity getOneProf(String id){
        ProfEntity entity = new ProfEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM professeurs WHERE id=?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));
                entity.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity; 
    }

    public ArrayList<ProfEntity> getAllProfs() {
        ArrayList<ProfEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT id, firstname, lastname FROM professeurs ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProfEntity entity = new ProfEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstname"));
                entity.setLastName(resultSet.getString("lastname"));

                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public ProfEntity create(ProfEntity obj) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO professeurs(firstname, lastname, password) VALUES(?, ?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.setString(3, obj.getPassword());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
        return obj;
    }

    @Override
    public void delete(ProfEntity obj) {
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM professeurs WHERE id=?;");
            statement.setString(1,""+obj.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not delete the professor!");
        }
    }
}