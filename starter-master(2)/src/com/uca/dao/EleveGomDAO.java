package com.uca.dao;

import com.uca.entity.EleveGomEntity;
import com.uca.entity.GomEntity;
import com.uca.entity.EleveEntity;
import java.sql.*;
import java.util.ArrayList;

public class EleveGomDAO extends _Generic<EleveGomEntity> {

    public ArrayList<EleveGomEntity> getAllElevesGom() {
        ArrayList<EleveGomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleveGom ORDER BY id ASC;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveGomEntity entity = new EleveGomEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setIdEleve(resultSet.getInt("idEleve"));
                entity.setIdGommette(resultSet.getInt("idGom"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entities;
    }

    @Override
    public EleveGomEntity create(EleveGomEntity obj) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO eleveGom(idEleve, eleveFirstName, idGom) VALUES(?, ?, ?);");
            statement.setInt(1, obj.getEleve().getId());
            statement.setString(2, obj.getEleve().getFirstName());
            statement.setInt(3, obj.getGommette().getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not create the event !");
        }
        return obj;
        
    }

    @Override
    public void delete(EleveGomEntity obj) {
        
        Connection connection = _Connector.getInstance();
        
        try {
            PreparedStatement statement;
            statement = connection.prepareStatement("DELETE FROM eleveGom WHERE id=?;");
            statement.setString(1,""+obj.getId());
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.toString());
            throw new RuntimeException("could not delete the event!");
        }
        
    }
}