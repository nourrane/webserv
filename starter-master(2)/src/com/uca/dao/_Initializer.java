package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();
        // User (a enlever)
        try {
            PreparedStatement statement;

            //Init user
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS users (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            statement.executeUpdate();  
           

             //Init professeurs 

            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            statement.executeUpdate();  

            //Se connecter
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS login (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            statement.executeUpdate();  
            statement = connection.prepareStatement("TRUNCATE TABLE login ; ");
            statement.executeUpdate();  
           
            //Init eleves
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            statement.executeUpdate(); 
            
            //Init Gomettes
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS goms (id int primary key auto_increment, name varchar(100), description varchar(100), color varchar(100)); ");
            statement.executeUpdate();
            
             //a enlever
             /*
             statement = connection.prepareStatement("INSERT INTO goms (name, description,color) VALUES(?, ?, ?);");
             statement.setString(1, "Gommette");
             statement.setString(2, "Jette des boulettes sur ses camarades");
             statement.setString(3, "rouge");
             statement.executeUpdate();
             */
            
        } catch (Exception e){
            System.out.println(e.toString());
            throw new RuntimeException("could not create database !");
        }
    }
}

 //Todo Remove me !
            /*
            statement = connection.prepareStatement("INSERT INTO users(firstname, lastname) VALUES(?, ?);");
            statement.setString(1, "Theodore");
            statement.setString(2, "Muillerez");
            statement.executeUpdate();
            */