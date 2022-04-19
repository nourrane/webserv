package com.uca.dao;

import java.sql.*;

public class _Initializer {

    public static void Init(){
        Connection connection = _Connector.getInstance();
        // User (a enlever)
        try {
            PreparedStatement statement;

            // statement = connection.prepareStatement("DROP TABLE users;");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("DROP TABLE professeurs;");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("DROP TABLE login;");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("DROP TABLE eleveGom;");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("DROP TABLE eleves;");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("DROP TABLE goms;");
            // statement.executeUpdate();  

            // //Init professeurs 
               statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS professeurs (id int primary key auto_increment, firstname varchar(100), lastname varchar(100),password varchar(100)); ");
               statement.executeUpdate();  

            //Se connecter
            // statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS login (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            // statement.executeUpdate();  
            // statement = connection.prepareStatement("TRUNCATE TABLE login ; ");
            // statement.executeUpdate();  
           
            //Init eleves
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS eleves (id int primary key auto_increment, firstname varchar(100), lastname varchar(100)); ");
            statement.executeUpdate(); 

            //Init eleveGommette
            // statement = connection.prepareStatement("DROP TABLE eleveGom;");
            // statement.executeUpdate(); 
            //Init Gommettes
            statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS goms (id int primary key auto_increment, name varchar(100), description varchar(100), color varchar(100)); ");
            statement.executeUpdate();
                        
            

            String tmp="CREATE TABLE IF NOT EXISTS eleveGom (id int primary key auto_increment, idEleve int, FOREIGN KEY (idEleve) REFERENCES eleves (id), eleveFirstName varchar(100), FOREIGN KEY (eleveFirstName) REFERENCES eleves (firstname), idGom int, FOREIGN KEY (idGom) REFERENCES goms (id));";
            statement = connection.prepareStatement(tmp);
            statement.executeUpdate(); 


            //  a enlever
            //  statement = connection.prepareStatement("TRUNCATE TABLE goms ; ");
            //  statement.executeUpdate();  
            //  statement = connection.prepareStatement("INSERT INTO eleveGom ( idEleve, eleveFirstName,idGom) VALUES(?, ?, ?);");
            //  statement.setString(1, "5");
            //  statement.setString(2, (select customer_id from customer where name = 'John'));
            //  statement.setString(3, "5");
            //  statement.executeUpdate();
             
            
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