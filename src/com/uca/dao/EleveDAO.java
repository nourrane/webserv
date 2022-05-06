package com.uca.dao;

import com.uca.entity.EleveEntity;
import java.sql.*;
import java.util.ArrayList;

public class EleveDAO extends _Generic<EleveEntity> {

    public EleveEntity getOneEleve(String id){
        EleveEntity entity = new EleveEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleves WHERE id=?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstName"));
                entity.setLastName(resultSet.getString("lastName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity; 
    }
    public ArrayList<EleveEntity> getAllEleves() {
        ArrayList<EleveEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleves ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveEntity entity = new EleveEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setFirstName(resultSet.getString("firstName"));
                entity.setLastName(resultSet.getString("lastName"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public EleveEntity create(EleveEntity obj) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO eleves(firstName, lastName) VALUES(?, ?);");
            statement.setString(1, obj.getFirstName());
            statement.setString(2, obj.getLastName());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
        return obj;
    }

    @Override
    public void delete(EleveEntity obj) {
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM eleves WHERE id=?;");
            statement.setString(1,""+obj.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not delete the eleve!");
        }
    }

    public EleveEntity modify(String id, String f, String l) {
        
        EleveEntity entity = new EleveEntity();
        
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("UPDATE eleves SET firstName =?, lastName =? WHERE id =?;");
            preparedStatement.setString(1,f);
            preparedStatement.setString(2,l);
            preparedStatement.setString(3,id);
            preparedStatement.executeUpdate(); 

            entity.setId(Integer.parseInt(id));
            entity.setFirstName(f);
            entity.setLastName(l);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }
}