package com.uca.dao;

import com.uca.entity.ProfEntity;
import com.uca.core.ProfCore;
import java.sql.*;
import java.util.ArrayList;
import java.sql.Connection;


    

public class LoginDAO{
    public Connection connect = _Connector.getInstance();

    public ProfEntity getConnectedProf() {
        ProfEntity entity=new ProfEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM login;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
            entity.setId(resultSet.getInt("id"));
            entity.setFirstName(resultSet.getString("firstname"));
            entity.setLastName(resultSet.getString("lastname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }
    // pas fini
    
    
    public void setConnectedProf(String id) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            //on vide la table
            statement = connection.prepareStatement("TRUNCATE TABLE login");
            statement.executeUpdate();
            //on met le nouveau prof
            ProfCore p=new ProfCore();
            ProfEntity obj= p.getOneProf(id);
            statement = connection.prepareStatement("INSERT INTO login(id, firstname, lastname) VALUES(?, ?, ?);");
            statement.setString(1, ""+obj.getId());
            statement.setString(2, obj.getFirstName());
            statement.setString(3, obj.getLastName());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
    }


    }
}
