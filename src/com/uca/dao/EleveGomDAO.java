package com.uca.dao;

import com.uca.entity.EleveGomEntity;
import com.uca.entity.GomEntity;
import com.uca.entity.EleveEntity;
import java.sql.*;
import java.util.ArrayList;

public class EleveGomDAO extends _Generic<EleveGomEntity> {
    
    public EleveGomEntity getOneEleveGom(String id){
        EleveGomEntity entity = new EleveGomEntity();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleveGom WHERE id=?;");
            preparedStatement.setString(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                entity.setId(resultSet.getInt("id"));
                entity.setIdEleve(resultSet.getInt("idEleve"));
                entity.setIdGommette(resultSet.getInt("idGom"));
                entity.setDate(resultSet.getString("date"));
                entity.setIdProf(resultSet.getInt("idProf"));
                entity.setMotif(resultSet.getString("motif"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity; 
    }

    public ArrayList<EleveGomEntity> getAllEleveGomWithIdEleve(String idEleve){
        ArrayList<EleveGomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleveGom WHERE idEleve=? ORDER BY id ASC;");
            preparedStatement.setString(1, idEleve);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveGomEntity entity = new EleveGomEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setIdEleve(resultSet.getInt("idEleve"));
                entity.setIdGommette(resultSet.getInt("idGom"));
                entity.setDate(resultSet.getString("date"));
                entity.setMotif(resultSet.getString("motif"));
                entity.setIdProf(resultSet.getInt("idProf"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities; 
    }

    public ArrayList<EleveGomEntity> getAllEleveGomWithIdGom(String idGom){
        ArrayList<EleveGomEntity> entities = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = this.connect.prepareStatement("SELECT * FROM eleveGom WHERE idGom=? ORDER BY id ASC;");
            preparedStatement.setString(1, idGom);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                EleveGomEntity entity = new EleveGomEntity();
                entity.setId(resultSet.getInt("id"));
                entity.setIdEleve(resultSet.getInt("idEleve"));
                entity.setIdGommette(resultSet.getInt("idGom"));
                entity.setIdProf(resultSet.getInt("idProf"));
                entity.setDate(resultSet.getString("date"));
                entity.setMotif(resultSet.getString("motif"));
                entities.add(entity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entities; 
    }

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
                entity.setIdProf(resultSet.getInt("idProf"));
                entity.setDate(resultSet.getString("date"));
                entity.setMotif(resultSet.getString("motif"));                
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
            statement = connection.prepareStatement("INSERT INTO eleveGom(idEleve, idGom, date, motif, idProf) VALUES(?, ?, ?, ?, ?);");
            statement.setInt(1, obj.getEleve().getId());
            statement.setInt(2, obj.getGommette().getId());
            statement.setString(3, obj.getDate());  
            statement.setString(4, obj.getMotif());
            statement.setInt(5, obj.getProf().getId());
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